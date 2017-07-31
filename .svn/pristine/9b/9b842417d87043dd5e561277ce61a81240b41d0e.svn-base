package com.jzf.market.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzf.market.dao.TbConsumptionMapper;
import com.jzf.market.pojo.auto.TbConsumption;
import com.jzf.market.pojo.auto.TbConsumptionExample;
import com.jzf.market.pojo.auto.TbUser;


@Transactional
@Service
public class TbConsumptionService {
	@Autowired
	private TbConsumptionMapper tbConsumptionMapper;
	@Autowired
	private TbUserService tbUserService;
	
	/**
	 * 消费
	 * 
	 * 1.判断用户可用金额是否充足
	 * 		是:向消费表中添加数据,并扣除用户可用金额
	 *  	否:返回
	 * 2.判断用户消费总额是否大于10000，
	 * 		是：	1.判断用户类型,如果不是会员，则给用户分配角色(普通会员),并修改用户类型
	 * 			2.判断用户会员第几次消费
	 * 				第一次：计算当前金额的10%，添加消费表中,并修改用户表-->可用金额,递增消费次数
	 * 				第二次：计算当前金额的40%，添加消费表中,并修改用户可用金额-->可用金额,递增消费次数
	 * 				大于三次：计算当前金额的40%，添加消费表中,并修改用户可用金额-->可用金额,递增消费次数
	 * 		否：继续
	 * 3.
	 * 
	 * 
	 * 
	 * 1.判断用户可用金额是否充足
	 * 		是:向消费表中添加数据,并扣除用户可用金额
	 *  	否:返回
	 * 2.判断用户类型,是否是会员
	 * 		2.1.是会员：
	 * 			2.1.1.判断用户会员第几次消费
	 * 					第一次：计算当前金额的10%，添加消费表中,并修改用户表-->可用金额,递增消费次数
	 * 					第二次：计算当前金额的40%，添加消费表中,并修改用户可用金额-->可用金额,递增消费次数
	 * 					大于三次：计算当前金额的40%，添加消费表中,并修改用户可用金额-->可用金额,递增消费次数
	 * 		2.2.不是会员：
	 * 			2.2.1.判断用户消费总额是否大于10000
	 * 					2.2.1.1.是：2.2.1.1.1.给用户分配角色(普通会员),并修改用户类型
	 * 				   	   		   2.2.1.1.2.计算当前金额的10%，添加消费表中,并修改用户表-->可用金额,递增消费次数
	 * 					2.2.1.2.否：继续
	 * 3.判断用户是否有推荐人
	 * 		3.1.有：	
	 * 			3.1.1.判断推荐人用户类型，看当前层数是否可以拿佣金
	 * 			 		3.1.1.1.是：
	 * 							3.1.1.1.1.计算金额的10%，
	 * 								3.1.1.1.1.1.(10%*90%)向推荐人消费表添加数据,并修改推荐人用户表-->可用金额,总额
	 * 								3.1.1.1.1.2.(10%*10%)查找推荐人的所有直接下线,
	 * 												3.1.1.1.1.2.1.平分金额,并修改用户表-->可用金额,总额
	 * 												3.1.1.1.1.2.2.递归调用3.1.1.1.1.2
	 * 				   	    	3.1.1.1.2.递归调用3
	 * 					3.1.1.2.否：
	 * 							跳出递归.
	 * 		3.2.没有：
	 * 				继续
	 * 
	 * 
	 * @param money		消费金额
	 * @param tbUser	用户
	 * @return
	 */
	public int consumption(String money, TbUser tbUser) {
		BigDecimal moneyBigDecimal = new BigDecimal(money);
		//判断用户可用金额是否充足
		if(tbUser.getuUsableMoney().compareTo(moneyBigDecimal) < 0){
			return -1;
		}
		TbConsumption tbConsumption = new TbConsumption();
		tbConsumption.setcUId(tbUser.getuId());
		tbConsumption.setcMoney(moneyBigDecimal.multiply(new BigDecimal(-1)));
		tbConsumption.setcSource("消费");
		tbConsumption.setcCreateDate(new Date());
		//向消费表中添加数据
		int count = tbConsumptionMapper.insertSelective(tbConsumption);
		if(count == 0){
			return 0;
		}
		//扣除用户可用金额
		tbUser.setuUsableMoney(tbUser.getuUsableMoney().subtract(moneyBigDecimal));
		count = tbUserService.updateByUserId(tbUser);
		if(count == 0){
			return 0;
		}
		//判断用户类型,是否是会员,可立马享受自身消费额10%的销售额的提成，相当于9折，再次消费可享受4折-5折
		count = isUserType(tbUser, moneyBigDecimal);
		if(count == 0){
			return 0;
		}
		
		//判断用户是否有推荐人
		isReisterRecommender(tbUser,moneyBigDecimal,1);
		
//		tbUserService.
		return 1;
	}

