package com.jzf.market.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzf.market.dao.TbAuthenticationMapper;
import com.jzf.market.pojo.auto.TbAuthentication;
import com.jzf.market.pojo.auto.TbUser;

/**
 * 认证
 * @author feng
 *
 * 2017年1月11日 下午4:02:19
 */
@Transactional
@Service
public class TbAuthenticationService {
	@Autowired
	private TbAuthenticationMapper tbAuthenticationMapper;
	@Autowired
	private TbUserService tbUserService;

	public int insert(TbUser tbUser, TbAuthentication tbAuthentication) {
		tbUser.setuAuthentication("1");
		tbUser.setuAuthDate(new Date());
		tbUser.setuSumMoney(null);
		tbUser.setuUsableMoney(null);
		int count = tbUserService.updateByUserId(tbUser);
		if(count == 0){
			return 0;
		}
		tbAuthentication.setaUId(tbUser.getuId());
		tbAuthentication.setaCreateDate(new Date());
		return tbAuthenticationMapper.insertSelective(tbAuthentication);
	}
	
	
	
}
