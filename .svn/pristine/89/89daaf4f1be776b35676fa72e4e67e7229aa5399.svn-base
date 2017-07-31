package com.jzf.market.dao;

import com.jzf.market.pojo.auto.TbPhoneVerification;
import com.jzf.market.pojo.auto.TbPhoneVerificationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TbPhoneVerificationMapper {
    long countByExample(TbPhoneVerificationExample example);

    int deleteByExample(TbPhoneVerificationExample example);

    int deleteByPrimaryKey(Long pvId);

    int insert(TbPhoneVerification record);

    int insertSelective(TbPhoneVerification record);

    List<TbPhoneVerification> selectByExample(TbPhoneVerificationExample example);

    TbPhoneVerification selectByPrimaryKey(Long pvId);

    int updateByExampleSelective(@Param("record") TbPhoneVerification record, @Param("example") TbPhoneVerificationExample example);

    int updateByExample(@Param("record") TbPhoneVerification record, @Param("example") TbPhoneVerificationExample example);

    int updateByPrimaryKeySelective(TbPhoneVerification record);

    int updateByPrimaryKey(TbPhoneVerification record);
}