package com.jzf.market.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzf.market.pojo.auto.TbEarnings;
import com.jzf.market.service.TbEarningsService;

@Controller
@RequestMapping("/TbEarnings")
public class TbEarningsController {
	@Autowired
	private TbEarningsService tbEarningsService;
	
	/**
	 * 查找所有收益比例
	 * @return
	 */
	@RequestMapping("/selectAll")
	public @ResponseBody Map<String, Object> selectAll() {
		Map<String, Object> message = new HashMap<String, Object>();
		
		List<TbEarnings> tbEarningss = tbEarningsService.selectAll();
		message.put("status", "1");
		message.put("message", "查找成功");
		message.put("tbEarningss", tbEarningss);
		return message;
	}
	
	/**
	 * 修改收益比例
	 * @return
	 */
	@RequestMapping("/updateById")
	public @ResponseBody Map<String, Object> updateById(TbEarnings tbEarnings) {
		Map<String, Object> message = new HashMap<String, Object>();
		if(tbEarnings.geteId() == null ||tbEarnings.geteId().equals("")){
			message.put("status", "0");
			message.put("message", "请输入收益ID");
			return message;
		}
		if(tbEarnings.geteValue() == null){
			message.put("status", "0");
			message.put("message", "请输入收益比例");
			return message;
		}else if(tbEarnings.geteValue() <= 0 || tbEarnings.geteValue() > 100){
			message.put("status", "0");
			message.put("message", "不在收益比例范围内");
			return message;
		}
		
		int count = tbEarningsService.updateById(tbEarnings);
		if(count == 0){
			message.put("status", "0");
			message.put("message", "修改失败");
		}else{
			message.put("status", "1");
			message.put("message", "修改成功");
		}
		
		return message;
	}
}