	/**
	 * 
	 * 3.判断用户是否有推荐人
	 * 		3.1.有：	
	 * 			3.1.1.判断推荐人用户类型，看当前层数是否可以拿佣金
	 * 			 		3.1.1.1.是：
	 * 							3.1.1.1.1.计算金额的10%，
	 * 								3.1.1.1.1.1.(10%*90%)向推荐人消费表添加数据,并修改推荐人用户表-->可用金额,总额
	 * 								3.1.1.1.1.2.(10%*10%)查找推荐人的所有直接下线,
	 * 												3.1.1.1.1.2.1.平分金额,并修改用户表-->可用金额,总额
	 * 				   	    	3.1.1.1.2.递归调用3
	 * 					3.1.1.2.否：
	 * 							跳出递归.
	 * 		3.2.没有：
	 * 				继续
	 * 
	 * @param tbUser
	 * @param moneyBigDecimal
	 * @param number
	 */
	private void isReisterRecommender(TbUser tbUser,
			BigDecimal moneyBigDecimal, int number) {
		String reisterRecommenderAccount = tbUser.getuReisterRecommenderAccount();
		if(reisterRecommenderAccount != null && !reisterRecommenderAccount.equals("")){
			//有：判断推荐人用户类型，看当前层数是否可以拿佣金
			TbUser reisterRecommenderTbUser = tbUserService.findTbUserByAccount(reisterRecommenderAccount);
			if(reisterRecommenderTbUser != null){
				//计算金额;直推会员：消费额10%;二层会员：消费额15%;三～九层会员：消费额3%
				BigDecimal proportion = null;
				if(number == 1){
					proportion = new BigDecimal("0.1");
				}else if(number == 2){
					proportion = new BigDecimal("0.15");
				}else{
					proportion = new BigDecimal("0.03");
				}
				BigDecimal multiply = moneyBigDecimal.multiply(proportion);
				//修改推荐人用户表-->可用金额,总额
				reisterRecommenderTbUser.setuSumMoney(reisterRecommenderTbUser.getuSumMoney().add(multiply.multiply(new BigDecimal("0.9"))));
				reisterRecommenderTbUser.setuUsableMoney(reisterRecommenderTbUser.getuUsableMoney().add(multiply.multiply(new BigDecimal("0.9"))));
				//向推荐人消费表添加数据
				TbConsumption tbConsumption = new TbConsumption();
				tbConsumption.setcUId(reisterRecommenderTbUser.getuId());
				tbConsumption.setcMoney(multiply.multiply(new BigDecimal("0.9")));
				tbConsumption.setcSource(tbUser.getuAccount()+"用户消费返利");
				tbConsumption.setcCreateDate(new Date());
				
				
				if(reisterRecommenderTbUser.getuType().equals("1")){
					if(number <= 2){
						tbUserService.updateByUserId(reisterRecommenderTbUser);
						tbConsumptionMapper.insertSelective(tbConsumption);
						//查找推荐人的所有直接下线,平分金额,并修改用户表-->可用金额,总额
						divideMoney(reisterRecommenderTbUser,multiply.multiply(new BigDecimal("0.1")));
						isReisterRecommender(reisterRecommenderTbUser,moneyBigDecimal,++number);
					}
				}else if(reisterRecommenderTbUser.getuType().equals("2")){
					if(number <= 5){
						tbUserService.updateByUserId(reisterRecommenderTbUser);
						tbConsumptionMapper.insertSelective(tbConsumption);
						//查找推荐人的所有直接下线,平分金额,并修改用户表-->可用金额,总额
						divideMoney(reisterRecommenderTbUser,multiply.multiply(new BigDecimal("0.1")));
						isReisterRecommender(reisterRecommenderTbUser,moneyBigDecimal,++number);
					}
				}else if(reisterRecommenderTbUser.getuType().equals("3") || reisterRecommenderTbUser.getuType().equals("5")){
					if(number <= 9){
						tbUserService.updateByUserId(reisterRecommenderTbUser);
						tbConsumptionMapper.insertSelective(tbConsumption);
						//查找推荐人的所有直接下线,平分金额,并修改用户表-->可用金额,总额
						divideMoney(reisterRecommenderTbUser,multiply.multiply(new BigDecimal("0.1")));
						isReisterRecommender(reisterRecommenderTbUser,moneyBigDecimal,++number);
					}
				}
			}
			
			
		}
		
	}

