package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Page;
import com.woniuxy.domain.Room;
  
public interface IRoomService {

	void save(Room room);
	void delete(Integer rmid);
	void update(Room room);
	Room findOne(Integer rmid);
	List<Room> find();
	List<Room> findByPage(Page<Room> page);
	long count();
	List<Room> findByState(Integer uid);
}
