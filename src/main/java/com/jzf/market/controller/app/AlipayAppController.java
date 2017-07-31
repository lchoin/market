package com.jzf.market.controller.app;

import com.alipay.api.AlipayApiException;
import com.jzf.market.common.utils.AlipayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feng on 2017/1/18 0018.
 */
@Controller
@RequestMapping("/AlipayApp")
public class AlipayAppController {



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