	/**
	 * 查找推荐人的所有直接下线,平分金额,并修改用户表-->可用金额,总额；向下线消费表添加数据
	 * 
	 * 
	 * @param reisterRecommenderTbUser
	 * @param multiply
	 */
	private void divideMoney(TbUser reisterRecommenderTbUser,
			BigDecimal multiply) {
		List<TbUser> tbUsers = tbUserService.tapeoutNumber(reisterRecommenderTbUser.getuAccount());
		if(tbUsers != null && tbUsers.size() != 0){
			int number = tbUsers.size();
			//平分金额
			BigDecimal divide = multiply.divide(new BigDecimal(number),2, RoundingMode.HALF_UP);
			
			for(TbUser tbUser : tbUsers){
				tbUser.setuSumMoney(tbUser.getuSumMoney().add(divide));
				tbUser.setuUsableMoney(tbUser.getuUsableMoney().add(divide));
				tbUserService.updateByUserId(tbUser);
				
				//向下线消费表添加数据
				TbConsumption tbConsumption = new TbConsumption();
				tbConsumption.setcUId(tbUser.getuId());
				tbConsumption.setcMoney(divide);
				tbConsumption.setcSource(reisterRecommenderTbUser.getuAccount()+"推荐人收益返利");
				tbConsumption.setcCreateDate(new Date());
				tbConsumptionMapper.insertSelective(tbConsumption);
				
			}
			
			
			
		}
	}

