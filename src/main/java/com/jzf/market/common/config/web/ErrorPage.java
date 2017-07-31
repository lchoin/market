package com.jzf.market.common.config.web;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by feng on 2017/1/17 0017.
 */
@Configuration
public class ErrorPage {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return ((ConfigurableEmbeddedServletContainer container) -> {

            org.springframework.boot.web.servlet.ErrorPage error401Page = new org.springframework.boot.web.servlet.ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.html");
            org.springframework.boot.web.servlet.ErrorPage error404Page = new org.springframework.boot.web.servlet.ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
            org.springframework.boot.web.servlet.ErrorPage error500Page = new org.springframework.boot.web.servlet.ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });

//    	return new EmbeddedServletContainerCustomizer() {
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.html");
//	            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
//	            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
//
//	            container.addErrorPages(error401Page, error404Page, error500Page);
//			}
//		};
    }

}
