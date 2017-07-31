package com.jzf.market.dao;

import com.jzf.market.pojo.auto.TbPersonIndent;
import com.jzf.market.pojo.auto.TbPersonIndentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPersonIndentMapper {
    long countByExample(TbPersonIndentExample example);

    int deleteByExample(TbPersonIndentExample example);

    int deleteByPrimaryKey(String piId);

    int insert(TbPersonIndent record);

    int insertSelective(TbPersonIndent record);

    List<TbPersonIndent> selectByExample(TbPersonIndentExample example);

    TbPersonIndent selectByPrimaryKey(String piId);

    int updateByExampleSelective(@Param("record") TbPersonIndent record, @Param("example") TbPersonIndentExample example);

    int updateByExample(@Param("record") TbPersonIndent record, @Param("example") TbPersonIndentExample example);

    int updateByPrimaryKeySelective(TbPersonIndent record);

    int updateByPrimaryKey(TbPersonIndent record);
}