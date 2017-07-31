package com.jzf.market.controller.web;

import com.jzf.market.pojo.auto.TbGoods;
import com.jzf.market.pojo.auto.TbPersonIndent;
import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.service.TbDeliveryAddressService;
import com.jzf.market.service.TbGoodsService;
import com.jzf.market.service.TbPersonIndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * 商品
  * @name : feng
  * @date : 2017/1/16 0016 17:11
 **/
@Controller
@RequestMapping("/TbGoods")
public class TbGoodsController extends BaseController  {
    @Autowired
    private TbGoodsService tbGoodsService;
    @Autowired
    private TbPersonIndentService tbPersonIndentService;
    @Autowired
    private TbDeliveryAddressService tbDeliveryAddressService;

    /**
     * 添加商品(管理员)
     *
     * @return
     */
    @RequestMapping("/insert")
    public
    @ResponseBody
    Map<String, Object> insert(TbGoods tbGoods) {
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

        if(tbGoods.getgName() == null || tbGoods.getgName().equals("")){
            message.put("status", "0");
            message.put("message", "请输入商品名称");
            return message;
        }
        if(tbGoods.getgPrice() == null || tbGoods.getgPrice().equals("")){
            message.put("status", "0");
            message.put("message", "请输入商品价格");
            return message;
        }else{
            if(tbGoods.getgPrice().compareTo(new BigDecimal("0")) <= 0){
                message.put("status", "0");
                message.put("message", "商品价格请输入大于0");
                return message;
            }
        }
        if(tbGoods.getgFreight() == null || tbGoods.getgFreight().equals("")){
            tbGoods.setgFreight(new BigDecimal("0"));
        }

        if(tbGoods.getgInventory() == null || tbGoods.getgInventory() == 0L){
            tbGoods.setgInventory(1L);
        }
        int count = tbGoodsService.insert(tbGoods);
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
     * 修改商品(管理员)
     *
     * @return
     */
    @RequestMapping("/updateById")
    public
    @ResponseBody
    Map<String, Object> updateById(TbGoods tbGoods) {
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

        if(tbGoods.getgId() == null || tbGoods.getgId() == 0L){
            message.put("status", "0");
            message.put("message", "请输入商品ID");
            return message;
        }

        int count = tbGoodsService.updateById(tbGoods);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "修改失败");
        }else{
            message.put("status", "1");
            message.put("message", "修改成功");
        }
        return message;
    }

    /**
     * 查看商品列表
     *
     * @return
     */
    @RequestMapping("/selectAll")
    public
    @ResponseBody
    Map<String, Object> selectAll() {
        Map<String, Object> message = new HashMap<String, Object>();

        List<TbGoods> tbGoodss = tbGoodsService.selectAll();
        message.put("status", "1");
        message.put("message", "查找成功");
        message.put("tbGoodss",tbGoodss);
        return message;
    }

    /**
     * 查看商品详情
     *
     * @return
     */
    @RequestMapping("/selectById")
    public
    @ResponseBody
    Map<String, Object> selectById(Long gId) {
        Map<String, Object> message = new HashMap<String, Object>();
        if(gId == null || gId == 0L){
            message.put("status", "0");
            message.put("message", "请输入商品ID");
            return message;
        }

        TbGoods tbGoods = tbGoodsService.selectById(gId);
        if(tbGoods == null){
            message.put("status", "0");
            message.put("message", "查找失败");
        }else{
            message.put("status", "0");
            message.put("message", "查找成功");
            message.put("tbGoods", tbGoods);
            message.put("comments", tbPersonIndentService.selectComment(tbGoods.getgId()));
        }
        return message;
    }

    /**
     * 查看个人购买商品列表
     *
     * @return
     */
    @RequestMapping("/selectAllByUserId")
    public
    @ResponseBody
    Map<String, Object> selectAllByUserId() {
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

        List<Map<String,Object>> tbGoodss = tbPersonIndentService.selectAllByUserId(tbUser.getuId());
        message.put("status", "1");
        message.put("message", "查找成功");
        message.put("tbGoodss",tbGoodss);
        return message;
    }

    /**
     * 删除个人购买商品
     *
     * @return
     */
    @RequestMapping("/deleteByUserId")
    public
    @ResponseBody
    Map<String, Object> deleteByUserId(String piid) {
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

        int count = tbPersonIndentService.deleteByUserId(piid);
        if(count == 0 ){
            message.put("status", "0");
            message.put("message", "删除失败");
        }else{
            message.put("status", "1");
            message.put("message", "删除成功");
        }
        return message;
    }

    /**
     * 评论商品
     *
     * @return
     */
    @RequestMapping("/comment")
    public
    @ResponseBody
    Map<String, Object> comment(String piId,String piEvaluateLanguage,String piEvaluateGrade) {
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
        if(piEvaluateLanguage == null || piEvaluateLanguage.equals("")){
            message.put("status", "0");
            message.put("message", "请输入评价语");
            return message;
        }
        if(piEvaluateGrade == null || piEvaluateGrade.equals("")){
            message.put("status", "0");
            message.put("message", "请输入评价星级");
            return message;
        }

        int count = tbPersonIndentService.comment(piId,piEvaluateLanguage,piEvaluateGrade,tbUser);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "评论失败");
        }else{
            message.put("status", "1");
            message.put("message", "评论成功");
        }
        return message;
    }


    /**
     * 购买商品
     * @param piGId         商品ID
     * @param piQuantity    购买数量
     * @param daId          收货地址ID
     * @return
     */
    @RequestMapping("/buy")
    public
    @ResponseBody
    Map<String, Object> buy(Long piGId,Integer piQuantity,Long daId) {
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
        if(piGId == null || piGId.equals("")){
            message.put("status", "0");
            message.put("message", "请输入商品ID");
            return message;
        }
        if(piQuantity == null || piQuantity == 0){
            piQuantity = 1;
        }
        if(daId == null || daId == 0L){
            daId =  tbDeliveryAddressService.selectByDefault(tbUser.getuId());
            if(daId == null || daId == 0L){
                message.put("status", "0");
                message.put("message", "请输入收货地址ID");
                return message;
            }
        }

        int count = tbPersonIndentService.buy(tbUser.getuId(),piGId,piQuantity,daId);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "购买失败");
        }else if(count == -1){
            message.put("status", "-1");
            message.put("message", "可用金额不足");
        }else if(count == 1){
            message.put("status", "1");
            message.put("message", "购买成功");
        }else if(count == -2){
            message.put("status", "-2");
            message.put("message", "商品不存在");
        }else if(count == -3){
            message.put("status", "-3");
            message.put("message", "商品库存不够了,亲!");
        }else if(count == -4){
            message.put("status", "-4");
            message.put("message", "收货地址不存在,亲!");
        }
        return message;
    }

    /**
     * 删除商品
     *
     * @return
     */
    @RequestMapping("/deleteById")
    public
    @ResponseBody
    Map<String, Object> deleteById(Long piId) {
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

        if(piId == null || piId == 0L){
            message.put("status", "0");
            message.put("message", "请输入商品ID");
            return message;
        }


        int count = tbGoodsService.deleteById(piId);
        if(count == 0){
            message.put("status", "0");
            message.put("message", "删除失败");
        }else{
            message.put("status", "1");
            message.put("message", "删除成功");
        }
        return message;
    }


}
