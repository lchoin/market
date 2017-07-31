package com.jzf.market.common.config.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.service.TbUserService;



public class AccountRealm extends AuthorizingRealm {
	// 盐  
	public static final String SALT = "nmg";
	public static final String ALGORITHM = "md5";
	public static final int HASH_ITERATIONS = 1;
	
	@Autowired
	private TbUserService tbUserService;
	
	
	public AccountRealm() {}

	public String getName() {
        return "accountRealm";
    }
    
 // realm的认证方法，从数据库查询用户信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
		String account = null;
		// token是用户输入的账号密码
		if (token instanceof UsernamePasswordToken) {
			UsernamePasswordToken customToken = (UsernamePasswordToken) token;
			// 第一步从token中取出手机号
			account = (String) customToken.getPrincipal();
		}
		if (account == null || account.equals("")) {
			return null;
		}
		
		//根据手机号查找用户表
		TbUser tbUser = tbUserService.findTbUserByPhone(account);
		if(tbUser == null){
			tbUser = tbUserService.findTbUserByAccount(account);
		}
		if(tbUser == null){
			return null;
		}
//    	if(Boolean.TRUE.equals(tbUser.getLocked())) {  
//            throw new LockedAccountException(); //帐号锁定  
//        } 
		
		String passMd5 = tbUser.getuPassword();
		
    	// 将userInfo设置simpleAuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				tbUser,passMd5 ,ByteSource.Util.bytes(SALT),this.getName());
//		
		return simpleAuthenticationInfo;
		
//		return null;
		
    }

 // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

    	// 从 principals获取主身份信息
//    	TbUser tbUser = (TbUser) principals.getPrimaryPrincipal();
//    	List<TbPermission> tbPermissions = tbPermissionService.selectByPhone(tbUser.getuPhone());
//    	
//    	List<String> permissions = new ArrayList<String>();
//    	for(TbPermission tbPermission : tbPermissions){
//    		permissions.add(tbPermission.getpCodeString());
//    	}
    	
    	SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//        info.addRole("");
//        info.addStringPermission("GroupController:selectById:more");
//        info.addStringPermissions(permissions);

        return info;
    }

}