package com.woniuxy.dao;

import com.woniuxy.domain.User;
import com.woniuxy.domain.UserExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record); 
    
    //////////////////////////////////////
    List<User> findInfo();
    
    User findInfoById(Integer uid);
    
    User findUserByUname(String uname);
    
    int insertUserRole(Map<String, Integer> map);

}