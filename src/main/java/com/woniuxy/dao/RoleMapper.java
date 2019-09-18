package com.woniuxy.dao;

import com.woniuxy.domain.Role;
import com.woniuxy.domain.RoleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /////////////////////
	List<Role> findInfo();
	
	Role findRoleByRname(String rname);
	
	int insertRolePermission(Map<String,Integer> map);
	
	int deleteRolePermission(Map<String,Integer> map);
	
}