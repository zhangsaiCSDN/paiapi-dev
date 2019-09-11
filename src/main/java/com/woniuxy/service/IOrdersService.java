package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Orders;

public interface IOrdersService {

	void save(Orders orders);
	void delete(Integer odid);
	void update(Orders orders);
	Orders findOne(Integer odid);
	List<Orders> find();
	
}
