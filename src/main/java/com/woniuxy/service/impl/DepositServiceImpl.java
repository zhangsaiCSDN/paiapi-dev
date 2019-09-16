package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.DepositMapper;
import com.woniuxy.domain.Deposit;
import com.woniuxy.service.IDepositService;
  
@Service
@Transactional
public class DepositServiceImpl implements IDepositService {

	@Autowired
	private DepositMapper mapper;
	@Override
	public void save(Deposit ds) {
		mapper.insert(ds);
		
	}

	@Override
	public void delete(Integer did) {

		mapper.deleteByPrimaryKey(did);
	}

	@Override
	public void update(Deposit ds) {

		mapper.updateByPrimaryKeySelective(ds);
	}

	@Override
	public Deposit findOne(Integer did) {

		return mapper.selectByPrimaryKey(did);
	}

	@Override
	public List<Deposit> find() {

		return mapper.selectByExample(null);
	}

}
