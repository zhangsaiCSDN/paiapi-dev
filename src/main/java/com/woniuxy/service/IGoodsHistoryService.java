package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Goodshistory;

public interface IGoodsHistoryService {
	
	void save(Goodshistory gh);
	void update(Goodshistory gh);
	void delete(Integer ghid);
	Goodshistory findOne(Integer ghid);
	List<Goodshistory> find();

}
