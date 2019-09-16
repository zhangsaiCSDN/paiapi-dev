package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Goods;

public interface IGoodsService {
	void save(Goods goods);
	void delete(Integer gid);
	void update(Goods goods);
	List<Goods> find();
	Goods findOne(Integer gid);
}
