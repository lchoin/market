package com.jzf.market.controller.web;

import com.github.pagehelper.PageInfo;
import com.jzf.market.pojo.auto.TbDeliveryAddress;
import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.service.TbDeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/1/17 0017.
 */
@Controller
@RequestMapping("/TbDeliveryAddress")
public class TbDeliveryAddressController extends BaseController  {
    @Autowired
    private TbDeliveryAddressService tbDeliveryAddressService;

    /**
     * 添加收货地址
     * @return
     */
    @RequestMapping("/insert")
    public @ResponseBody
    Map<String, Object> insert(TbDeliveryAddress tbDeliveryAddress) {
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

        if(tbDeliveryAddress.getDaName() == null || tbDeliveryAddress.getDaName().equals("")){
            message.put("status", "0");
            message.put("message", "请输入收货人");
            return message;
        }

        if(tbDeliveryAddress.getDaPhone() == null || tbDeliveryAddress.getDaPhone().equals("")){
            message.put("status", "0");
            message.put("message", "请输入手机号");
            return message;
        }

        if(tbDeliveryAddress.getDaDetailAddress() == null || tbDeliveryAddress.getDaDetailAddress().equals("")){
            message.put("status", "0");
            message.put("message", "请输入手机号");
            return message;
        }
        if(tbDeliveryAddress.getDaIsDefault() == null || tbDeliveryAddress.getDaIsDefault().equals("")){
            message.put("status", "0");
            message.put("message", "请选择是否默认");
            return message;
        }

        tbDeliveryAddress.setDaUId(tbUser.getuId());
        int count = tbDeliveryAddressService.insert(tbDeliveryAddress);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "添加失败");
        }else{
            message.put("status", "1");
            message.put("message", "添加成功");
        }
        return message;
    }

    /**
     * 修改收货地址
     * @return
     */
    @RequestMapping("/updateById")
    public @ResponseBody
    Map<String, Object> updateById(TbDeliveryAddress tbDeliveryAddress) {
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

        if(tbDeliveryAddress.getDaId() == null || tbDeliveryAddress.getDaId().equals("")){
            message.put("status", "0");
            message.put("message", "请输入收货地址ID");
            return message;
        }

        if(tbDeliveryAddress.getDaName() == null || tbDeliveryAddress.getDaName().equals("")){
            message.put("status", "0");
            message.put("message", "请输入收货人");
            return message;
        }

        if(tbDeliveryAddress.getDaPhone() == null || tbDeliveryAddress.getDaPhone().equals("")){
            message.put("status", "0");
            message.put("message", "请输入手机号");
            return message;
        }

        if(tbDeliveryAddress.getDaDetailAddress() == null || tbDeliveryAddress.getDaDetailAddress().equals("")){
            message.put("status", "0");
            message.put("message", "请输入手机号");
            return message;
        }
        if(tbDeliveryAddress.getDaIsDefault() == null || tbDeliveryAddress.getDaIsDefault().equals("")){
            message.put("status", "0");
            message.put("message", "请选择是否默认");
            return message;
        }

        int count = tbDeliveryAddressService.updateById(tbDeliveryAddress,tbUser);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "修改失败");
        }else if(count == -1){
            message.put("status", "-1");
            message.put("message", "收货地址不属于你的");
        }else{
            message.put("status", "1");
            message.put("message", "修改成功");
        }
        return message;
    }

    /**
     * 删除收货地址
     * @return
     */
    @RequestMapping("/deleteById")
    public @ResponseBody
    Map<String, Object> updateById(Long daId) {
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

        if(daId == null || daId == 0L){
            message.put("status", "0");
            message.put("message", "请输入收货地址ID");
            return message;
        }

        int count = tbDeliveryAddressService.deleteById(daId,tbUser);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "删除失败");
        }else if(count == -1){
            message.put("status", "-1");
            message.put("message", "收货地址不属于你的");
        }else if(count == -2){
            message.put("status", "-2");
            message.put("message", "收货地址不存在");
        }else{
            message.put("status", "1");
            message.put("message", "删除成功");
        }
        return message;
    }

    /**
     * 查看收货地址
     * @return
     */
    @RequestMapping("/selectById")
    public @ResponseBody
    Map<String, Object> selectById(Long daId) {
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

        if(daId == null || daId == 0L){
            message.put("status", "0");
            message.put("message", "请输入收货地址ID");
            return message;
        }

        TbDeliveryAddress tbDeliveryAddress = tbDeliveryAddressService.selectById(daId);

        if(tbUser.getuId() != tbDeliveryAddress.getDaUId()){
            message.put("status", "0");
            message.put("message", "查看失败2");
        }

        if(tbDeliveryAddress == null){
            message.put("status", "0");
            message.put("message", "查看失败");
        }else{
            message.put("status", "1");
            message.put("message", "查看成功");
            message.put("tbDeliveryAddress", tbDeliveryAddress);
        }
        return message;
    }

    /**
     * 查找收货地址列表
     * @return
     */
    @RequestMapping("/selectAll")
    public @ResponseBody
    Map<String, Object> selectAll(Integer pageNum, Integer pageSize) {
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

        if(pageNum == null || pageNum == 0){
            pageNum = 1;
        }
        if(pageSize == null || pageSize == 0){
            pageSize = 20;
        }

        PageInfo<TbDeliveryAddress> pageInfo = tbDeliveryAddressService.selectAll(tbUser.getuId(),pageNum, pageSize);
        message.put("status", "1");
        message.put("message", "查找成功");
        message.put("pageInfo", pageInfo);
        return message;
    }



    /**
     * 设置默认收货地址
     * @return
     */
    @RequestMapping("/settingDefault")
    public @ResponseBody
    Map<String, Object> settingDefault(Long daId) {
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

        if(daId == null || daId == 0L){
            message.put("status", "0");
            message.put("message", "请输入收货地址ID");
            return message;
        }

        int count = tbDeliveryAddressService.settingDefault(daId,tbUser);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "设置失败");
        }else if(count == -1){
            message.put("status", "-1");
            message.put("message", "收货地址不属于你的");
        }else if(count == -2){
            message.put("status", "-2");
            message.put("message", "收货地址不存在");
        }else{
            message.put("status", "1");
            message.put("message", "设置成功");
        }
        return message;
    }

}
