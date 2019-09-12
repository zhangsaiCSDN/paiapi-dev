package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.domain.Announce;
import com.woniuxy.service.IAnnounceService;

@Service
@Transactional
public class AnnounceService implements IAnnounceService {

	@Override
	public void save(Announce announce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer anid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Announce announce) {
		// TODO Auto-generated method stub

	}

	@Override
	public Announce findOne(Integer anid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Announce> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
