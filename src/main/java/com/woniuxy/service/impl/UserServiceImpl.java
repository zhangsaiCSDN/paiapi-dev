package com.woniuxy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.RoleMapper;
import com.woniuxy.dao.UserMapper;
import com.woniuxy.domain.Role;
import com.woniuxy.domain.User;
import com.woniuxy.domain.UserExample;
import com.woniuxy.service.IUserService;
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper mapper;
	
	
	@Override
	public void save(User user) {
		mapper.insert(user);
		User userDB = mapper.findUserByUname(user.getUname());
		Set<Role> roles = user.getRoles(); 
		Map<String, Integer> map = new HashMap<>();	
		map.put("uid", userDB.getUid());
		for (Role role : roles) {
			map.put("rid", role.getRid());
			mapper.insertUserRole(map);
		}
	}
 
	@Override
	public void delete(Integer uid) {
		User userdb = mapper.selectByPrimaryKey(uid);
		mapper.deleteByPrimaryKey(uid);
		Map<String,Integer> map = new HashMap<>();
		map.put("uid", userdb.getUid());
		mapper.deleteUserRole(map);
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

	@Override
	public List<User> findInfo() {
		return mapper.findInfo();
	}
	
	public User findUserByUname(String uname) {
		
		return mapper.findUserByUname(uname);
	}

}
