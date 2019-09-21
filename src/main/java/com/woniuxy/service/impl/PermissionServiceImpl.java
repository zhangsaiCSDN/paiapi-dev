package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.PermissionMapper;
import com.woniuxy.domain.Permission;
import com.woniuxy.service.IPermissionService;
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService{

	@Autowired
	private PermissionMapper mapper; 
	
	@Override
	public void save(Permission p) {
		mapper.insert(p);
	}

	@Override
	public void delete(Integer pmsid) {
		mapper.deleteByPrimaryKey(pmsid);
	}

	@Override
	public void update(Permission p) {
		mapper.updateByPrimaryKeySelective(p);
	}

	@Override
	public Permission findOne(Integer pmsid) {
		return mapper.selectByPrimaryKey(pmsid);
	}

	@Override
	public List<Permission> find() {
		return mapper.selectByExample(null); 
	}
	
}
