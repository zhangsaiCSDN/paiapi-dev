package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.LogMapper;
import com.woniuxy.domain.Log;
import com.woniuxy.service.ILogService;

@Service
@Transactional
public class LogServiceImpl implements ILogService {
	
	@Autowired 
	private LogMapper mapper;

	@Override
	public void save(Log log) {
		mapper.insert(log);
	}

	@Override
	public void delete(Integer lig) {
		mapper.deleteByPrimaryKey(lig);
	}

	@Override
	public void update(Log log) {
		mapper.updateByPrimaryKeySelective(log);
	}

	@Override
	public Log findOne(Integer lig) {
		return mapper.selectByPrimaryKey(lig);
	}

	@Override
	public List<Log> find() {
		return mapper.selectByExample(null);
	}
	 
	@Override
	public List<Log> findByUid(Integer uid) {
		return mapper.selectLogByUid(uid);
	}

}
