package com.woniuxy.dao;

import com.woniuxy.domain.Pricehistory;
import com.woniuxy.domain.PricehistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PricehistoryMapper {
    long countByExample(PricehistoryExample example);

    int deleteByExample(PricehistoryExample example);

    int deleteByPrimaryKey(Integer phid);

    int insert(Pricehistory record);

    int insertSelective(Pricehistory record);

    List<Pricehistory> selectByExample(PricehistoryExample example);

    Pricehistory selectByPrimaryKey(Integer phid);

    int updateByExampleSelective(@Param("record") Pricehistory record, @Param("example") PricehistoryExample example);

    int updateByExample(@Param("record") Pricehistory record, @Param("example") PricehistoryExample example);

    int updateByPrimaryKeySelective(Pricehistory record);

    int updateByPrimaryKey(Pricehistory record);
    
    List<Pricehistory> find(Pricehistory ph);
}