	/**
	 * 
	 * 2.判断用户类型,是否是会员
	 * 		2.1.是会员：
	 * 			2.1.1.判断用户会员第几次消费
	 * 					第一次：计算当前金额的10%，添加消费表中,并修改用户表-->可用金额,递增消费次数
	 * 					第二次：计算当前金额的40%，添加消费表中,并修改用户可用金额-->可用金额,递增消费次数
	 * 					大于三次：计算当前金额的40%，添加消费表中,并修改用户可用金额-->可用金额,递增消费次数
	 * 		2.2.不是会员：
	 * 			2.2.1.判断用户消费总额是否大于10000
	 * 					2.2.1.1.是：2.2.1.1.1.给用户分配角色(普通会员),并修改用户类型
	 * 				   	   		   2.2.1.1.2.计算当前金额的10%，添加消费表中,并修改用户表-->可用金额,递增消费次数
	 * 					2.2.1.2.否：继续
	 * 
	 * @param tbUser
	 * @param moneyBigDecimal
	 */
	private int isUserType(TbUser tbUser, BigDecimal moneyBigDecimal) {
		int count = 1;
		if(tbUser.getuType().equals("0")){
			//不是会员,判断用户消费总额是否大于10000
			if(consumptionRental(tbUser.getuId()).compareTo(new BigDecimal("10000")) >= 0){
				//是：给用户分配角色(普通会员),并修改用户类型;计算当前金额的10%，添加消费表中,并修改用户表-->可用金额,递增消费次数
				tbUser.setuType("4");
				tbUser.setuUsableMoney(tbUser.getuUsableMoney().add(moneyBigDecimal.multiply(new BigDecimal("0.1"))));
				tbUser.setuConsumptionNumber(tbUser.getuConsumptionNumber()+1);
				count = tbUserService.updateByUserId(tbUser);
				if(count == 0){
					return 0;
				}

                //向下线消费表添加数据
                TbConsumption tbConsumption = new TbConsumption();
                tbConsumption.setcUId(tbUser.getuId());
                tbConsumption.setcMoney(moneyBigDecimal.multiply(new BigDecimal("0.1")));
                tbConsumption.setcSource("升级为会员后第一次购买返利10%");
                tbConsumption.setcCreateDate(new Date());
                tbConsumptionMapper.insertSelective(tbConsumption);
			}
			
		}else{
			BigDecimal multiply = null;
			String source = "";
			//是会员：判断用户会员第几次消费
			if(tbUser.getuConsumptionNumber() == 0){
				//第一次：计算当前金额的10%，添加消费表中,并修改用户表-->可用金额,递增消费次数
				multiply = moneyBigDecimal.multiply(new BigDecimal("0.1"));
                source = "升级为会员后第"+((tbUser.getuConsumptionNumber())+1)+"次购买返利10%";
				
			}else if(tbUser.getuConsumptionNumber() == 1){
				 //第二次：计算当前金额的40%，添加消费表中,并修改用户可用金额-->可用金额,递增消费次数
				multiply = moneyBigDecimal.multiply(new BigDecimal("0.45"));
                source = "升级为会员后第"+((tbUser.getuConsumptionNumber())+1)+"次购买返利45%";
				
			}else if(tbUser.getuConsumptionNumber() >= 2){
				 //大于三次：计算当前金额的40%，添加消费表中,并修改用户可用金额-->可用金额,递增消费次数
				multiply = moneyBigDecimal.multiply(new BigDecimal("0.45"));
                source = "升级为会员后第"+((tbUser.getuConsumptionNumber())+1)+"次购买返利45%";
				
			}
			tbUser.setuUsableMoney(tbUser.getuUsableMoney().add(multiply));
			tbUser.setuConsumptionNumber(tbUser.getuConsumptionNumber()+1);
			count = tbUserService.updateByUserId(tbUser);
			if(count == 0){
				return 0;
			}

            //向下线消费表添加数据
            TbConsumption tbConsumption = new TbConsumption();
            tbConsumption.setcUId(tbUser.getuId());
            tbConsumption.setcMoney(multiply);
            tbConsumption.setcSource(source);
            tbConsumption.setcCreateDate(new Date());
            tbConsumptionMapper.insertSelective(tbConsumption);
		}
		return count;
	}

	private BigDecimal consumptionRental(Long uId) {
		TbConsumptionExample tbConsumptionExample = new TbConsumptionExample();
		tbConsumptionExample.createCriteria().andCUIdEqualTo(uId);
		List<TbConsumption> tbConsumptions = tbConsumptionMapper.selectByExample(tbConsumptionExample);
		if(tbConsumptions == null || tbConsumptions.size() == 0){
			return null;
		}
		BigDecimal bigDecimal = new BigDecimal("0");
		for(TbConsumption TbConsumption : tbConsumptions){
			if(TbConsumption.getcMoney().signum() == -1){
				bigDecimal = bigDecimal.subtract(TbConsumption.getcMoney());
			}

		}
		
		return bigDecimal;
	}


    public Map<String,Object> selectAll(Long userId, Integer pageNum, Integer pageSize) {
		TbConsumptionExample tbConsumptionExample = new TbConsumptionExample();
		//分页处理，显示第一页的10条数据
		PageHelper.startPage(pageNum, pageSize,"c_create_date desc");

		tbConsumptionExample.createCriteria().andCUIdEqualTo(userId);
		List<TbConsumption> tbConsumptions = tbConsumptionMapper.selectByExample(tbConsumptionExample);
		if(tbConsumptions == null){
			tbConsumptions = new ArrayList<TbConsumption>();
		}
		// 取分页信息
		PageInfo<TbConsumption> pageInfo = new PageInfo<TbConsumption>(tbConsumptions);
//		long total = pageInfo.getTotal(); //获取总记录数

		Map<String,Object> map = new HashMap<>();
		map.put("tbConsumptions",tbConsumptions);
		map.put("pageInfo",pageInfo);
		return map;
	}

	public int insertSelective(TbConsumption tbConsumption) {
        tbConsumption.setcCreateDate(new Date());
		return tbConsumptionMapper.insertSelective(tbConsumption);
	}
}
