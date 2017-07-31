package com.jzf.market.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jzf.market.pojo.auto.TbConsumption;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzf.market.common.config.shiro.realm.AccountRealm;
import com.jzf.market.common.utils.SmsClient;
import com.jzf.market.common.utils.VerificationCode;
import com.jzf.market.dao.TbUserMapper;
import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.pojo.auto.TbUserExample;

@Transactional
@Service
public class TbUserService {
	@Autowired
	private TbUserMapper tbUserMapper;
	@Autowired
	private TbPhoneVerificationService tbPhoneVerificationService;
    @Autowired
    private TbConsumptionService tbConsumptionService;

	public TbUser findById(Long uId) {
		return tbUserMapper.selectByPrimaryKey(uId);
	}

	
	/**
	 * 1.向用户表添加数据
	 * 2.查看用户是否填推荐人
	 * 		2.1有
	 * 			2.1.1：查找推荐人有多少个下线，更新推荐人用户类型,并授予角色
	 * 		2.2没有：继续
	 * 
	 * @param tbUser	用户信息
	 * @return
	 */
	public int insert(TbUser tbUser) {
		//判断推荐人是否存在
		TbUser reisterRecommenderTbUser = null;
		if(tbUser.getuReisterRecommenderAccount() != null && !tbUser.getuReisterRecommenderAccount().equals("")){
			reisterRecommenderTbUser = findTbUserByAccount(tbUser.getuReisterRecommenderAccount());
			if(reisterRecommenderTbUser == null){
				return -1;
			}
			if(reisterRecommenderTbUser.getuType().equals("0")){
				return -2;
			}
			
			tbUser.setuReisterRecommender(reisterRecommenderTbUser.getuName());
		}
		
		// shiro
		Md5Hash md5Hash = new Md5Hash(tbUser.getuPassword(),
				ByteSource.Util.bytes(AccountRealm.SALT),
				AccountRealm.HASH_ITERATIONS);
		String pass_md5 = md5Hash.toString();
		
		tbUser.setuAuthentication("0");
		tbUser.setuType("0");
		tbUser.setuCreateDate(new Date());
		tbUser.setuSumMoney(new BigDecimal("0"));
		tbUser.setuUsableMoney(new BigDecimal("0"));
		tbUser.setuConsumptionNumber(0);
		tbUser.setuPassword(pass_md5);
		
		int count = tbUserMapper.insertSelective(tbUser);
		if(count == 0){
			return 0;
		}
		
		if(reisterRecommenderTbUser != null){
			//查询推荐人有多少个下线
			long number = tapeoutNumber(reisterRecommenderTbUser.getuAccount()).size();
			if(number == 1){
				//银卡会员
				reisterRecommenderTbUser.setuType("1");
				
			}else if(number == 2){
				//金卡会员
				reisterRecommenderTbUser.setuType("2");
				
			}else if(number == 3){
				//铂金会员
				reisterRecommenderTbUser.setuType("3");
				
			}
			count = updateByUserId(reisterRecommenderTbUser);
		}
		
		return count;
	}


	/**
     * 查询我的下线
	 * @param account
	 * @return
	 */
	public List<TbUser> tapeoutNumber(String account) {
		TbUserExample tbUserExample = new TbUserExample();
		tbUserExample.createCriteria().andUReisterRecommenderAccountEqualTo(account);
		 List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
		return tbUsers;
	}


	public TbUser findTbUserByPhone(String phone) {
		TbUserExample tbUserExample = new TbUserExample();
		tbUserExample.createCriteria().andUPhoneEqualTo(phone);
		List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
		if(tbUsers == null || tbUsers.size() == 0){
			return null;
		}
		return tbUsers.get(0);
	}


	public TbUser findTbUserByAccount(String account) {
		TbUserExample tbUserExample = new TbUserExample();
		tbUserExample.createCriteria().andUAccountEqualTo(account);
		List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
		if(tbUsers == null || tbUsers.size() == 0){
			return null;
		}
		return tbUsers.get(0);
	}


	public int updatePass(Long uId, String passwd) {
		// shiro
		Md5Hash md5Hash = new Md5Hash(passwd,
				ByteSource.Util.bytes(AccountRealm.SALT),
				AccountRealm.HASH_ITERATIONS);
		String pass_md5 = md5Hash.toString();
		
		TbUser tbUser = new TbUser();
		tbUser.setuId(uId);
		tbUser.setuPassword(pass_md5);
		return tbUserMapper.updateByPrimaryKeySelective(tbUser);
	}


	public int updateByUserId(TbUser tbUser) {
		return tbUserMapper.updateByPrimaryKeySelective(tbUser);
	}


	/**
	 * 获取我的第几级下线
	 * @param number	需要第几级下线
	 * @param current	当前第几级
	 * @return
	 */
	public List<TbUser> selectMember(TbUser currentTbUser,Integer current,Integer number) {
		++current;
		List<TbUser> list = new ArrayList<TbUser>();
		/*if(currentTbUser.getuType().equals("0")){
			return list;
		}else if(currentTbUser.getuType().equals("1")){

		}else if(currentTbUser.getuType().equals("2")){

		}else if(currentTbUser.getuType().equals("3")){

		}else if(currentTbUser.getuType().equals("4")){

		}else if(currentTbUser.getuType().equals("5")){

		}*/

		//我的下线
		List<TbUser> tbUsers = findUserByReisterRecomenderPhone(currentTbUser.getuAccount());

		for(TbUser tbUser : tbUsers){
			if(current < number){
				List<TbUser> selectMember = selectMember(tbUser,current,number);
				list.addAll(selectMember);
			}else{
				list.add(tbUser);
			}
		}
		return list;
	}
	
