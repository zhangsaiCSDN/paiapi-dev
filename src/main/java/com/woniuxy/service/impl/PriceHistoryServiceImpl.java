package com.woniuxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.PricehistoryMapper;
import com.woniuxy.domain.Page;
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
	public Page<Pricehistory> find(Map<String , Object> map) {
		
		//获取前端传来的当前页，每页行数，查出当前查询条件的总行数
		int rc = phmapper.findCount(map);
		Integer p = Integer.parseInt(map.get("p").toString()) ;
		Integer size = Integer.parseInt( map.get("size").toString()) ;
		
		//封装成page放入查询条件map中查询
		Page<Pricehistory> page = new Page<>(p,rc,size);
		map.put("page", page);
		
		//将查询的结果再放到page对象中，返回页面
		List<Pricehistory> list = phmapper.find(map);
		page.setList(list);
		
		return page;
	}

}
