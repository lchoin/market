package com.jzf.market.dao;

import com.jzf.market.pojo.auto.TbRole;
import com.jzf.market.pojo.auto.TbRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TbRoleMapper {
    long countByExample(TbRoleExample example);

    int deleteByExample(TbRoleExample example);

    int deleteByPrimaryKey(Long rId);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    List<TbRole> selectByExample(TbRoleExample example);

    TbRole selectByPrimaryKey(Long rId);

    int updateByExampleSelective(@Param("record") TbRole record, @Param("example") TbRoleExample example);

    int updateByExample(@Param("record") TbRole record, @Param("example") TbRoleExample example);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);
}