package com.jzf.market.controller.app;

import com.jzf.market.pojo.auto.TbAuthentication;
import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.service.TbAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证
 * @author feng
 *
 * 2017年1月11日 下午4:02:33
 */
@Controller
@RequestMapping("/TbAuthenticationApp")
public class TbAuthenticationAppController extends BaseAPPController {
	@Autowired
	private TbAuthenticationService tbAuthenticationService;

	/**
	 * 添加认证信息
	 * @return
	 */
	@RequestMapping("/insert")
	public @ResponseBody Map<String, Object> insert(String TokenID,TbAuthentication tbAuthentication) {
		Map<String, Object> message = new HashMap<String, Object>();

		TbUser tbUser = null;
		if (isAuthenticated(TokenID)) {
			Object object = findUserInfo(TokenID);
			if (object instanceof TbUser) {
				tbUser = (TbUser) object;
			}
		} else {
			message.put("status", "0");
			message.put("message", "您还没有登陆");
			return message;
		}

		int count = tbAuthenticationService.insert(tbUser,tbAuthentication);
		if(count == 0){
			message.put("status", "0");
			message.put("message", "认证失败");
		}else{
			message.put("status", "1");
			message.put("message", "认证成功");
		}
		return message;
	}


}
