package com.jzf.market.dao;

import com.jzf.market.pojo.auto.TbEarnings;
import com.jzf.market.pojo.auto.TbEarningsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TbEarningsMapper {
    long countByExample(TbEarningsExample example);

    int deleteByExample(TbEarningsExample example);

    int deleteByPrimaryKey(Long eId);

    int insert(TbEarnings record);

    int insertSelective(TbEarnings record);

    List<TbEarnings> selectByExample(TbEarningsExample example);

    TbEarnings selectByPrimaryKey(Long eId);

    int updateByExampleSelective(@Param("record") TbEarnings record, @Param("example") TbEarningsExample example);

    int updateByExample(@Param("record") TbEarnings record, @Param("example") TbEarningsExample example);

    int updateByPrimaryKeySelective(TbEarnings record);

    int updateByPrimaryKey(TbEarnings record);
}