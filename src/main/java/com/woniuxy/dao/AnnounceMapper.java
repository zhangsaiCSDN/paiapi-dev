package com.woniuxy.dao;

import com.woniuxy.domain.Announce;
import com.woniuxy.domain.AnnounceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnounceMapper {
    long countByExample(AnnounceExample example);

    int deleteByExample(AnnounceExample example);

    int deleteByPrimaryKey(Integer anid);

    int insert(Announce record);

    int insertSelective(Announce record);

    List<Announce> selectByExampleWithBLOBs(AnnounceExample example);

    List<Announce> selectByExample(AnnounceExample example);

    Announce selectByPrimaryKey(Integer anid);

    int updateByExampleSelective(@Param("record") Announce record, @Param("example") AnnounceExample example);

    int updateByExampleWithBLOBs(@Param("record") Announce record, @Param("example") AnnounceExample example);

    int updateByExample(@Param("record") Announce record, @Param("example") AnnounceExample example);

    int updateByPrimaryKeySelective(Announce record);

    int updateByPrimaryKeyWithBLOBs(Announce record);

    int updateByPrimaryKey(Announce record);
}