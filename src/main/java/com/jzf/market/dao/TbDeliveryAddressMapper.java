package com.jzf.market.dao;

import com.jzf.market.pojo.auto.TbDeliveryAddress;
import com.jzf.market.pojo.auto.TbDeliveryAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDeliveryAddressMapper {
    long countByExample(TbDeliveryAddressExample example);

    int deleteByExample(TbDeliveryAddressExample example);

    int deleteByPrimaryKey(Long daId);

    int insert(TbDeliveryAddress record);

    int insertSelective(TbDeliveryAddress record);

    List<TbDeliveryAddress> selectByExample(TbDeliveryAddressExample example);

    TbDeliveryAddress selectByPrimaryKey(Long daId);

    int updateByExampleSelective(@Param("record") TbDeliveryAddress record, @Param("example") TbDeliveryAddressExample example);

    int updateByExample(@Param("record") TbDeliveryAddress record, @Param("example") TbDeliveryAddressExample example);

    int updateByPrimaryKeySelective(TbDeliveryAddress record);

    int updateByPrimaryKey(TbDeliveryAddress record);
}