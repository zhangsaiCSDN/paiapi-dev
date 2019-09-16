package com.woniuxy.dao;

import com.woniuxy.domain.Goodshistory;
import com.woniuxy.domain.GoodshistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodshistoryMapper {
    long countByExample(GoodshistoryExample example);

    int deleteByExample(GoodshistoryExample example);

    int deleteByPrimaryKey(Integer ghid);

    int insert(Goodshistory record);

    int insertSelective(Goodshistory record);

    List<Goodshistory> selectByExample(GoodshistoryExample example);

    Goodshistory selectByPrimaryKey(Integer ghid);

    int updateByExampleSelective(@Param("record") Goodshistory record, @Param("example") GoodshistoryExample example);

    int updateByExample(@Param("record") Goodshistory record, @Param("example") GoodshistoryExample example);

    int updateByPrimaryKeySelective(Goodshistory record);

    int updateByPrimaryKey(Goodshistory record);
   
    List<Goodshistory> find();
}