package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Goodstype;

public interface IGoodsTypeService {
	void save(Goodstype goodstype);
	void delete(Integer gtid);
	void update(Goodstype goodstype);
	Goodstype findOne(Integer gtid);
	List<Goodstype> find();
	void updImg(Integer gtid, String img);
}
