package com.woniuxy.dao;

import com.woniuxy.domain.Announce;
import com.woniuxy.domain.AnnounceExample;
import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Page;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AnnounceMapper {

	long countByExample(AnnounceExample example);

    int deleteByExample(AnnounceExample example);

    int deleteByPrimaryKey(Integer anid);

    int insert(Announce record);

    int insertSelective(Announce record);

    List<Announce> selectByExample(AnnounceExample example);

    Announce selectByPrimaryKey(Integer anid);

    int updateByExampleSelective(@Param("record") Announce record, @Param("example") AnnounceExample example);

    int updateByExample(@Param("record") Announce record, @Param("example") AnnounceExample example);

    int updateByPrimaryKeySelective(Announce record);

    int updateByPrimaryKey(Announce record);

	List<Announce> findInfo(Page<Announce> page);
	//查询所有拍品
	List<Goods> findAllGoods();
	//查询所有公告
	List<Announce> findAll();
	
}