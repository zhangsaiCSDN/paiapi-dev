package com.woniuxy.dao;

import com.woniuxy.domain.Userstest;
import com.woniuxy.domain.UserstestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
//mybatis 逆向工程测试
public interface UserstestMapper {
    long countByExample(UserstestExample example);

    int deleteByExample(UserstestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userstest record);

    int insertSelective(Userstest record);

    List<Userstest> selectByExample(UserstestExample example);

    Userstest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userstest record, @Param("example") UserstestExample example);

    int updateByExample(@Param("record") Userstest record, @Param("example") UserstestExample example);

    int updateByPrimaryKeySelective(Userstest record);

    int updateByPrimaryKey(Userstest record);
}