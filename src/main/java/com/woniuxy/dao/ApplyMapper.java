package com.woniuxy.dao;

import com.woniuxy.domain.Apply;
import com.woniuxy.domain.ApplyExample;
import com.woniuxy.domain.ApplyWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {
    long countByExample(ApplyExample example);

    int deleteByExample(ApplyExample example);

    int deleteByPrimaryKey(Integer apid);

    int insert(ApplyWithBLOBs record);

    int insertSelective(ApplyWithBLOBs record);

    List<ApplyWithBLOBs> selectByExampleWithBLOBs(ApplyExample example);

    List<Apply> selectByExample(ApplyExample example);

    ApplyWithBLOBs selectByPrimaryKey(Integer apid);

    int updateByExampleSelective(@Param("record") ApplyWithBLOBs record, @Param("example") ApplyExample example);

    int updateByExampleWithBLOBs(@Param("record") ApplyWithBLOBs record, @Param("example") ApplyExample example);

    int updateByExample(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByPrimaryKeySelective(ApplyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ApplyWithBLOBs record);

    int updateByPrimaryKey(Apply record);
}