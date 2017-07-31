package com.jzf.market.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzf.market.common.utils.DateUtil;
import com.jzf.market.dao.TbPhoneVerificationMapper;
import com.jzf.market.pojo.auto.TbPhoneVerification;
import com.jzf.market.pojo.auto.TbPhoneVerificationExample;

@Transactional
@Service
public class TbPhoneVerificationService {
	@Autowired
	private TbPhoneVerificationMapper tbPhoneVerificationMapper;
	
	public int verification(String phoneNumber, String verificationCode) {
		TbPhoneVerification tbPhoneVerification = findByphone(phoneNumber);
		if(tbPhoneVerification == null){
			return 0;
		}
		if(tbPhoneVerification.getPvVerificationCode().equals(verificationCode)){
			if(!DateUtil.isDateExceed(tbPhoneVerification.getPvCreateDate(), 5)){
				return 1;
			}
		}
		return 0;
	}
	
	private TbPhoneVerification findByphone(String phoneNumber) {
		TbPhoneVerificationExample tbPhoneVerificationExample = new TbPhoneVerificationExample();
		tbPhoneVerificationExample.createCriteria().andPvPhoneEqualTo(phoneNumber);
		List<TbPhoneVerification> tbPhoneVerifications = tbPhoneVerificationMapper.selectByExample(tbPhoneVerificationExample);
		if(tbPhoneVerifications == null || tbPhoneVerifications.size() == 0){
			return null;
		}
		return tbPhoneVerifications.get(0);
	}

	public int isObtainVerificationCode(String phone) {
		TbPhoneVerification tbPhoneVerification = findByphone(phone);
		if(tbPhoneVerification == null){
			return 0;
		}
		if(!DateUtil.isDateExceed(tbPhoneVerification.getPvCreateDate(), 5)){
			return 1;
		}
		
		return 0;
	}

	public int insert(String phone, Integer number) {
		//如果存在则先删除后添加
		TbPhoneVerification tbPhoneVerification = findByphone(phone);
		int count = 0;
		if(tbPhoneVerification != null){
			count = tbPhoneVerificationMapper.deleteByPrimaryKey(tbPhoneVerification.getPvId());
			if(count == 0){
				return 0;
			}
		}
		tbPhoneVerification = new TbPhoneVerification();
		tbPhoneVerification.setPvPhone(phone);
		tbPhoneVerification.setPvVerificationCode(number+"");
		tbPhoneVerification.setPvCreateDate(new Date());
		
		return tbPhoneVerificationMapper.insertSelective(tbPhoneVerification);
	}
}
