package com.woniuxy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.AnnounceMapper;
import com.woniuxy.domain.Announce;
import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IAnnounceService;

@Service
@Transactional
public class AnnounceServiceImpl implements IAnnounceService {
	@Autowired
	private AnnounceMapper mapper;
	
	@Override
	public void save(Announce announce) {
		mapper.insert(announce);
	}

	@Override
	public void delete(Integer anid) {
		mapper.deleteByPrimaryKey(anid);
	}

	@Override
	public void update(Announce announce) {
		mapper.updateByPrimaryKey(announce);
	}

	@Override
	public Announce findOne(Integer anid) {
		return mapper.selectByPrimaryKey(anid);
	}

	@Override
	public List<Announce> find(Page<Announce> page) {	
		return mapper.findInfo(page);
	}
	
	@Override
	public Integer count() {
		return  (int) mapper.countByExample(null);
	}

	@Override
	public List<Goods> findAllGoods() {
		return mapper.findAllGoods();
	}

	@Override
	public List<Announce> findAll() {
		return mapper.findAll();
	}


}
