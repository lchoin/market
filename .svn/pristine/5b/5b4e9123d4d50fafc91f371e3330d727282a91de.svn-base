package com.jzf.market.dao;

import com.jzf.market.pojo.auto.TbConsumption;
import com.jzf.market.pojo.auto.TbConsumptionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TbConsumptionMapper {
    long countByExample(TbConsumptionExample example);

    int deleteByExample(TbConsumptionExample example);

    int deleteByPrimaryKey(Long cId);

    int insert(TbConsumption record);

    int insertSelective(TbConsumption record);

    List<TbConsumption> selectByExample(TbConsumptionExample example);

    TbConsumption selectByPrimaryKey(Long cId);

    int updateByExampleSelective(@Param("record") TbConsumption record, @Param("example") TbConsumptionExample example);

    int updateByExample(@Param("record") TbConsumption record, @Param("example") TbConsumptionExample example);

    int updateByPrimaryKeySelective(TbConsumption record);

    int updateByPrimaryKey(TbConsumption record);
}