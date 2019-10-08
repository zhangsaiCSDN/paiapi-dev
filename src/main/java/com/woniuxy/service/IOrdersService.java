package com.woniuxy.service;

import java.util.List;
import java.util.Map;

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
	List<Orders> find(Map<String , Object> map); //前端查询 Map中封装 uid 和 page
	List<Orders> findByBuyerid(Map<String , Object> map); //前端查询 Map中封装 buyerid 和 page
	Integer findCount(Map<String , Object> map); //前端根据uid 查询数量
}
