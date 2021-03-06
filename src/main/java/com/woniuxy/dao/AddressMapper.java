package com.woniuxy.dao;

import com.woniuxy.domain.Address;
import com.woniuxy.domain.AddressExample;
import com.woniuxy.domain.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    
    List<Address> findAll(Page<Address> page);
    
    List<Address> findByUid(Map<String , Object> map);
    Integer findCount(Map<String , Object> map);//根据用户uid查询
}