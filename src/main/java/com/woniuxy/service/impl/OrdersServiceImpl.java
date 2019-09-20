package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.OrdersMapper;
import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IOrdersService;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

	@Autowired
	private OrdersMapper mapper;
	
	@Override
	public void save(Orders orders) {
		mapper.insert(orders);
	}

	@Override
	public void delete(Integer odid) {
		mapper.deleteByPrimaryKey(odid);
	}

	@Override
	public void update(Orders orders) {
		mapper.updateByPrimaryKey(orders);
	}

	@Override
	public Orders findOne(Integer odid) {
		return mapper.selectByPrimaryKey(odid);
	}


	@Override
	public List<Orders> find(Page<Orders> page) {
		return mapper.find(page);
	}

	@Override
	public Integer count() {
		return (int) mapper.countByExample(null);
	}

}
