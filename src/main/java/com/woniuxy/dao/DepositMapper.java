package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.domain.Deposit;
import com.woniuxy.domain.DepositExample;
import com.woniuxy.domain.Page;

public interface DepositMapper {
    long countByExample(DepositExample example);

    int deleteByExample(DepositExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Deposit record);

    int insertSelective(Deposit record);

    List<Deposit> selectByExample(DepositExample example);

    Deposit selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Deposit record, @Param("example") DepositExample example);

    int updateByExample(@Param("record") Deposit record, @Param("example") DepositExample example);

    int updateByPrimaryKeySelective(Deposit record);

    int updateByPrimaryKey(Deposit record);
    
    int findCount();
    
    List<Deposit> findAll(Page<Deposit> page);
    
    List<Deposit> findDepo(Page<Deposit> page);
}