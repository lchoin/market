package com.jzf.market.controller.web;

import com.jzf.market.common.config.shiro.realm.AccountRealm;
import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.service.TbConsumptionService;
import com.jzf.market.service.TbUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/TbUser")
public class TbUserController extends BaseController{
	@Autowired
	private TbUserService tbUserService;
	@Autowired
	private TbConsumptionService tbConsumptionService;
	
	// 登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
		@RequestMapping("/login")
		public String login(HttpServletRequest request) throws Exception {

			// 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
			String exceptionClassName = (String) request
					.getAttribute("shiroLoginFailure");
			// 根据shiro返回的异常类路径判断，抛出指定异常信息
			if (exceptionClassName != null) {
				if (UnknownAccountException.class.getName().equals(
						exceptionClassName)) {
					// 最终会抛给异常处理器
//					request.setAttribute("message", "账号不存在/账户已锁定");
				} else if (IncorrectCredentialsException.class.getName().equals(
						exceptionClassName)) {
//					request.setAttribute("message", "用户名/密码错误");
				} else if (AuthenticationException.class.getName().equals(
						exceptionClassName)) {
//					request.setAttribute("message", "用户名/密码错误");
				} else if ("randomCodeError".equals(exceptionClassName)) {
//					request.setAttribute("message", "验证码错误");
				} else {
					throw new Exception(exceptionClassName);// 最终在异常处理器生成未知错误
				}
			}
			// 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
			// 登陆失败还到login页面
			return "/login.html";
		}
		
		@RequestMapping("/ajaxLogin")
		public @ResponseBody Map<String, Object> ajaxLogin(String username,
				String password) {
			Map<String, Object> message = new HashMap<String, Object>();

			Subject currentUser = SecurityUtils.getSubject();
			// 填充数据
			if (!currentUser.isAuthenticated()) {
				UsernamePasswordToken token = new UsernamePasswordToken(username,
						password);
				try {
					currentUser.login(token);
					Serializable id = currentUser.getSession().getId();
					// 取身份信息
					TbUser userInfo = (TbUser) currentUser.getPrincipal();
					message.put("status", "1");
					message.put("message", "登陆成功");
					message.put("userInfo", userInfo);
				} catch (UnknownAccountException ex) {
					message.put("status", "0");
					message.put("message", "账号错误/账号已锁定");
				} catch (IncorrectCredentialsException ex) {
					message.put("status", "-1");
					message.put("message", "密码错误");
				} catch (LockedAccountException ex) {
					message.put("status", "-2");
					message.put("message", "账号已被锁定，请与管理员联系");
				} catch (AuthenticationException ex) {
					message.put("status", "-4");
					message.put("message", "您没有授权");
				}
			} else {
				message.put("status", "-5");
				message.put("message", "用户已登陆,请退出登录或重启客户端!");
			}

			return message;
		}

	/**
	 * 退出登陆
	 */
	@RequestMapping("/ajaxLogout")
	public @ResponseBody Map<String, Object> ajaxLogout() {
		Map<String, Object> message = new HashMap<String, Object>();


        if (isAuthenticated()) {

        } else {
            message.put("status", "0");
            message.put("message", "您还没有登陆");
            return message;
        }

        try {
			logout();
		} catch (Exception e) {
			e.printStackTrace();
			message.put("status", "0");
			message.put("message", "退出失败，请重试");
			return message;

		}
		message.put("status", "1");
		message.put("message", "退出登陆成功");
		return message;

	}
		
		/**
		 * 注册用户
		 * @param tbUser	用户信息
		 * @return
		 */
//		@RequestMapping("/register")
		public @ResponseBody Map<String, Object> register(TbUser tbUser) {
			Map<String, Object> message = new HashMap<String, Object>();
			
			int count = tbUserService.insert(tbUser);
			if(count == 0){
				message.put("status", "0");
				message.put("message", "注册失败");
			}else if(count == -1){
				message.put("status", "-1");
				message.put("message", "推荐人不存在");
			}else if(count == -2){
				message.put("status", "-2");
				message.put("message", "推荐人不是会员");
			}else{
				message.put("status", "1");
				message.put("message", "注册成功");
			}
			return message;
		}
		
		/**
		 * 注册用户(手机号注册)
		 * 填入手机号，账号默认为手机号
		 * @return
		 */
		@RequestMapping("/registerByPhone")
		public @ResponseBody Map<String, Object> register(TbUser tbUser,String verificationCode) {
			Map<String, Object> message = new HashMap<String, Object>();
			
			if(tbUser.getuPassword() == null || tbUser.getuPassword().equals("")){
				message.put("status", "0");
				message.put("message", "请输入密码");
				return message;
			}
			
			//判断手机号是否使用
			message = isRegister(tbUser.getuPhone());
			if(message.get("status").equals("0")){
				return message;
			}
			
			int count = tbUserService.register(tbUser,verificationCode);
			if(count == 0){
				message.put("status", "0");
				message.put("message", "注册失败");
			}else if(count == -1){
				message.put("status", "-1");
				message.put("message", "推荐人不存在");
			}else if(count == -2){
				message.put("status", "-2");
				message.put("message", "验证码错误");
			}else if(count == -3){
				message.put("status", "-3");
				message.put("message", "推荐人不是会员");
			}else{
				message.put("status", "1");
				message.put("message", "注册成功");
			}
			return message;
		}
		
