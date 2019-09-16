package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Pricehistory;

public interface IPriceHistoryService {
	
	void save(Pricehistory ph);
	void update(Pricehistory ph);
	void delete(Integer phid);
	Pricehistory findOne(Integer phid);
	List<Pricehistory> find(Pricehistory ph);
 
}
