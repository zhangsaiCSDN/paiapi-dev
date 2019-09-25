package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;

public interface IOrdersService {

	void save(Orders orders);
	void delete(Integer odid);
	void update(Orders orders);
	Orders findOne(Integer odid);
	List<Orders> find();
	List<Orders> find(Page<Orders> page);
	Integer count();
}
