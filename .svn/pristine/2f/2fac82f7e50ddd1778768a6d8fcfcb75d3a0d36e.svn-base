package com.jzf.market.controller.app;

import com.jzf.market.common.utils.Express;
import com.jzf.market.controller.web.BaseController;
import com.jzf.market.pojo.auto.TbUser;
import com.jzf.market.service.TbPersonIndentService;
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
@RequestMapping("/TbPersonIndentApp")
public class TbPersonIndentAppController extends BaseAPPController  {
    @Autowired
    private TbPersonIndentService tbPersonIndentService;

    /**
     * 修改订单状态
     *
     * @return
     */
    @RequestMapping("/updateStatusById")
    public
    @ResponseBody
    Map<String, Object> updateStatusById(String TokenID,String piId,String piStatus) {
        Map<String, Object> message = new HashMap<String, Object>();
        TbUser tbUser = null;
        if (isAuthenticated(TokenID)) {
            Object object = findUserInfo(TokenID);
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
     * 查看订单物流详情
     *
     * @return
     */
    @RequestMapping("/selectExpress")
    public
    @ResponseBody
    Map<String, Object> selectExpress(String TokenID,String tracking_number,String carrier_code) {
        Map<String, Object> message = new HashMap<String, Object>();
        TbUser tbUser = null;
        if (isAuthenticated(TokenID)) {
            Object object = findUserInfo(TokenID);
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


}
