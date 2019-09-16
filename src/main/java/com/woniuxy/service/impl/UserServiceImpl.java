package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.UserMapper;
import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public void save(User user) {
		mapper.insert(user);
	}
 
	@Override
	public void delete(Integer uid) {
		mapper.deleteByPrimaryKey(uid);
	}

	@Override
	public void update(User user) {
		mapper.updateByPrimaryKey(user);
	}

	@Override
	public User findOne(Integer uid) {
		
		return mapper.selectByPrimaryKey(uid);
	}

	@Override
	public List<User> find() {
		return mapper.selectByExample(null);
	}

}
