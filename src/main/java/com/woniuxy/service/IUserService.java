package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.User;

public interface IUserService {
	
	void save(User user);
	void delete(Integer uid);
	void update(User user);
	User findOne(Integer uid);
	List<User> find();
	
 
}
