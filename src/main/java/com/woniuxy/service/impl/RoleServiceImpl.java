package com.woniuxy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.RoleMapper;
import com.woniuxy.domain.Permission;
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
		Role roleDB = mapper.findRoleByRname(record.getRname());
		Map<String,Integer> map = new HashMap<>();
		map.put("rid", roleDB.getRid());
		Set<Permission> pms = record.getPermissions();
		for (Permission p : pms) {
			map.put("pmsid", p.getPmsid());
			mapper.insertRolePermission(map);
		}
	}

	@Override
	public void delete(Integer rid) {
		mapper.deleteByPrimaryKey(rid);
		Map<String, Integer> map = new HashMap<>();
		map.put("rid", rid);
		mapper.deleteRolePermission(map);
	}

	@Override
	public void update(Role record) {
		Integer rid = record.getRid();
		Set<Permission> permissions = record.getPermissions();
		//用rid删除旧的关系表对应关系
		Map<String, Integer> map = new HashMap<>();
		map.put("rid", rid);
		mapper.deleteRolePermission(map);
		
		//添加新的关系
		for (Permission p : permissions) {
			map.put("pmsid", p.getPmsid());
			mapper.insertRolePermission(map);
		}
		
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
		return mapper.findInfoByRid(rid);
	}

	public List<Role> findInfo() {
		// TODO Auto-generated method stub
		return mapper.findInfo();
	}


}
