package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.PricehistoryMapper;
import com.woniuxy.domain.Pricehistory;
import com.woniuxy.service.IPriceHistoryService;


@Service
@Transactional
public class PriceHistoryServiceImpl implements IPriceHistoryService {
	
	@Autowired
	private PricehistoryMapper phmapper;

	@Override
	public void save(Pricehistory ph) {
		// TODO Auto-generated method stub
		phmapper.insert(ph);
		
	}

	@Override
	public void update(Pricehistory ph) {
		// TODO Auto-generated method stub
		phmapper.updateByPrimaryKey(ph);
		
	}

	@Override
	public void delete(Integer phid) {
		// TODO Auto-generated method stub
		phmapper.deleteByPrimaryKey(phid);
	}

	@Override
	public Pricehistory findOne(Integer phid) {
		// TODO Auto-generated method stub
		return phmapper.selectByPrimaryKey(phid);
	}

	@Override
	public List<Pricehistory> find(Pricehistory ph) {
		// TODO Auto-generated method stub
		return phmapper.find(ph);
	}

}
