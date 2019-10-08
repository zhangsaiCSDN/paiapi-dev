package com.woniuxy.service;

import java.util.List;
import java.util.Map;

import com.woniuxy.domain.Address;
import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;

public interface IAddressService {

	void save(Address address);
	void delete(Integer aid);
	void update(Address address);
	Address findOne(Integer aid);
	List<Address> find(Page<Address> page);
	Integer count();
	List<Address> find(Map<String , Object> map); //前端查询 Map中封装 uid 和 page
	Integer findCount(Map<String , Object> map); //前端根据uid 查询数量
}
