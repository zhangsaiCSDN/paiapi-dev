package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.RoomMapper;
import com.woniuxy.domain.Page;
import com.woniuxy.domain.Room;
import com.woniuxy.service.IRoomService;
  
@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomMapper mapper;

	@Override
	public void save(Room room) {

		mapper.insert(room);
	}

	@Override
	public void delete(Integer rmid) {

		mapper.deleteByPrimaryKey(rmid);
	}

	@Override
	public void update(Room room) {

		mapper.updateByPrimaryKey(room);
	}

	@Override
	public Room findOne(Integer rmid) {

		return mapper.selectByPrimaryKey(rmid);
	}

	@Override
	public List<Room> find() {

		return mapper.selectByExample(null);
	}

	@Override
	public List<Room> findByPage(Page<Room> page) {
		// TODO Auto-generated method stub
		return mapper.findByPage(page);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return mapper.countByExample(null);
	}

	@Override
	public List<Room> findByState(Integer uid) {
		// TODO Auto-generated method stub
		return mapper.findByState(uid);
	}

}
