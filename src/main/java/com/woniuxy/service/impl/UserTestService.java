package com.woniuxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.UserstestMapper;
import com.woniuxy.domain.Userstest;
import com.woniuxy.service.IUserTestService;

@Service
@Transactional
public class UserTestService implements IUserTestService  {

	@Autowired
	private UserstestMapper mapper;
	

	@Override
	public void save(Userstest user) {
		// TODO Auto-generated method stub
		mapper.insert(user);
	}

}