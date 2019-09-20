package com.woniuxy.service;

import java.util.List;
import java.util.Map;

import com.woniuxy.domain.Page;
import com.woniuxy.domain.Pricehistory;

public interface IPriceHistoryService {
	
	void save(Pricehistory ph);
	void update(Pricehistory ph);
	void delete(Integer phid);
	Pricehistory findOne(Integer phid);
	Page<Pricehistory> find(Map<String , Object> map);
 
}
