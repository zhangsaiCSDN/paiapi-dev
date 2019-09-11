package com.woniuxy.dao;

import com.woniuxy.domain.Card;
import com.woniuxy.domain.CardExample;
import com.woniuxy.domain.CardWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardMapper {
    long countByExample(CardExample example);

    int deleteByExample(CardExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(CardWithBLOBs record);

    int insertSelective(CardWithBLOBs record);

    List<CardWithBLOBs> selectByExampleWithBLOBs(CardExample example);

    List<Card> selectByExample(CardExample example);

    CardWithBLOBs selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") CardWithBLOBs record, @Param("example") CardExample example);

    int updateByExampleWithBLOBs(@Param("record") CardWithBLOBs record, @Param("example") CardExample example);

    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    int updateByPrimaryKeySelective(CardWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CardWithBLOBs record);

    int updateByPrimaryKey(Card record);
}