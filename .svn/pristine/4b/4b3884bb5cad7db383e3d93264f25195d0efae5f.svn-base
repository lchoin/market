package com.jzf.market.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 短信工具
 * 
 * @author feng
 *
 *         2016年12月6日 下午6:48:10
 */
public class SmsClient {
	private static final String URL = "http://gw.api.taobao.com/router/rest";
	private static final String APPKEY = "23632926";
	private static final String APP_SECRET = "de00255f9e487a93e81a1b3d36be4d08";

	/**
	 * 发送短信
	 * 
	 * @param phone
	 *            手机号
	 * @param number
	 *            随机数
	 * @return
	 * 
	 * {
		    "error_response": {
		        "code": 15,
		        "msg": "Remote service error",
		        "sub_code": "isv.BUSINESS_LIMIT_CONTROL",
		        "sub_msg": "触发业务流控",
		        "request_id": "iv0whd0pf1di"
		    }
		}
		
		{
		    "alibaba_aliqin_fc_sms_num_send_response": {
		        "result": {
		            "err_code": "0",
		            "model": "105167015692^1107109395308",
		            "success": true
		        },
		        "request_id": "3gtswd7s0xwa"
		    }
		}
	 */
	public static String send(String phone, Integer number) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APP_SECRET);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		// req.setExtend( "" );
		req.setSmsType("normal");
		req.setSmsFreeSignName("长回家酒店");
		req.setSmsParamString("{number:'"+number+"'}");
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_35190114");
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
			
			return rsp.getBody();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static void main(String[] args) throws Exception, IOException {
//		 Integer verificationCode = VerificationCode.generateByPhone();
//		// System.out.println(SmsClient.send("15538910238", verificationCode));
//
//		send("15538910238", verificationCode);
//	}
}
