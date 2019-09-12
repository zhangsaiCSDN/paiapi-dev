package com.woniuxy.dao;

import com.woniuxy.domain.Goods;
import com.woniuxy.domain.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
 
public interface GoodsMapper {
    long countByExample(GoodsExample example); 

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}