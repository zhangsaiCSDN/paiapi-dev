package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.domain.Collect;
import com.woniuxy.domain.CollectExample;
import com.woniuxy.domain.Page;

public interface CollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer clid);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer clid);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    
    List<Collect> findAll(Page<Collect> page);
    
    
    
}