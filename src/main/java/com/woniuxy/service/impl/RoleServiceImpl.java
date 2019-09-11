package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.RoleMapper;
import com.woniuxy.domain.Role;
import com.woniuxy.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired  
	private RoleMapper mapper;
	@Override
	public void save(Role record) {
		mapper.insert(record);
	}
	@Override
	public void delete(Role record) {
		mapper.deleteByPrimaryKey(record.getRid());
	}
	@Override
	public void update(Role record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public List<Role> find() {
		return mapper.selectByExample(null);
	}
	@Override
	public Role findOne(Role record) {
		return mapper.selectByPrimaryKey(record.getRid());
	}
}
