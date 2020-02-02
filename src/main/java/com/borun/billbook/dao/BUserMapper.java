package com.borun.billbook.dao;

import com.borun.billbook.bean.BUser;
import com.borun.billbook.bean.BUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BUserMapper {
    long countByExample(BUserExample example);

    int deleteByExample(BUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BUser record);

    int insertSelective(BUser record);

    List<BUser> selectByExample(BUserExample example);

    BUser selectByPrimaryKey(Integer id);

    BUser selectByUserName(String username);

    BUser selectByMailCode(String mailcode);

    int updateByExampleSelective(@Param("record") BUser record, @Param("example") BUserExample example);

    int updateByExample(@Param("record") BUser record, @Param("example") BUserExample example);

    int updateByPrimaryKeySelective(BUser record);

    int updateByPrimaryKey(BUser record);
}