		/**
		 * 查看手机号是否可用
		 * @return
		 */
		@RequestMapping("/isRegister")
		public @ResponseBody Map<String, Object> isRegister(String phone) {
			Map<String, Object> message = new HashMap<String, Object>();
			
			if(phone == null || phone.equals("")){
				message.put("status", "0");
				message.put("message", "请输入手机号");
				return message;
			}
			
			TbUser user = tbUserService.findTbUserByAccount(phone);
			if(user == null){
				message.put("status", "1");
				message.put("message", "手机号没有注册,可以使用");
			}else{
				message.put("status", "0");
				message.put("message", "手机号已经注册");
			}
			
			return message;
		}
		
		/**
		 * 获取验证码
		 * @param type	0:注册，1：忘记密码
		 * @return
		 */
		@RequestMapping("/obtainVerificationCode")
		public @ResponseBody Map<String, Object> obtainVerificationCode(String phone,Integer type) {
			Map<String, Object> message = new HashMap<String, Object>();
			if(phone == null || phone.equals("")){
				message.put("status", "0");
				message.put("message", "请输入手机号");
				return message;
			}
			
			int count = tbUserService.obtainVerificationCode(phone,type);
			if(count == 0){
				message.put("status", "0");
				message.put("message", "发送失败");
			}else if(count == -1){
				message.put("status", "-1");
				message.put("message", "获取验证码频繁,请5分钟后重试..");
			}else if(count == -2){
				message.put("status", "-2");
				message.put("message", "手机号已经注册过");
			}else{
				message.put("status", "1");
				message.put("message", "发送成功");
			}
			
			return message;
		}
		
		/**
		 * 忘记密码
		 * @return
		 */
		@RequestMapping("/forgetPassByAccount")
		public @ResponseBody Map<String, Object> forgetPassByAccount(String account,String pass,String verificationCode) {
			Map<String, Object> message = new HashMap<String, Object>();
			//判断手机号是否使用
			message = isRegister(account);
			if(message.get("status").equals("1")){
				message.put("message", "手机号没有注册");
				return message;
			}
			
			int count = tbUserService.forgetPass(account,pass,verificationCode);
			if(count == 0){
				message.put("status", "0");
				message.put("message", "修改失败");
			}else if(count == -2){
				message.put("status", "-2");
				message.put("message", "验证码错误");
			}else{
				message.put("status", "1");
				message.put("message", "修改成功");
			}
			return message;
		}
		
		
		/**
		 * 消费接口
		 * @param money	消费金额
		 * @return
		 */
//		@RequestMapping("/consumption")
		public @ResponseBody Map<String, Object> consumption(String money) {
			Map<String, Object> message = new HashMap<String, Object>();
			if(money == null || money.equals("")){
				message.put("status", "0");
				message.put("message", "请输入消费金额");
				return message;
			}else{
				BigDecimal bigDecimal = new BigDecimal(money);
				if(bigDecimal.compareTo(new BigDecimal("0")) <= 0){
					message.put("status", "0");
					message.put("message", "消费金额请输入大于0");
					return message;
				}
			}
			
			TbUser tbUser = null;
			if (isAuthenticated()) {
				Object object = findUserInfo();
				if (object instanceof TbUser) {
					tbUser = (TbUser) object;
				}
			} else {
				message.put("status", "0");
				message.put("message", "您还没有登陆");
				return message;
			}
			
			int count = tbConsumptionService.consumption(money,tbUser);
			if(count == 0){
				message.put("status", "0");
				message.put("message", "消费失败");
			}else if(count == -1){
				message.put("status", "-1");
				message.put("message", "可用金额不足");
			}else if(count == 1){
				message.put("status", "1");
				message.put("message", "消费成功");
			}
			return message;
		}
		
		/**
		 * 查看我的下线
		 * @return
		 */
		@RequestMapping("/selectMember")
		public @ResponseBody Map<String, Object> selectMember(Integer number) {
			Map<String, Object> message = new HashMap<String, Object>();

			
			TbUser tbUser = null;
			if (isAuthenticated()) {
				Object object = findUserInfo();
				if (object instanceof TbUser) {
					tbUser = (TbUser) object;
				}
			} else {
				message.put("status", "0");
				message.put("message", "您还没有登陆");
				return message;
			}
			
			if(tbUser.getuType().equals("0")){
				message.put("status", "0");
				message.put("message", "您还不是会员");
				return message;
			}
			
			List<TbUser> tbUsers = tbUserService.selectMember(tbUser,0,number);
			message.put("status", "1");
			message.put("message", "查找成功");
			message.put("tbUsers", tbUsers);
			return message;
		}
		
