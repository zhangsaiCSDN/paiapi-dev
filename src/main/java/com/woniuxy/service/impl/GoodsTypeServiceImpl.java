package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.AnnounceMapper;
import com.woniuxy.dao.GoodstypeMapper;
import com.woniuxy.domain.Goodstype;
import com.woniuxy.service.IGoodsTypeService;


@Service
@Transactional
public class GoodsTypeServiceImpl implements IGoodsTypeService {

	@Autowired
	private GoodstypeMapper mapper;
	
	@Override
	public void save(Goodstype goodstype) {
		mapper.insert(goodstype);
	}

	@Override
	public void delete(Integer gtid) {
		mapper.deleteByPrimaryKey(gtid);
	}

	@Override
	public void update(Goodstype goodstype) {
		mapper.updateByPrimaryKey(goodstype);
	}

	@Override
	public Goodstype findOne(Integer gtid) {
		return mapper.selectByPrimaryKey(gtid);
	}

	@Override
	public List<Goodstype> find() {
		return mapper.selectByExample(null);
	}

}
