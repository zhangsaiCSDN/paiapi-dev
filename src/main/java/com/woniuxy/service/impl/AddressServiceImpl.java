package com.woniuxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.AddressMapper;
import com.woniuxy.domain.Address;
import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IAddressService;


@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressMapper mapper;
	
	@Override
	public void save(Address address) {
		mapper.insert(address);
	}

	@Override
	public void delete(Integer aid) {
		mapper.deleteByPrimaryKey(aid);
	}

	@Override
	public void update(Address address) {
		mapper.updateByPrimaryKey(address);
	}

	@Override
	public Address findOne(Integer aid) {
		return mapper.selectByPrimaryKey(aid);
	}


	@Override
	public List<Address> find(Page<Address> page) {
		return mapper.findAll(page);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return (int) mapper.countByExample(null);
	}
	
	@Override
	public Integer findCount(Map<String, Object> map) {
		Integer findCount = mapper.findCount(map);
		return findCount;
	}

	@Override
	public List<Address> find(Map<String, Object> map) {
		Integer rowCount = mapper.findCount(map);//查出uid的order数量
		Page page = (Page) map.get("page");
		page.setRowCount(rowCount); //将数量存入
		
		map.put("page", page); //cho
		List<Address> list = mapper.findByUid(map);  //map中封装了 page 和uid
		return list;
	}
	
	


}
