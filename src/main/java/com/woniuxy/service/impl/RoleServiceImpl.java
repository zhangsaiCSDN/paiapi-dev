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
		// TODO Auto-generated method stub
		mapper.insert(record);
	}

	@Override
	public void delete(Integer rid) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(rid);
	}

	@Override
	public void update(Role record) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Role> find() {
		// TODO Auto-generated method stub
		return mapper.selectByExample(null);
	}

	@Override
	public Role findOne(Integer rid) {
		// TODO Auto-generated method stub
		
		return mapper.selectByPrimaryKey(rid);
	}

}
