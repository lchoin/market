package com.jzf.market.dao;

import com.jzf.market.pojo.auto.TbUserRole;
import com.jzf.market.pojo.auto.TbUserRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TbUserRoleMapper {
    long countByExample(TbUserRoleExample example);

    int deleteByExample(TbUserRoleExample example);

    int deleteByPrimaryKey(Long urId);

    int insert(TbUserRole record);

    int insertSelective(TbUserRole record);

    List<TbUserRole> selectByExample(TbUserRoleExample example);

    TbUserRole selectByPrimaryKey(Long urId);

    int updateByExampleSelective(@Param("record") TbUserRole record, @Param("example") TbUserRoleExample example);

    int updateByExample(@Param("record") TbUserRole record, @Param("example") TbUserRoleExample example);

    int updateByPrimaryKeySelective(TbUserRole record);

    int updateByPrimaryKey(TbUserRole record);
}