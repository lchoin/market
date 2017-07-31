package com.jzf.market.controller.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.jzf.market.common.utils.AlipayUtil;
import com.jzf.market.pojo.auto.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by feng on 2017/1/18 0018.
 */
@Controller
@RequestMapping("/Alipay")
public class AlipayController {

    /**
     * 应用网关
     */
    @RequestMapping("/applicationGateway")
    public void applicationGateway() {
        System.out.println("--------------------------支付宝调用应用网关了");




    }

    /**
     * 授权回调地址
     */
    @RequestMapping("/AuthorizeCallback")
    public void AuthorizeCallback(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        System.out.println("--------------------------支付宝调用授权回调地址了");
        try {
            AlipayUtil.applicationGateway(httpRequest,httpResponse);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试
     */
    @RequestMapping("/test")
    public void test(String money,HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        try {
            AlipayUtil.pay(money,httpRequest,httpResponse);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
