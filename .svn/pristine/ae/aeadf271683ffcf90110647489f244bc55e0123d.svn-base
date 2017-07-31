package com.jzf.market.service;

import com.jzf.market.common.utils.IndentPKUtil;
import com.jzf.market.dao.TbPersonIndentMapper;
import com.jzf.market.pojo.auto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
@Transactional
@Service
public class TbPersonIndentService {
    @Autowired
    private TbPersonIndentMapper tbPersonIndentMapper;
    @Autowired
    private TbGoodsService tbGoodsService;
    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private TbConsumptionService tbConsumptionService;
    @Autowired
    private TbDeliveryAddressService tbDeliveryAddressService;

    public List<Map<String,Object>> selectComment(Long gId) {
        TbPersonIndentExample tbPersonIndentExample = new TbPersonIndentExample();
        tbPersonIndentExample.createCriteria().andPiGIdEqualTo(gId);
        tbPersonIndentExample.setOrderByClause("pi_create_date desc");
        List<TbPersonIndent> tbPersonIndents = tbPersonIndentMapper.selectByExample(tbPersonIndentExample);

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = null;
        for (TbPersonIndent tbPersonIndent : tbPersonIndents) {
            map = new HashMap<String,Object>();
            TbUser tbUser = tbUserService.findById(tbPersonIndent.getPiUId());
            map.put("tbPersonIndent",tbPersonIndent);
            map.put("tbUser",tbUser);
            list.add(map);
        }
        return list;
    }

    public List<Map<String,Object>> selectAllByUserId(Long userId) {
        TbPersonIndentExample tbPersonIndentExamples = new TbPersonIndentExample();
        TbPersonIndentExample.Criteria criteria = tbPersonIndentExamples.createCriteria();
        if(userId != null){
            criteria.andPiUIdEqualTo(userId);
        }
        tbPersonIndentExamples.setOrderByClause("pi_create_date desc");
        List<TbPersonIndent> tbPersonIndents = tbPersonIndentMapper.selectByExample(tbPersonIndentExamples);

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = null;
        TbGoods tbGoods = null;
        TbDeliveryAddress tbDeliveryAddress = null;
        for (TbPersonIndent tbPersonIndent : tbPersonIndents) {
            map = new HashMap<String,Object>();
            tbGoods = tbGoodsService.selectById(tbPersonIndent.getPiGId());

            tbDeliveryAddress = tbDeliveryAddressService.selectById(tbPersonIndent.getDaId());
            map.put("uName",tbDeliveryAddress.getDaName());

            map.put("tbPersonIndent",tbPersonIndent);
            map.put("tbGoods",tbGoods);
            list.add(map);
        }
        return list;
    }

    public int comment(String piId, String piEvaluateLanguage, String piEvaluateGrade,TbUser tbUser) {
        TbPersonIndent tbPersonIndent = tbPersonIndentMapper.selectByPrimaryKey(piId);
        if(!tbPersonIndent.getPiStatus().equals("3")){
            return 0;
        }
        if(!tbUser.getuId().equals(tbPersonIndent.getPiUId())){
            return 0;
        }
        tbPersonIndent.setPiEvaluateLanguage(piEvaluateLanguage);
        tbPersonIndent.setPiEvaluateGrade(piEvaluateGrade);
        tbPersonIndent.setPiStatus("4");
        return tbPersonIndentMapper.updateByPrimaryKeySelective(tbPersonIndent);
    }

    public List<Map<String,Object>> selectAll() {
        return selectAllByUserId(null);
    }

    public int updateStatusById(String piId, String piStatus) {

        TbPersonIndent tbPersonIndent = tbPersonIndentMapper.selectByPrimaryKey(piId);
        tbPersonIndent.setPiStatus(piStatus);
        if(piStatus.equals("2")){
            tbPersonIndent.setPiShipmentsDate(new Date());
        }else if(piStatus.equals("3")){
            tbPersonIndent.setPiArrivalDate(new Date());
        }else{
            return 0;
        }

        return tbPersonIndentMapper.updateByPrimaryKeySelective(tbPersonIndent);

    }

    public int buy(Long uId, Long piGId, Integer piQuantity,Long daId) {
        TbGoods tbGoods = tbGoodsService.selectById(piGId);
        if(tbGoods == null){
            return -2;
        }else{
            //判断购买数量是否大于商品库存量，大于的话购买失败
            if(piQuantity > tbGoods.getgInventory()){
                return -3;
            }
        }
        TbUser tbUser = tbUserService.findById(uId);
        String money = tbGoods.getgPrice().multiply(new BigDecimal(piQuantity)).add(tbGoods.getgFreight()).toString();
        BigDecimal moneyBigDecimal = new BigDecimal(money);
        //判断用户可用金额是否充足
        if(tbUser.getuUsableMoney().compareTo(moneyBigDecimal) < 0){
            return -1;
        }

        TbPersonIndent tbPersonIndent = new TbPersonIndent();

        TbDeliveryAddress tbDeliveryAddress = tbDeliveryAddressService.selectById(daId);
        if(tbDeliveryAddress == null){
            return -4;
        }else{
            tbPersonIndent.setDaId(tbDeliveryAddress.getDaId());
            tbPersonIndent.setDaDetailAddress(tbDeliveryAddress.getDaDetailAddress());
            tbPersonIndent.setDaPhone(tbDeliveryAddress.getDaPhone());
        }

        tbPersonIndent.setPiId(IndentPKUtil.generateSequenceNo());
        tbPersonIndent.setPiGId(piGId);
        tbPersonIndent.setPiUId(uId);
        tbPersonIndent.setPiStatus("1");
        tbPersonIndent.setPiCreateDate(new Date());
        tbPersonIndent.setPiQuantity(piQuantity);
        int count = tbPersonIndentMapper.insertSelective(tbPersonIndent);
        if(count == 0){
            return 0;
        }
        //推销算法
        count = tbConsumptionService.consumption(money,tbUser);

        if(count == 1){
            //商品库存-1
            tbGoods.setgInventory(tbGoods.getgInventory()-piQuantity);
            //月销量+1
            tbGoods.setgMonthSales(tbGoods.getgMonthSales()+piQuantity);
            tbGoodsService.updateById(tbGoods);
        }

        return count;
    }

    public int deleteByUserId(String piid) {

        return tbPersonIndentMapper.deleteByPrimaryKey(piid);
    }

    public int insertExpressCompany(String piId, String tracking_number, String carrier_code) {
        TbPersonIndent tbPersonIndent = new TbPersonIndent();
        tbPersonIndent.setPiId(piId);
        tbPersonIndent.setPiTrackingNumber(tracking_number);
        tbPersonIndent.setPiCarrierCode(carrier_code);
        return tbPersonIndentMapper.updateByPrimaryKeySelective(tbPersonIndent);
    }
}
