package com.woniuxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.GoodshistoryMapper;
import com.woniuxy.domain.Goodshistory;
import com.woniuxy.domain.Page;
import com.woniuxy.domain.Pricehistory;
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
	public Page<Goodshistory> find(Map<String , Object> map) {
		//获取前端传来的当前页，每页行数，查出当前查询条件的总行数
		int rc = ghmapper.findCount(map);
		Integer p = Integer.parseInt(map.get("p").toString()) ;
		Integer size = Integer.parseInt( map.get("size").toString()) ;
		
		//封装成page放入查询条件map中查询
		Page<Goodshistory> page = new Page<>(p,rc,size);
		map.put("page", page);
		map.put("minmoney",map.get("minmoney")==""?null:map.get("minmoney"));
		map.put("maxmoney",map.get("maxmoney")==""?null:map.get("maxmoney"));
		
		//将查询的结果再放到page对象中，返回页面
		List<Goodshistory> list = ghmapper.find(map);
		page.setList(list);
		
		return page;
	}
	
	@Override
	public Page<Goodshistory> findByBuyerid(Map<String, Object> map) {
		//获取前端传来的当前页，每页行数，查出当前查询条件的总行数
				int rc = ghmapper.rowCount(map);
				Integer p = Integer.parseInt(map.get("p").toString()) ;
				Integer size = Integer.parseInt( map.get("size").toString()) ;
				Integer buyerid = Integer.parseInt( map.get("buyerid").toString()) ;
				
				//封装成page放入查询条件map中查询
				Page<Goodshistory> page = new Page<>(p,rc,size);
				map.put("page", page);
				map.put("buyerid", buyerid);
				
				//将查询的结果再放到page对象中，返回页面
				List<Goodshistory> list = ghmapper.findByBuyerid(map);
				page.setList(list);
				
				return page;
	}


}
