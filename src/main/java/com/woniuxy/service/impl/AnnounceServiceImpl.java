package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.AnnounceMapper;
import com.woniuxy.domain.Announce;
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
	public List<Announce> find() {	
		return mapper.selectByExample(null);
	}

}