	/**
	 * 获取指定用户的直接下线
	 * @param account
	 * @return
	 */
	private List<TbUser> findUserByReisterRecomenderPhone(String account) {
		TbUserExample tbUserExample = new TbUserExample();
		tbUserExample.createCriteria().andUReisterRecommenderAccountEqualTo(account);
		List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
		return tbUsers;
	}


	public int register(TbUser tbUser,String verificationCode) {
		//判断验证码是否有效
		int count = tbPhoneVerificationService.verification(tbUser.getuPhone(),verificationCode);
		if(count == 0){
			return -2;
		}

		TbUser Recommender = null;
		if(tbUser.getuReisterRecommenderAccount() != null && !tbUser.getuReisterRecommenderAccount().equals("")){
			//判断推荐人是否有效
			Recommender = findTbUserByAccount(tbUser.getuReisterRecommenderAccount());
			if(Recommender == null){
				return -1;
			}
			
			if(Recommender.getuType().equals("0")){
				return -3;
			}
			tbUser.setuReisterRecommender(Recommender.getuName());
		}
		
		// shiro
		Md5Hash md5Hash = new Md5Hash(tbUser.getuPassword(),
				ByteSource.Util.bytes(AccountRealm.SALT),
				AccountRealm.HASH_ITERATIONS);
		String pass_md5 = md5Hash.toString();
		
		tbUser.setuAuthentication("0");
		tbUser.setuName(tbUser.getuPhone()+"");
		tbUser.setuType("0");
		tbUser.setuCreateDate(new Date());
		tbUser.setuSumMoney(new BigDecimal("0"));
		tbUser.setuUsableMoney(new BigDecimal("0"));
		tbUser.setuConsumptionNumber(0);
		tbUser.setuPassword(pass_md5);
		tbUser.setuHeadPortrait("logo.jpg");
		tbUser.setuAccount(tbUser.getuPhone());
		
		count = tbUserMapper.insertSelective(tbUser);
		if(count == 0){
			return 0;
		}

		if(Recommender != null){
			//查询推荐人有多少个下线
			long number = tapeoutNumber(Recommender.getuAccount()).size();
			if(number == 1){
				//银卡会员
				Recommender.setuType("1");

			}else if(number == 2){
				//金卡会员
				Recommender.setuType("2");

			}else if(number == 3){
				//铂金会员
				Recommender.setuType("3");

			}
			count = updateByUserId(Recommender);
		}

		return count;
	}


	/**
	 * 
	 * @param phone
	 * @param type	0:注册，1：忘记密码
	 * @return
	 */
	public int obtainVerificationCode(String phone,Integer type) {
		
		if(type == 0){
			//判断手机号是否注册过
			TbUser user = findTbUserByAccount(phone);
			if(user != null){
				return -2;
			}
		}
		
		//先判断手机号5分钟内有没有获取过验证码
		int count = tbPhoneVerificationService.isObtainVerificationCode(phone);
		if(count == 1){
			return -1;
		}
		
		Integer number = VerificationCode.generateByPhone();
		//发送短信
		SmsClient.send(phone, number);
		//保存数据库
		count = tbPhoneVerificationService.insert(phone,number);
		return count;
	}


	public int forgetPass(String account,String password, String verificationCode) {
		//判断验证码是否有效
		int count = tbPhoneVerificationService.verification(account,verificationCode);
		if(count == 0){
			return -2;
		}
		// shiro
		Md5Hash md5Hash = new Md5Hash(password,
				ByteSource.Util.bytes(AccountRealm.SALT),
				AccountRealm.HASH_ITERATIONS);
		String pass_md5 = md5Hash.toString();
		
				
		TbUser tbUser = new TbUser();
		tbUser.setuPassword(pass_md5);
		
		TbUserExample tbUserExample = new TbUserExample();
		tbUserExample.createCriteria().andUAccountEqualTo(account);
		return tbUserMapper.updateByExampleSelective(tbUser, tbUserExample);
	}

    public int recharge(String uAccount, String money) {
		TbUser tbUser = findTbUserByAccount(uAccount);
		if(tbUser == null){
			return -1;
		}

        BigDecimal moneyBigDecimal = new BigDecimal(money);

		tbUser.setuSumMoney(tbUser.getuSumMoney().add(moneyBigDecimal));
		tbUser.setuUsableMoney(tbUser.getuUsableMoney().add(moneyBigDecimal));
		int count = tbUserMapper.updateByPrimaryKeySelective(tbUser);
		if(count == 0){
			return 0;
		}

        TbConsumption tbConsumption = new TbConsumption();
        tbConsumption.setcUId(tbUser.getuId());
        tbConsumption.setcMoney(moneyBigDecimal);
        tbConsumption.setcSource("充值");
        //向消费表中添加数据
        return tbConsumptionService.insertSelective(tbConsumption);
	}


}
