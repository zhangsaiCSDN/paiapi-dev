package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Permission;

public interface IPermissionService {
	void save(Permission p);
	void delete(Integer pmsid);
	void update(Permission p);
	Permission findOne(Integer pmsid);
	List<Permission> find();
}
