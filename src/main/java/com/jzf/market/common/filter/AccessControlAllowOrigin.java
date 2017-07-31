package com.jzf.market.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AccessControlAllowOrigin
 */
@WebFilter(filterName="accessControlAllowOrigin",urlPatterns="/*")
public class AccessControlAllowOrigin implements Filter {
	private String url;
	
    public AccessControlAllowOrigin() {}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// place your code here	-----access-control-allow-origin
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
//		System.out.println(request.getHeader(""));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
//		response.setHeader("Expires", "-1");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setHeader("Pragma", "no-cache");
		response.setHeader("access-control-allow-origin", url);
		response.setHeader("access-control-allow-methods", url);
//		response.setHeader("access-control-allow-headers", "Content-Type");
		response.setHeader("access-control-allow-headers", url);
		response.setHeader("Access-Control-Allow-Credentials", "true");  
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
//		url = fConfig.getInitParameter("URL");
		url = "*";
		System.out.println(">>>>>>>>跨域过滤器初始化<<<<<<<<");
	}

}
