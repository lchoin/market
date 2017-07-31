package com.jzf.market.common.utils;

import com.aliyun.api.gateway.demo.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Java_feng on 2017/2/15.
 */
public class Express {
    //private static String APPCODE = "";


    /**
     *  查询快递
     * @param tracking_number   快递号
     * @param carrier_code      公司编号
     * @return
     */
    public static String send(String tracking_number,String carrier_code) {
        String host = "http://aliyunapi.trackingmore.com";
        String path = "/v2/trackings/realtime";
        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE f4b80e6d246943f593b91cb084b93397");
        headers.put("Content-Type", "application/json");
        headers.put("Trackingmore-Api-Key", "23635885");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = "{\"tracking_number\": "+tracking_number+",\"carrier_code\":\"" + carrier_code + "\"}";


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //System.out.println("-----------------------" + response.toString());
            //获取response的body
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public enum ExpressCompany {
        CHINA_POST("china-post", "中国邮政"), CHINA_EMS("china-ems", "中国 EMS"),
        SF_EXPRESS("sf-express", " 顺丰速递"), STO("sto", " 申通快递"),
        YTO("yto", " 圆通快递"), ZTO("zto", " 中通快递"),
        YUNDA("yunda", " 韵达快递"), JD("jd", " 京东快递"),
        DEPPON("deppon", " 德邦物流"), QFKD("qfkd", " 全峰快递"),
        TTKD("ttkd", " 天天快递"), A18856("al8856", " 阿里电商物流"),
        BESTEX("bestex", " 百世快递"), FASTGO("fastgo", " 速派快递FastGo");

        private String name;
        private String msg;

        ExpressCompany(String name, String msg) {
            this.name = name;
            this.msg = msg;
        }

        public String getName() {
            return name;
        }

        public String getMsg() {
            return msg;
        }

    }


    //public static void main(String[] args) {
    //    send("3323192049532",ExpressCompany.STO.getName());

        //ExpressCompany[] values = ExpressCompany.values();
        //for (ExpressCompany company:values) {
        //    System.out.println(company.getName() + " ; " + company.getMsg());
        //}

        //System.out.println(ExpressCompany.STO.getName());
    //}


}
