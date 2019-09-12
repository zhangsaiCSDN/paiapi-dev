package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.GoodsMapper;
import com.woniuxy.domain.Goods;
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
	public List<Goods> find() {
		return dao.selectByExample(null);
	}

	@Override
	public Goods findOne(Integer gid) {
		return dao.selectByPrimaryKey(gid);
	}

}
