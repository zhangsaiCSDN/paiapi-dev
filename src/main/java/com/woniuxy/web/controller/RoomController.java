package com.woniuxy.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Deposit;
import com.woniuxy.domain.Page;
import com.woniuxy.domain.Room;
import com.woniuxy.service.IRoomService;

@Controller
@RequestMapping("rooms")
public class RoomController {
		
	@Autowired
	private IRoomService roomService;
		
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Room room) {
		roomService.save(room);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer rmid) {
		roomService.delete(rmid);
	}
		
	@PutMapping
	@ResponseBody
	public void update(Room room) {
		roomService.update(room);
	}
		
		
	@GetMapping(value = "/{rmid}")
	@ResponseBody
	public Room findOne(@PathVariable Integer rmid){
		return roomService.findOne(rmid);
	}
		
	@GetMapping("/state")
	@ResponseBody
	public List<Room> findbyState(Integer uid,HttpServletResponse response) {
		return roomService.findByState(uid);
	}
	@GetMapping
	@ResponseBody
	public Page<Room> findByPage(Integer p){
		System.out.println("RoomController.findByPage()");
		if(p==null)p=1;
		int count=(int) roomService.count();
		Page<Room> page=new Page<>(p,count,8);
		List<Room> list=roomService.findByPage(page);
		page.setList(list);
		return page;
	}
}


