package com.woniuxy.service;

import java.util.List;
import java.util.Map;

import com.woniuxy.domain.Goodshistory;
import com.woniuxy.domain.Page;

public interface IGoodsHistoryService {
	
	void save(Goodshistory gh);
	void update(Goodshistory gh);
	void delete(Integer ghid);
	Goodshistory findOne(Integer ghid);
	Page<Goodshistory> find(Map<String , Object> map);
	Page<Goodshistory> findByBuyerid(Map<String , Object> map);

}
