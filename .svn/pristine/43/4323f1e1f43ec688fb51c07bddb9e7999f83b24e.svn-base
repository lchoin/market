package com.jzf.market.dao;

import com.jzf.market.pojo.auto.TbAuthentication;
import com.jzf.market.pojo.auto.TbAuthenticationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TbAuthenticationMapper {
    long countByExample(TbAuthenticationExample example);

    int deleteByExample(TbAuthenticationExample example);

    int deleteByPrimaryKey(Long aId);

    int insert(TbAuthentication record);

    int insertSelective(TbAuthentication record);

    List<TbAuthentication> selectByExample(TbAuthenticationExample example);

    TbAuthentication selectByPrimaryKey(Long aId);

    int updateByExampleSelective(@Param("record") TbAuthentication record, @Param("example") TbAuthenticationExample example);

    int updateByExample(@Param("record") TbAuthentication record, @Param("example") TbAuthenticationExample example);

    int updateByPrimaryKeySelective(TbAuthentication record);

    int updateByPrimaryKey(TbAuthentication record);
}