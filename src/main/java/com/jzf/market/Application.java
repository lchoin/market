package com.jzf.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("com.jzf.market.dao")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

//        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.

    }

    @RequestMapping("/")
    public String index() {

        return "userManagement.html";
    }

} 