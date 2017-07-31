package com.jzf.market.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzf.market.dao.TbEarningsMapper;
import com.jzf.market.pojo.auto.TbEarnings;
import com.jzf.market.pojo.auto.TbEarningsExample;

@Transactional
@Service
public class TbEarningsService {
	@Autowired
	private TbEarningsMapper tbEarningsMapper;

	public List<TbEarnings> selectAll() {
		TbEarningsExample tbEarningsExample = new TbEarningsExample();
		
		List<TbEarnings> tbEarningss = tbEarningsMapper.selectByExample(tbEarningsExample);
		if(tbEarningss == null){
			tbEarningss = new ArrayList<TbEarnings>();
		}
		return tbEarningss;
	}

	public int updateById(TbEarnings tbEarnings) {
		tbEarnings.seteCreateDate(new Date());
		return tbEarningsMapper.updateByPrimaryKeySelective(tbEarnings);
	}
	
	
}
