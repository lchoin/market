package com.jzf.market.controller.web;

import com.jzf.market.pojo.auto.TbConsumption;
import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.service.TbConsumptionService;
import com.jzf.market.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
@Controller
@RequestMapping("/TbConsumption")
public class TbConsumptionController extends BaseController {
    @Autowired
    private TbConsumptionService tbConsumptionService;
    @Autowired
    private TbUserService tbUserService;

    /**
     * 查找个人消费
     * @return
     */
    @RequestMapping("/selectAll")
    public @ResponseBody
    Map<String, Object> selectAll(Integer pageNum,Integer pageSize) {
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

        Map<String,Object> map = tbConsumptionService.selectAll(tbUser.getuId(),pageNum,pageSize);
        tbUser = tbUserService.findById(tbUser.getuId());
        message.put("status", "1");
        message.put("message", "查找成功");
        message.putAll(map);
        message.put("sumMoney",tbUser.getuSumMoney());
        message.put("usableMoney",tbUser.getuUsableMoney());
        return message;
    }
}
