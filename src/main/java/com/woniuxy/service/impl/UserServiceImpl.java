package com.woniuxy.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.woniuxy.dao.RoleMapper;
import com.woniuxy.dao.UserMapper;
import com.woniuxy.domain.Permission;
import com.woniuxy.domain.Role;
import com.woniuxy.domain.RoleExample;
import com.woniuxy.domain.User;
import com.woniuxy.domain.UserExample;
import com.woniuxy.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private RoleMapper roleMapper;

	// 用户注册
	@Override
	public void save(User user) {

		if (user.getRegtime() == null) {
			user.setRegtime(new Date());
		}
		mapper.insert(user);
		User userDB = mapper.findUserByUname(user.getUname());
		Set<Role> roles = user.getRoles();
		Map<String, Integer> map = new HashMap<>();
		map.put("uid", userDB.getUid());

		if (roles != null) {
			for (Role role : roles) {
				map.put("rid", role.getRid());
				mapper.insertUserRole(map);
			}
		} else {
			Role role = roleMapper.findRoleByRname("买家");
			if (role != null) {
				map.put("rid", role.getRid());
				mapper.insertUserRole(map);
			}
		}

	}

	@Override
	public void delete(Integer uid) {
		User userdb = mapper.selectByPrimaryKey(uid);
		mapper.deleteByPrimaryKey(uid);
		Map<String, Integer> map = new HashMap<>();
		map.put("uid", userdb.getUid());
		mapper.deleteUserRole(map);
	}

	@Override
	public void update(User user) {

		Integer rid = user.getUid();
		Set<Role> roles = user.getRoles();
		// 用rid删除旧的关系表对应关系
		Map<String, Integer> map = new HashMap<>();
		map.put("uid", rid);
		mapper.deleteUserRole(map);
		// 添加新的关系
		for (Role r : roles) {
			map.put("rid", r.getRid());
			mapper.insertUserRole(map);
		}

		mapper.updateByPrimaryKeySelective(user);

	}

	@Override
	public User findOne(Integer uid) {

		return mapper.findInfoById(uid);
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
