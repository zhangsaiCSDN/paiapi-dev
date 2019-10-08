package com.woniuxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.CollectMapper;
import com.woniuxy.domain.Collect;
import com.woniuxy.domain.Deposit;
import com.woniuxy.domain.Page;
import com.woniuxy.service.ICollectService;

@Service
@Transactional
public class CollectServiceImpl implements ICollectService {

	@Autowired
	private CollectMapper mapper;

	@Override
	public void save(Collect collect) {

		mapper.insert(collect);

	}

	@Override
	public void delete(Integer clid) {
		mapper.deleteByPrimaryKey(clid);
	}

	@Override
	public void update(Collect collect) {
		mapper.updateByPrimaryKey(collect);
	}

	@Override
	public Collect findOne(Integer clid) {
		Collect collect = mapper.selectByPrimaryKey(clid);
		return collect;
	}

	@Override
	public List<Collect> find(Page<Collect> page) {
		
		
		    return mapper.findAll(page);
		
		
		
	}

	@Override
	public Integer count() {
		return  (int) mapper.countByExample(null);
	}

	@Override
	public List<Collect> findAll() {
		
		List<Collect> list = mapper.selectByExample(null);
		
		return list;
	}

	@Override
	public List<Collect> find(Map<String, Object> map) {
		
		Integer rouCount = mapper.findCount(map);
		Page page =(Page) map.get("page");
		
		page.setRowCount(rouCount);
		
		map.put("page",page);
		List<Collect> list = mapper.findByUid(map);
		
		
		return list;
	}

	@Override
	public Integer findCount(Map<String, Object> map) {
		
		Integer findCount = mapper.findCount(map);
		return findCount;
	}





		
		

}
