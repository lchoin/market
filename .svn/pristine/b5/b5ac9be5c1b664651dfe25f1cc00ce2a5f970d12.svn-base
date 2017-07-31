package com.jzf.market.controller.web;

import com.jzf.market.common.utils.Express;
import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.service.TbPersonIndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
@Controller
@RequestMapping("/TbPersonIndent")
public class TbPersonIndentController extends BaseController  {
    @Autowired
    private TbPersonIndentService tbPersonIndentService;

    /**
     * 查看所有订单(管理员)
     *
     * @return
     */
    @RequestMapping("/selectAll")
    public
    @ResponseBody
    Map<String, Object> selectAll() {
        Map<String, Object> message = new HashMap<String, Object>();
        TbUser tbUser = null;
        if (isAuthenticated()) {
            Object object = findUserInfo();
            if (object instanceof TbUser) {
                tbUser = (TbUser) object;
            }
        } else {
            message.put("status", "0");
            message.put("message", "您还没有登陆");
            return message;
        }
        if(!tbUser.getuType().equals("5")){
            message.put("status", "0");
            message.put("message", "您没有权限");
            return message;
        }

        List<Map<String,Object>> tbPersonIndents = tbPersonIndentService.selectAll();
        message.put("status", "1");
        message.put("message", "查找成功");
        message.put("tbPersonIndents", tbPersonIndents);
        return message;
    }

    /**
     * 修改订单状态
     *
     * @return
     */
    @RequestMapping("/updateStatusById")
    public
    @ResponseBody
    Map<String, Object> updateStatusById(String piId,String piStatus) {
        Map<String, Object> message = new HashMap<String, Object>();
        TbUser tbUser = null;
        if (isAuthenticated()) {
            Object object = findUserInfo();
            if (object instanceof TbUser) {
                tbUser = (TbUser) object;
            }
        } else {
            message.put("status", "0");
            message.put("message", "您还没有登陆");
            return message;
        }

        if(piId == null || piId.equals("")){
            message.put("status", "0");
            message.put("message", "请输入订单ID");
            return message;
        }
        if(piStatus == null || piStatus.equals("")){
            message.put("status", "0");
            message.put("message", "请输入订单状态");
            return message;
        }else if(piStatus.equals("2")){
            if(!tbUser.getuType().equals("5")){
                message.put("status", "0");
                message.put("message", "您没有权限");
                return message;
            }
        }

        int count = tbPersonIndentService.updateStatusById(piId,piStatus);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "提交失败");
        }else{
            message.put("status", "1");
            message.put("message", "提交成功");
        }
        return message;
    }

    /**
     * 查看所有物流公司
     *
     * @return
     */
    @RequestMapping("/selectAllExpressCompany")
    public
    @ResponseBody
    Map<String, Object> selectAllExpressCompany() {
        Map<String, Object> message = new HashMap<String, Object>();
        TbUser tbUser = null;
        if (isAuthenticated()) {
            Object object = findUserInfo();
            if (object instanceof TbUser) {
                tbUser = (TbUser) object;
            }
        } else {
            message.put("status", "0");
            message.put("message", "您还没有登陆");
            return message;
        }
        if(!tbUser.getuType().equals("5")){
            message.put("status", "0");
            message.put("message", "您没有权限");
            return message;
        }

        Express.ExpressCompany[] values = Express.ExpressCompany.values();
        List<Map<String,String>> list = new ArrayList();
        Map<String,String> map = null;
        for (Express.ExpressCompany company : values) {
            map = new HashMap();
            map.put(company.getName(),company.getMsg());
            list.add(map);
        }

        message.put("status", "1");
        message.put("message", "查找成功");
        message.put("expressCompany", list);
        return message;
    }

    /**
     * 查看订单物流详情
     *
     * @return
     */
    @RequestMapping("/selectExpress")
    public
    @ResponseBody
    Map<String, Object> selectExpress(String tracking_number,String carrier_code) {
        Map<String, Object> message = new HashMap<String, Object>();
        TbUser tbUser = null;
        if (isAuthenticated()) {
            Object object = findUserInfo();
            if (object instanceof TbUser) {
                tbUser = (TbUser) object;
            }
        } else {
            message.put("status", "0");
            message.put("message", "您还没有登陆");
            return message;
        }

        message.put("status", "1");
        message.put("message", "调用成功");
        message.put("expressCompany",  Express.send(tracking_number,carrier_code));
        return message;
    }

    /**
     * 给商品添加快递单号和物流公司编号
     *
     * @return
     */
    @RequestMapping("/insertExpressCompany")
    public
    @ResponseBody
    Map<String, Object> insertExpressCompany(String piId,String tracking_number,String carrier_code) {
        Map<String, Object> message = new HashMap<String, Object>();
        TbUser tbUser = null;
        if (isAuthenticated()) {
            Object object = findUserInfo();
            if (object instanceof TbUser) {
                tbUser = (TbUser) object;
            }
        } else {
            message.put("status", "0");
            message.put("message", "您还没有登陆");
            return message;
        }
        if(!tbUser.getuType().equals("5")){
            message.put("status", "0");
            message.put("message", "您没有权限");
            return message;
        }

        if(piId == null || piId.equals("")){
            message.put("status", "0");
            message.put("message", "请输入订单ID");
            return message;
        }
        if(tracking_number == null || tracking_number.equals("")){
            message.put("status", "0");
            message.put("message", "请输入物流单号");
            return message;
        }
        if(carrier_code == null || carrier_code.equals("")){
            message.put("status", "0");
            message.put("message", "请输入物流公司编号");
            return message;
        }


        int count = tbPersonIndentService.insertExpressCompany(piId,tracking_number,carrier_code);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "提交失败");
        }else{
            message.put("status", "1");
            message.put("message", "提交成功");
        }
        return message;
    }

}
