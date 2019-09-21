package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Log;
import com.woniuxy.domain.Page;

public interface ILogService {
	void save(Log log);
	void delete(Integer lig);
	void update(Log log);
	Log findOne(Integer lig);
	List<Log> findByPage(Page<Log> page);
	List<Log> find(); 
	long count();
}
