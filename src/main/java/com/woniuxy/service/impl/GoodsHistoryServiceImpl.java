package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.GoodshistoryMapper;
import com.woniuxy.domain.Goodshistory;
import com.woniuxy.service.IGoodsHistoryService;


@Service
@Transactional
public class GoodsHistoryServiceImpl implements IGoodsHistoryService {
	
	@Autowired
	private GoodshistoryMapper ghmapper;

	@Override
	public void save(Goodshistory gh) {
		// TODO Auto-generated method stub
		ghmapper.insert(gh);
	}

	@Override
	public void update(Goodshistory gh) {
		// TODO Auto-generated method stub
		ghmapper.updateByPrimaryKey(gh);

	}

	@Override
	public void delete(Integer ghid) {
		// TODO Auto-generated method stub
		ghmapper.deleteByPrimaryKey(ghid);

	}

	@Override
	public Goodshistory findOne(Integer ghid) {
		// TODO Auto-generated method stub
		return ghmapper.selectByPrimaryKey(ghid);
	}

	@Override
	public List<Goodshistory> find() {
		// TODO Auto-generated method stub
		return ghmapper.selectByExample(null);
	}

}
