package com.woniuxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.GoodsMapper;
import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IGoodsService;

@Service 
@Transactional
public class GoodsServiceImpl implements IGoodsService {
	
	@Autowired
	public GoodsMapper dao;

	@Override
	public void save(Goods goods) {
		dao.insert(goods);
	}

	@Override
	public void delete(Integer gid) {
		dao.deleteByPrimaryKey(gid);
	}

	@Override
	public void update(Goods goods) {
		dao.updateByPrimaryKey(goods);
			
	}

	@Override
	public List<Goods> find(Page<Goods> page) {
		return dao.find(page);
	}

	@Override
	public Goods findOne(Integer gid) {
		return dao.selectByPrimaryKey(gid);
	}

	//查询goods 一对多Img
	@Override
	public List<Goods> findByImages() {
		return dao.findByImages();
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return  (int) dao.countByExample(null);
	}
	
	//原生查询
	@Override
	public List<Goods> find() {
		return dao.findAll();
	}

	@Override
	public List<Goods> find(Map<String, Object> map) {
		return dao.findCount(map);
	}


}
