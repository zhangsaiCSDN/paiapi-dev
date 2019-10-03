package com.woniuxy.service;

import java.util.List;
import com.woniuxy.domain.Announce;
import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Page;

public interface IAnnounceService {
	void save(Announce announce);
	void delete(Integer anid);
	void update(Announce announce);
	Announce findOne(Integer anid);
	List<Announce> find(Page<Announce> page);
	//查询announce总行数
	Integer count();
	
	//查询所有公告
	List<Announce> findAll();
	
	//查询所有拍品
	List<Goods> findAllGoods();
}
