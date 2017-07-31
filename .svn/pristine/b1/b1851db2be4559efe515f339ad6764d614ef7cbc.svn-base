package com.jzf.market.common.config.shiro;

import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authz.SslFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.google.common.collect.Maps;
import com.jzf.market.common.config.shiro.realm.AccountRealm;

@Configuration
public class ShiroConfig {
	
	/**
	 * FilterRegistrationBean
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter")); 
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*"); 
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
	}
	
	/**
	 * @see org.apache.shiro.spring.web.ShiroFilterFactoryBean
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(){
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager());
		bean.setLoginUrl("/TbUser/login");
		bean.setUnauthorizedUrl("/TbUser/unauthor");
		
		Map<String, Filter>filters = Maps.newHashMap();
//		filters.put("perms", urlPermissionsFilter());
//		filters.put("anon", new AnonymousFilter());
		//filters.put("logout", new LogoutFilter());
//		filters.put("ssl", sslFilter());
		bean.setFilters(filters);
		
		Map<String, String> chains = Maps.newLinkedHashMap();
		chains.put("/logout", "logout");
		chains.put("/css/**", "anon");
		chains.put("/images/**", "anon");
		chains.put("/js/**", "anon");

		//app接口
        chains.put("/AlipayApp/**", "anon");
        chains.put("/TbAuthenticationApp/**", "anon");
        chains.put("/TbConsumptionApp/**", "anon");
        chains.put("/TbDeliveryAddressApp/**", "anon");
        chains.put("/TbEarningsApp/**", "anon");
        chains.put("/TbGoodsApp/**", "anon");
        chains.put("/TbPersonIndentApp/**", "anon");
        chains.put("/TbUserApp/**", "anon");
		chains.put("/image/**", "anon");

		//web接口
		chains.put("/TbUser/ajaxLogin", "anon");
		chains.put("/TbUser/registerByPhone", "anon");
		chains.put("/TbUser/isRegister", "anon");
		chains.put("/TbUser/obtainVerificationCode", "anon");
		chains.put("/TbUser/forgetPassByAccount", "anon");

		chains.put("/Alipay/applicationGateway", "anon");
        chains.put("/Alipay/AuthorizeCallback", "anon");

        //页面
        chains.put("/phone/**", "anon");

//		chains.put("/**", "authc,perms");
//		chains.put("/**", "authc,ssl");
		chains.put("/**", "authc");
		bean.setFilterChainDefinitionMap(chains);
		return bean;
	}
	
	@Bean
	public SslFilter sslFilter() {
		SslFilter ssl = new SslFilter();
		ssl.setPort(443);
		return ssl;
	}
	
	/**
	 * @see org.apache.shiro.mgt.SecurityManager
	 * @return
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager securityManager() {
//		Collection<Realm> realms = new ArrayList<Realm>();
//		realms.add(dbRealm());
		
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		
		manager.setRealm(accountRealm());
//		manager.setRealms(realms);
//		//设置多个realm认证策略
//		manager.setAuthenticator(authenticator());
		manager.setCacheManager(cacheManager());
		manager.setSessionManager(defaultWebSessionManager());
		return manager;
	}
	
	//定义多个realm认证策略
	@Bean
	public ModularRealmAuthenticator authenticator() {
		ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
		modularRealmAuthenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
		return modularRealmAuthenticator;
	}
	
	/**
	 * @see DefaultWebSessionManager
	 * @return
	 */
	@Bean(name="sessionManager")
	public DefaultWebSessionManager defaultWebSessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setCacheManager(cacheManager());
		sessionManager.setGlobalSessionTimeout(604800000);
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setDeleteInvalidSessions(true);
		
		EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
		sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
		sessionManager.setSessionDAO(sessionDAO);
		return sessionManager;
	}
	
	/**
	 *	密码加密
	 */
	@Bean
	@DependsOn(value="lifecycleBeanPostProcessor")
	public AccountRealm accountRealm() {
		AccountRealm userRealm = new AccountRealm();
		userRealm.setCacheManager(cacheManager());
		
		//定义凭证匹配器
		HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
		//指定散列算法
		credentialsMatcher.setHashAlgorithmName(AccountRealm.ALGORITHM);
		//指定散列次数
		credentialsMatcher.setHashIterations(AccountRealm.HASH_ITERATIONS);
		//将凭证匹配器设置到realm
		userRealm.setCredentialsMatcher(credentialsMatcher);
		return userRealm;
	}
	
	@Bean
	public URLPermissionsFilter urlPermissionsFilter() {
		return new URLPermissionsFilter();
	}
	
	@Bean
	public EhCacheManager cacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return cacheManager;
	}
	
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}