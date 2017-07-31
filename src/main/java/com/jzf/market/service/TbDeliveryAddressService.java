package com.jzf.market.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzf.market.dao.TbDeliveryAddressMapper;
import com.jzf.market.pojo.auto.TbConsumption;
import com.jzf.market.pojo.auto.TbDeliveryAddress;
import com.jzf.market.pojo.auto.TbDeliveryAddressExample;
import com.jzf.market.pojo.auto.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by feng on 2017/1/17 0017.
 */
@Transactional
@Service
public class TbDeliveryAddressService {
    @Autowired
    private TbDeliveryAddressMapper tbDeliveryAddressMapper;
    @Autowired
    private TbUserService tbUserService;


    public int insert(TbDeliveryAddress tbDeliveryAddress) {
        tbDeliveryAddress.setDaCreateDate(new Date());
        if(tbDeliveryAddress.getDaIsDefault().equals("1")) {
            clearDefault(tbDeliveryAddress);
        }
        return tbDeliveryAddressMapper.insertSelective(tbDeliveryAddress);
    }

    private void clearDefault(TbDeliveryAddress tbDeliveryAddress) {
            //查询收货地址是否有默认的，有的话设置为否
            TbDeliveryAddressExample tbDeliveryAddressExample = new TbDeliveryAddressExample();
            tbDeliveryAddressExample.createCriteria().andDaUIdEqualTo(tbDeliveryAddress.getDaUId()).andDaIsDefaultEqualTo("1");
            List<TbDeliveryAddress> tbDeliveryAddresses = tbDeliveryAddressMapper.selectByExample(tbDeliveryAddressExample);
            if(tbDeliveryAddresses != null && tbDeliveryAddresses.size() != 0){
                TbDeliveryAddress tbDeliveryAddress1 = tbDeliveryAddresses.get(0);
                tbDeliveryAddress1.setDaIsDefault("0");
                tbDeliveryAddressMapper.updateByPrimaryKey(tbDeliveryAddress1);
            }
    }

    public int updateById(TbDeliveryAddress tbDeliveryAddress,TbUser tbUser) {
        TbUser byId = tbUserService.findById(tbDeliveryAddress.getDaUId());
        if(byId.getuId() != tbUser.getuId()){
            return -1;
        }

        if(tbDeliveryAddress.getDaIsDefault().equals("1")) {
            clearDefault(tbDeliveryAddress);
        }
        return tbDeliveryAddressMapper.updateByPrimaryKeySelective(tbDeliveryAddress);
    }

    public int deleteById(Long daId,TbUser tbUser ) {
        TbDeliveryAddress tbDeliveryAddress = selectById(daId);
        Integer x = hasUsable(tbDeliveryAddress, tbUser);
        if (x != null) return x;
        return tbDeliveryAddressMapper.deleteByPrimaryKey(daId);
    }

    private Integer hasUsable(TbDeliveryAddress tbDeliveryAddress, TbUser tbUser) {
        if(tbDeliveryAddress == null){
            return -2;
        }
        if(tbDeliveryAddress.getDaUId() != tbUser.getuId()){
            return -1;
        }
        return null;
    }

    public TbDeliveryAddress selectById(Long daId) {
        return tbDeliveryAddressMapper.selectByPrimaryKey(daId);
    }

    public int settingDefault(Long daId,TbUser tbUser) {
        TbDeliveryAddress tbDeliveryAddress = selectById(daId);
        //判断是否有数据或者是否是自己的收货地址
        Integer x = hasUsable(tbDeliveryAddress, tbUser);
        if (x != null) return x;
        //判断收货地址是否有默认的，有则设为否
        clearDefault(tbDeliveryAddress);

        //开始设置默认
        tbDeliveryAddress.setDaIsDefault("1");
        return tbDeliveryAddressMapper.updateByPrimaryKeySelective(tbDeliveryAddress);
    }

    public PageInfo<TbDeliveryAddress> selectAll(Long userId, Integer pageNum, Integer pageSize) {
        TbDeliveryAddressExample tbDeliveryAddressExample = new TbDeliveryAddressExample();
        tbDeliveryAddressExample.createCriteria().andDaUIdEqualTo(userId);
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(pageNum, pageSize,"da_create_date desc");
        List<TbDeliveryAddress> tbDeliveryAddresses = tbDeliveryAddressMapper.selectByExample(tbDeliveryAddressExample);
        // 取分页信息
        PageInfo<TbDeliveryAddress> pageInfo = new PageInfo<TbDeliveryAddress>(tbDeliveryAddresses);
        return pageInfo;
    }

    public Long selectByDefault(Long userId) {
        TbDeliveryAddressExample tbDeliveryAddressExample = new TbDeliveryAddressExample();
        tbDeliveryAddressExample.createCriteria().andDaUIdEqualTo(userId).andDaIsDefaultEqualTo("1");
        List<TbDeliveryAddress> tbDeliveryAddresses = tbDeliveryAddressMapper.selectByExample(tbDeliveryAddressExample);
        if(tbDeliveryAddresses == null || tbDeliveryAddresses.size() == 0){
            return null;
        }
        return tbDeliveryAddresses.get(0).getDaId();
    }
}
