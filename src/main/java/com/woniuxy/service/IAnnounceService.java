package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Announce;

public interface IAnnounceService {
	void save(Announce announce);
	void delete(Integer anid);
	void update(Announce announce);
	Announce findOne(Integer anid);
	List<Announce> find();
	
}
