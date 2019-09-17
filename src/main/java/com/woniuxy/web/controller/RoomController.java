package com.woniuxy.web.controller;

import java.util.List;

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
		
	@GetMapping
	@ResponseBody
	public List<Room> find() {
		System.out.println("RoomController.LogController.find()");
		return roomService.find();
	}
}


