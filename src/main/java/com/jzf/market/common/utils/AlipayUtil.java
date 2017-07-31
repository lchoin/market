package com.jzf.market.common.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayOpenPublicTemplateMessageIndustryModifyRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayOpenPublicTemplateMessageIndustryModifyResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by feng on 2017/1/18 0018.
 */
public class AlipayUtil {
    private static final String APP_ID = "2016080100137779";
    private static final String UID = "2088102169385450";
    private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvdoJfaeBw2QdZKNMIUjGhnGG5XHiqhXPy9Wwn7u1kc7gEaUpUzczkFfYB+fmXsw6XWXoWdK/lKMfBeL22mIonrJYOktxcNqe7HxA+YYEa2Tb+QKv/L30J25VrXKi9iy7H5DvoXHJ6K44Zqrcf7LcNwEiCEQB/2j1aX3swlOuhcppE0Y3Jm9Xrad6qG/0MkwDHLaajeQT3oHIpFwfSzFGMLNZE+WpWW/KeigNXVQhbNIlZA9xnOlRnGP01QPCZ5UuM6G3TJmr6IURn9mXcNcFGT0feNm+agJ0YKywK+dTf+STtSOPgosREkpGDuUDZDijpGvBYTHBJqQbWVLEHMU2UQIDAQAB";
    private static final String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC+GPAxSi6qFjeom5GT/zM7m7lSovIrvO/NXTy70DjSTHPlhyWw0xArfCTdk1U23jVdGqNi5OraSKpQ9OG6RLNEbE3HEQTlsHDIWVY4N6jBWxwDvP3mB9q/k5F/UjI9ub2t/WDnY3uiPWTMW4K5SZqyZRGqXhlHCApoWuQyHs9a4d2ekT2u3i3gzRJoy0k7CRaup/BM8bQ76j8KXCBwum81wnVWbWbsec6yIl0PweSAcd0fjSrtskjxm6/Lv8w6PylgfgGiOxz6OJ8qYEte9+QciHXYt5IlJWMCyIAlvrZKxiFINsdKyRP+bneITT8SlPozcFoWLfhcheaI03pVjZoZAgMBAAECggEBAJIq6sV7nNX7r2Bd/lol6Gb1HlKEKGGpLVpjTse7G3XYg2UBveFw6QYGtvIIz4UY5z9ntCneixa8uPj20no/SPhbrpJaa8GRIadryfgAFCpYu/nD4BZ4A6M6/K1Bro/3ufmG0nQY8n+VZWQdGS8PgXuaazLsl9MeQ6JqAPzo49ekbcFs3xcgyiwmmTUKPtBQdqk5sJtP+p+5LIDCLxt7ViHjpnsvFo1SxNEcig58M462cwCqTgIC8lCwXbju2lUhd6EXQhlePbrtsl2bj/GOjAv6gExmMaUnAuAvc11FkA/7GF6AOmJykRShdkKsWrcWCiMLS3CwrHGALxahPKGXL4ECgYEA/y82MIeQeJMbJVx9uuGhF3HjLc2PV9TXKbFRPCrKlsZA5dcOHrgcmxkEPG3loQTLMETy4QwdEbi+1Aa8AQH7R/u6lt1avETuiQZBLsa4VUlVsTpEv7lXted2UyqdutsS6QQGPe7wjzO5ZD7y9CdQG3oNzBd5r2ymzI+ASZ4mI50CgYEAvrR5Kf0T6NowNk5T4GQjpLhwQc01oBJwnkynUi3nyk50onulQfbJIlixuIjLJKl7/jjx6wr92GMoImXPOlqME3NmX21K50QLjZwlYgZaeYQeGbpBP9nwLjp7KjGAlY+WZz1b2xMxyjYcC78zC93k6NaegiXm+rD5zMLnji1d3a0CgYAZZR9lcPhFp44aB7xTbsTTSngrRLuxJ/NJqOXGsRN8MbqfpOk40WW3YaP0R5OElK+L3DC3iLcT3mjPPORUzVeucDS/csPm3I1IgaDXANuzURsACiZxVgaOibxSxnjv8YFOQyJD45V5CtK2UTVoaskkEt9woh1wAcYPsXA44040WQKBgQCrRFdgfzmnMHSGAPhRGH3uS/n9Dnevh3/+mqbWJgX56VXUKqkywZjHMNKDAM834MJLgQa6aQeqkvqTUc23AWS1fzkcUIIpijG5/taP31bXtPB3eI9q8aZDTiAYt5ZcOzT/CNr6t5VKnie34QHOEXyoIz79cV6sG85rt0rPpCydjQKBgQCOyxezvG2JHZMSa5JLG04f6ORG4lM1KyF7Pd7e/ZHBNwmuLQTt8RJQZ/bLz6s8QG7cIAuX5YLmQUkn7sSzN3RIV1JliHkSo2N3JWTmsnm3E5/Xfxs2M9irRjYRUll/VFTkFoMXyTNEIJLDDX5KELvV9TXR2s/xLNaMNC0JhOMT3w==";
    private static final String AES = "A33HqRD2+pgtweXepF0Y0A==";

