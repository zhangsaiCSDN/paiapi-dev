package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Collect;
import com.woniuxy.domain.Page;

public interface ICollectService {

	void save(Collect collect);

	void delete(Integer clid);

	void update(Collect collect);

	Collect findOne(Integer clid);

	List<Collect> find(Page<Collect> page);

	Integer count();

}
