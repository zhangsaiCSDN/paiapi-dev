package com.woniuxy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.domain.Log;
import com.woniuxy.domain.LogExample;
import com.woniuxy.domain.Page;

public interface LogMapper {
    long countByExample(LogExample example);

    int deleteByExample(LogExample example);

    int deleteByPrimaryKey(Integer lig);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(Integer lig);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
    
    
    List<Log> selectLogByPage(Page<Log> page);
    
    
    List<Log> selectBySearch(Map<String,Object> map);
    
}