    //实例化客户端
    private static final AlipayClient client = new DefaultAlipayClient("http://openapi.alipaydev.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY,"RSA2");


    public static void test() throws AlipayApiException {

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.open.public.template.message.industry.modify
        AlipayOpenPublicTemplateMessageIndustryModifyRequest request = new AlipayOpenPublicTemplateMessageIndustryModifyRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数
        //此次只是参数展示，未进行字符串转义，实际情况下请转义
        request.setBizContent("{'primary_industry_name':'IT科技/IT软件与服务','primary_industry_code':'10001/20102', 'secondary_industry_code':'10001/20102', 'secondary_industry_name':'IT科技/IT软件与服务'}");
        AlipayOpenPublicTemplateMessageIndustryModifyResponse response = client.execute(request);
        //调用成功，则处理业务逻辑
        if(response.isSuccess()){
            //.....
            System.out.println(response);
        }
    }

    public static void pay(String money,HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws AlipayApiException, IOException {
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://127.0.0.1");
        alipayRequest.setNotifyUrl("http://jzdxjzf.nat123.net/Alipay/AuthorizeCallback");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":"+VerificationCode.generateByDate()+"," +     //商户订单号，需要保证不重复
                "    \"total_amount\":"+money+"," +                 //订单金额
                "    \"subject\":\"充值\"," +                         //订单标题
                "    \"seller_id\":"+UID+"," +         //实际收款账号，一般填写商户PID即可
                "    \"product_code\":\"QUICK_WAP_PAY\"" +
                "  }");//填充业务参数
        String form = client.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        httpResponse.setContentType("text/html;charset=" + "UTF-8");
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
    }

    public static void applicationGateway(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws AlipayApiException, IOException {
        Map<String, String> paramsMap = getParamMapNotNull(httpRequest);

        System.out.println("-----------------------------------"+paramsMap);

        boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, ALIPAY_PUBLIC_KEY, "UTF-8", "RSA2");//调用SDK验证签名
//        boolean signVerified = false;

        if(signVerified){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
            System.out.println("验签成功");
            httpResponse.getWriter().write("success");
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
            System.out.println("验签失败");
            httpResponse.getWriter().write("failure");
        }
    }

    private static Map<String, String> getParamMapNotNull(HttpServletRequest httpRequest) throws IOException {
        Map<String, String> paramsMap = new HashMap<String, String>();//将异步通知中收到的所有参数都存放到map中
        String notify_time = httpRequest.getParameter("notify_time");
        if(notify_time != null){
            paramsMap.put("notify_time",notify_time);
        }
        String notify_type = httpRequest.getParameter("notify_type");
        if(notify_type != null){
            paramsMap.put("notify_type",notify_type);
        }
        String notify_id = httpRequest.getParameter("notify_id");
        if(notify_id != null){
            paramsMap.put("notify_id",notify_id);
        }
        String app_id = httpRequest.getParameter("app_id");
        if(app_id != null){
            paramsMap.put("app_id",app_id);
        }
        String charset = httpRequest.getParameter("charset");
        if(charset != null){
            paramsMap.put("charset",charset);
        }
        String version = httpRequest.getParameter("version");
        if(version != null){
            paramsMap.put("version",version);
        }
        String sign_type = httpRequest.getParameter("sign_type");
        if(sign_type != null){
            paramsMap.put("sign_type",sign_type);
        }
        String sign = httpRequest.getParameter("sign");
        if(sign != null){
            paramsMap.put("sign",sign);
        }
        String trade_no = httpRequest.getParameter("trade_no");
        if(trade_no != null){
            paramsMap.put("trade_no",trade_no);
        }
        String out_trade_no = httpRequest.getParameter("out_trade_no");
        if(out_trade_no != null){
            paramsMap.put("out_trade_no",out_trade_no);
        }
        String out_biz_no = httpRequest.getParameter("out_biz_no");
        if(out_biz_no != null){
            paramsMap.put("out_biz_no",out_biz_no);
        }
        String buyer_id = httpRequest.getParameter("buyer_id");
        if(buyer_id != null){
            paramsMap.put("buyer_id",buyer_id);
        }
        String buyer_logon_id = httpRequest.getParameter("buyer_logon_id");
        if(buyer_logon_id != null){
            paramsMap.put("buyer_logon_id",buyer_logon_id);
        }
        String seller_id = httpRequest.getParameter("seller_id");
        if(seller_id != null){
            paramsMap.put("seller_id",seller_id);
        }
        String seller_email = httpRequest.getParameter("seller_email");
        if(seller_email != null){
            paramsMap.put("seller_email",seller_email);
        }
        String trade_status = httpRequest.getParameter("trade_status");
        if(trade_status != null){
            paramsMap.put("trade_status",trade_status);
        }
        String total_amount = httpRequest.getParameter("total_amount");
        if(total_amount != null){
            paramsMap.put("total_amount",total_amount);
        }
        String receipt_amount = httpRequest.getParameter("receipt_amount");
        if(receipt_amount != null){
            paramsMap.put("receipt_amount",receipt_amount);
        }
        String invoice_amount = httpRequest.getParameter("invoice_amount");
        if(invoice_amount != null){
            paramsMap.put("invoice_amount",invoice_amount);
        }
        String buyer_pay_amount = httpRequest.getParameter("buyer_pay_amount");
        if(buyer_pay_amount != null){
            paramsMap.put("buyer_pay_amount",buyer_pay_amount);
        }
        String point_amount = httpRequest.getParameter("point_amount");
        if(point_amount != null){
            paramsMap.put("point_amount",point_amount);
        }
        String refund_fee = httpRequest.getParameter("refund_fee");
        if(refund_fee != null){
            paramsMap.put("refund_fee",refund_fee);
        }
        String subject = httpRequest.getParameter("subject");
        if(subject != null){
            paramsMap.put("subject",subject);
        }
        String body = httpRequest.getParameter("body");
        if(body != null){
            paramsMap.put("body",body);
        }
        String gmt_create = httpRequest.getParameter("gmt_create");
        if(gmt_create != null){
            paramsMap.put("gmt_create",gmt_create);
        }
        String gmt_payment = httpRequest.getParameter("gmt_payment");
        if(gmt_payment != null){
            paramsMap.put("gmt_payment",gmt_payment);
        }
        String gmt_refund = httpRequest.getParameter("gmt_refund");
        if(gmt_refund != null){
            paramsMap.put("gmt_refund",gmt_refund);
        }
        String gmt_close = httpRequest.getParameter("gmt_close");
        if(gmt_close != null){
            paramsMap.put("gmt_close",gmt_close);
        }
        String fund_bill_list = httpRequest.getParameter("fund_bill_list");
        if(fund_bill_list != null){
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode rootNode = mapper.readTree(fund_bill_list);
//            String amount = rootNode.findValue("amount").textValue();
//            if(amount != null){
//                paramsMap.put("amount",amount);
//            }
//            String fundChannel = rootNode.findValue("fundChannel").textValue();
//            if(fundChannel != null){
//                paramsMap.put("fundChannel",fundChannel);
//            }

            paramsMap.put("fund_bill_list",fund_bill_list);
        }
        String passback_params = httpRequest.getParameter("passback_params");
        if(passback_params != null){
            paramsMap.put("passback_params",passback_params);
        }
        String voucher_detail_list = httpRequest.getParameter("voucher_detail_list");
        if(voucher_detail_list != null){
            paramsMap.put("voucher_detail_list",voucher_detail_list);
        }
        return paramsMap;
    }

    private static Map<String, String> getParamMap(HttpServletRequest httpRequest) throws IOException {
        Map<String, String> paramsMap = new HashMap<String, String>();//将异步通知中收到的所有参数都存放到map中
        String notify_time = httpRequest.getParameter("notify_time");
            paramsMap.put("notify_time",notify_time);
        String notify_type = httpRequest.getParameter("notify_type");
            paramsMap.put("notify_type",notify_type);
        String notify_id = httpRequest.getParameter("notify_id");
            paramsMap.put("notify_id",notify_id);
        String app_id = httpRequest.getParameter("app_id");
            paramsMap.put("app_id",app_id);
        String charset = httpRequest.getParameter("charset");
            paramsMap.put("charset",charset);
        String version = httpRequest.getParameter("version");
            paramsMap.put("version",version);
        String sign_type = httpRequest.getParameter("sign_type");
            paramsMap.put("sign_type",sign_type);
        String sign = httpRequest.getParameter("sign");
            paramsMap.put("sign",sign);
        String trade_no = httpRequest.getParameter("trade_no");
            paramsMap.put("trade_no",trade_no);
        String out_trade_no = httpRequest.getParameter("out_trade_no");
            paramsMap.put("out_trade_no",out_trade_no);
        String out_biz_no = httpRequest.getParameter("out_biz_no");
            paramsMap.put("out_biz_no",out_biz_no);
        String buyer_id = httpRequest.getParameter("buyer_id");
            paramsMap.put("buyer_id",buyer_id);
        String buyer_logon_id = httpRequest.getParameter("buyer_logon_id");
            paramsMap.put("buyer_logon_id",buyer_logon_id);
        String seller_id = httpRequest.getParameter("seller_id");
            paramsMap.put("seller_id",seller_id);
        String seller_email = httpRequest.getParameter("seller_email");
            paramsMap.put("seller_email",seller_email);
        String trade_status = httpRequest.getParameter("trade_status");
            paramsMap.put("trade_status",trade_status);
        String total_amount = httpRequest.getParameter("total_amount");
            paramsMap.put("total_amount",total_amount);
        String receipt_amount = httpRequest.getParameter("receipt_amount");
            paramsMap.put("receipt_amount",receipt_amount);
        String invoice_amount = httpRequest.getParameter("invoice_amount");
            paramsMap.put("invoice_amount",invoice_amount);
        String buyer_pay_amount = httpRequest.getParameter("buyer_pay_amount");
            paramsMap.put("buyer_pay_amount",buyer_pay_amount);
        String point_amount = httpRequest.getParameter("point_amount");
            paramsMap.put("point_amount",point_amount);
        String refund_fee = httpRequest.getParameter("refund_fee");
            paramsMap.put("refund_fee",refund_fee);
        String subject = httpRequest.getParameter("subject");
            paramsMap.put("subject",subject);
        String body = httpRequest.getParameter("body");
            paramsMap.put("body",body);
        String gmt_create = httpRequest.getParameter("gmt_create");
            paramsMap.put("gmt_create",gmt_create);
        String gmt_payment = httpRequest.getParameter("gmt_payment");
            paramsMap.put("gmt_payment",gmt_payment);
        String gmt_refund = httpRequest.getParameter("gmt_refund");
            paramsMap.put("gmt_refund",gmt_refund);
        String gmt_close = httpRequest.getParameter("gmt_close");
            paramsMap.put("gmt_close",gmt_close);
        String fund_bill_list = httpRequest.getParameter("fund_bill_list");
//        if(fund_bill_list != null){
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode rootNode = mapper.readTree(fund_bill_list);
//            JsonNode amount = rootNode.findValue("amount");
//            if(amount != null){
//                paramsMap.put("amount",amount.textValue());
//            }
//            JsonNode fundChannel = rootNode.findValue("fundChannel");
//            if(fundChannel != null){
//                paramsMap.put("fundChannel",fundChannel.textValue());
//            }

            paramsMap.put("fund_bill_list",fund_bill_list);
//        }
        String passback_params = httpRequest.getParameter("passback_params");
            paramsMap.put("passback_params",passback_params);
        String voucher_detail_list = httpRequest.getParameter("voucher_detail_list");
//        if(voucher_detail_list != null){
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode rootNode = mapper.readTree(voucher_detail_list);
//            JsonNode name = rootNode.findValue("name");
//            if(name != null){
//                paramsMap.put("name",name.textValue());
//            }
//            JsonNode type = rootNode.findValue("type");
//            if(type != null){
//                paramsMap.put("type",type.textValue());
//            }
//            JsonNode amount = rootNode.findValue("amount");
//            if(amount != null){
//                paramsMap.put("amount",amount.textValue());
//            }
//            JsonNode merchant_contribute = rootNode.findValue("merchant_contribute");
//            if(merchant_contribute != null){
//                paramsMap.put("merchant_contribute",merchant_contribute.textValue());
//            }
//            JsonNode other_contribute = rootNode.findValue("other_contribute");
//            if(other_contribute != null){
//                paramsMap.put("other_contribute",other_contribute.textValue());
//            }
//            JsonNode memo = rootNode.findValue("memo");
//            if(memo != null){
//                paramsMap.put("memo",memo.textValue());
//            }

            paramsMap.put("voucher_detail_list",voucher_detail_list);
//        }
        return paramsMap;
    }

//    public static void main(String[] args) throws AlipayApiException {
//        pay();
//    }

}
