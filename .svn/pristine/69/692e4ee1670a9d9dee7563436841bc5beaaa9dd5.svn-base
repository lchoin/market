package com.jzf.market.controller.app;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;


public class BaseAPPController {
	/**
	 * 验证是否登陆
	 * 
	 * org.apache.shiro.subject.support.
	 * DefaultSubjectContext_AUTHENTICATED_SESSION_KEY ; true
	 * org.apache.shiro.subject
	 * .support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY ;
	 * com.hncxhd.bywl.entity.manual.UserInfo@533752b2
	 */
	protected boolean isAuthenticated(String sessionID) {
		boolean status = false;
		try {
			Session se = getSubject(sessionID).getSession();
			Object obj = se.getAttribute(DefaultSubjectContext.AUTHENTICATED_SESSION_KEY);
			if (obj != null) {
				status = (Boolean) obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Session se = null;
			Object obj = null;
		}
		return status;
	}
	/**
	 * 获取用户信息
	 * 
	 */
	protected Object findUserInfo(String sessionID) {
		Subject subject = getSubject(sessionID);
		// 取身份信息
		return subject.getPrincipal();
	}

	/**
	 * 获取主体
	 * 
	 */
	protected Subject getSubject(String sessionID) {
//		PrincipalCollection principals = new SimplePrincipalCollection(  
//                "", "MobileRealm");  
		
		return new Subject.Builder().sessionId(sessionID).buildSubject();
	}

	/**
	 * 退出登陆
	 */
	protected void logout(String sessionID) throws Exception {
		Subject subject = getSubject(sessionID);
		subject.logout();
	}
	
	/**
	 * 检测权限
	 * 
	 * @param permission
	 * @return
	 */
	protected boolean checkPermission(String permission,String sessionID) {
		Subject subject = getSubject(sessionID);
		try {
			subject.checkPermission(permission);
		} catch (UnauthorizedException e) {
			return false;
		}
		return true;
	}
}
