package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Page;

public interface IGoodsService {
	void save(Goods goods);
	void delete(Integer gid);
	void update(Goods goods);
	List<Goods> find(Page<Goods> page);
	Goods findOne(Integer gid);
	List<Goods> findByImages();
	Integer count();
}
