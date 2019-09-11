package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.AddressMapper;
import com.woniuxy.domain.Address;
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
	public List<Address> find() {
		return mapper.selectByExample(null);
	}

}
