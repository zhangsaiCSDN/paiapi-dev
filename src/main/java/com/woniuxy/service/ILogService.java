package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Log;

public interface ILogService {
	void save(Log log);
	void delete(Integer lig);
	void update(Log log);
	Log findOne(Integer lig);
	List<Log> findByUid(Integer uid);
	List<Log> find(); 
}