		/**
		 * 查看个人信息
		 */
		@RequestMapping("/selectMe")
		public @ResponseBody Map<String, Object> selectMe() {
			Map<String, Object> message = new HashMap<String, Object>();

			
			TbUser tbUser = null;
			if (isAuthenticated()) {
				Object object = findUserInfo();
				if (object instanceof TbUser) {
					tbUser = (TbUser) object;
				}
			} else {
				message.put("status", "0");
				message.put("message", "您还没有登陆");
				return message;
			}

            tbUser = tbUserService.findById(tbUser.getuId());

            message.put("status", "1");
			message.put("message", "查找成功");
			message.put("tbUser", tbUser);
			return message;
		}
		
		/**
		 * 修改个人信息
		 */
		@RequestMapping("/updateMe")
		public @ResponseBody Map<String, Object> updateMe(TbUser tbUser) {
			Map<String, Object> message = new HashMap<String, Object>();

			
			TbUser tbUserCurrent = null;
			if (isAuthenticated()) {
				Object object = findUserInfo();
				if (object instanceof TbUser) {
					tbUserCurrent = (TbUser) object;
				}
			} else {
				message.put("status", "0");
				message.put("message", "您还没有登陆");
				return message;
			}
			
			tbUser.setuId(tbUserCurrent.getuId());
			tbUser.setuAccount(null);
			tbUser.setuPassword(null);
			tbUser.setuType(null);
			tbUser.setuReisterRecommender(null);
			tbUser.setuReisterRecommenderAccount(null);
			tbUser.setuSumMoney(null);
			tbUser.setuUsableMoney(null);
			tbUser.setuConsumptionNumber(null);
			tbUser.setuAuthentication(null);
			int count = tbUserService.updateByUserId(tbUser);
			if(count == 0){
				message.put("status", "0");
				message.put("message", "修改失败");
			}else{
				message.put("status", "1");
				message.put("message", "修改成功!");
			}
			return message;
		}
		
		/**
		 * 修改密码
		 * @return
		 */
		@RequestMapping("/updatePass")
		public @ResponseBody Map<String, Object> updatePass(String oldPasswd,String passwd, String passwd2) {
			Map<String, Object> message = new HashMap<String, Object>();

			
			TbUser tbUserCurrent = null;
			if (isAuthenticated()) {
				Object object = findUserInfo();
				if (object instanceof TbUser) {
					tbUserCurrent = (TbUser) object;
				}
			} else {
				message.put("status", "0");
				message.put("message", "您还没有登陆");
				return message;
			}
			// shiro
			Md5Hash md5Hash = new Md5Hash(oldPasswd,
					ByteSource.Util.bytes(AccountRealm.SALT),
					AccountRealm.HASH_ITERATIONS);
			String oldPass_md5 = md5Hash.toString();
			if(!oldPass_md5.equals(tbUserCurrent.getuPassword())){
				message.put("status", "0");
				message.put("message", "旧密码错误");
				return message;
			}
			if(passwd== null || passwd2 == null || passwd.equals("") || passwd2.equals("")){
				message.put("status", "0");
				message.put("message", "新密码不能为空");
				return message;
			}
			
			if(!passwd.equals(passwd2)){
				message.put("status", "0");
				message.put("message", "2次新密码不相等");
				return message;
			}
			int count = tbUserService.updatePass(tbUserCurrent.getuId(),passwd);
			
			if(count == 0){
				message.put("status", "0");
				message.put("message", "修改失败,请重试");
			}else{
				message.put("status", "1");
				message.put("message", "修改成功");
			}
			
			return message;
		}

	/**
	 * 充值
	 */
	@RequestMapping("/recharge")
	public @ResponseBody Map<String, Object> recharge(String uAccount,String money) {
		Map<String, Object> message = new HashMap<String, Object>();


		TbUser tbUserCurrent = null;
		if (isAuthenticated()) {
			Object object = findUserInfo();

			if (object instanceof TbUser) {
				tbUserCurrent = (TbUser) object;
			}
		} else {
			message.put("status", "0");
			message.put("message", "您还没有登陆");
			return message;
		}

        if(!tbUserCurrent.getuType().equals("5")){
            message.put("status", "0");
            message.put("message", "您没有权限");
            return message;
        }

		int count = tbUserService.recharge(uAccount,money);
		if(count == 0){
			message.put("status", "0");
			message.put("message", "充值失败");
		}else if(count == -1){
            message.put("status", "-1");
            message.put("message", "用户不存在");
        }else{
			message.put("status", "1");
			message.put("message", "充值成功");
		}
		return message;
	}
		
}
