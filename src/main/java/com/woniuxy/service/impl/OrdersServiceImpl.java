package com.woniuxy.service.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<Orders> find() {
		// TODO Auto-generated method stub
		return mapper.selectByExample(null);
	}
	
	//前端查询
	@Override
	public List<Orders> find(Map<String, Object> map) {		
		Integer rowCount = mapper.findCount(map);//查出uid的order数量
		Page page = (Page) map.get("page");
		page.setRowCount(rowCount); //将数量存入
		
		map.put("page", page); //cho
		List<Orders> list = mapper.findByUid(map);  //map中封装了 page 和uid
		return list;
	}

	@Override
	public Integer findCount(Map<String, Object> map) {
		Integer findCount = mapper.findCount(map);
		return findCount;
	}
	
	@Override
	public Integer findCountById(Map<String, Object> map) {
		Integer findCount = mapper.findCountById(map);
		return findCount;
	}

	@Override
	public List<Orders> findByBuyerid(Map<String, Object> map) {
		Integer rowCount = mapper.findCount(map);//查出buyerid的order数量
		Page page = (Page) map.get("page");
		page.setRowCount(rowCount); //将数量存入
		
		map.put("page", page); //cho
		List<Orders> list = mapper.findByBuyerid(map);  //map中封装了 page 和buyerid
		return list;
	}




}
