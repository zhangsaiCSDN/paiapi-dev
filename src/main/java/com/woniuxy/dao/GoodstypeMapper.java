package com.woniuxy.dao;

import com.woniuxy.domain.Goodstype;
import com.woniuxy.domain.GoodstypeExample;
import com.woniuxy.domain.GoodstypeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodstypeMapper {
    long countByExample(GoodstypeExample example);

    int deleteByExample(GoodstypeExample example);

    int deleteByPrimaryKey(Integer gtid);

    int insert(GoodstypeWithBLOBs record);

    int insertSelective(GoodstypeWithBLOBs record);

    List<GoodstypeWithBLOBs> selectByExampleWithBLOBs(GoodstypeExample example);

    List<Goodstype> selectByExample(GoodstypeExample example);

    GoodstypeWithBLOBs selectByPrimaryKey(Integer gtid);

    int updateByExampleSelective(@Param("record") GoodstypeWithBLOBs record, @Param("example") GoodstypeExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodstypeWithBLOBs record, @Param("example") GoodstypeExample example);

    int updateByExample(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByPrimaryKeySelective(GoodstypeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodstypeWithBLOBs record);

    int updateByPrimaryKey(Goodstype record);
}