package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.ApplyMapper;
import com.woniuxy.domain.Apply;
import com.woniuxy.service.IApplyService;


@Service
@Transactional
public class ApplyServiceImpl implements IApplyService {
	
	@Autowired
	private ApplyMapper mapper;

	@Override
	public void save(Apply apply) {
		mapper.insert(apply);
		
	}

	@Override
	public void delete(Integer apid) {
		mapper.deleteByPrimaryKey(apid);
		
	}

	@Override
	public void update(Apply apply) {
		mapper.updateByPrimaryKey(apply);
		
	}

	@Override
	public Apply findOne(Integer apid) {
		Apply apply = mapper.selectByPrimaryKey(apid);
		return apply;
	}

	@Override
	public List<Apply> find() {
		List<Apply> list = mapper.selectByExample(null);
		
		return list;
	}

}
