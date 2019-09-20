package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Apply;
import com.woniuxy.domain.Page;

public interface IApplyService {
	
	void save(Apply apply);

	void delete(Integer apid);

	void update(Apply apply);

	Apply findOne(Integer apid);

	List<Apply> find(Page<Apply> page);

	Integer count();

}
