package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Role;

public interface IRoleService {
	public void save(Role record);
	public void delete(Integer rid);
	public void update(Role record);
	public List<Role> find(); 
	public Role findOne(Integer rid);
}
