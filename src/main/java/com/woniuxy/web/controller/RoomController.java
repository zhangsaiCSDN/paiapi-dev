package com.woniuxy.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.woniuxy.domain.Page;
import com.woniuxy.domain.Room;
import com.woniuxy.service.IDepositService;
import com.woniuxy.service.IRoomService;

@Controller
@RequestMapping("rooms")
public class RoomController {
		
	@Autowired
	private IRoomService roomService;
	
	@Autowired
	private IDepositService depositService;
		
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
	
	@GetMapping("search")
	@ResponseBody
	public Map<String,Object> search(HttpSession session,Integer gid){
		Map<String,Object> map=new HashMap<>();
		Map<String,Object> map2=new HashMap<>();
		Integer uid=null;
		String oldUid=(String)session.getAttribute("uid");
		if(oldUid!=null) {
			uid=Integer.parseInt(oldUid);
			map2.put("gid", gid);
			map2.put("uid", uid);
			if(depositService.search(map2).size()!=0) {
				map.put("status", 200);
			}else {
				map.put("status",500);
				map.put("message", "请去个人中心缴纳保证金");
			}
			
		}else {
			map.put("status", 500);
			map.put("message", "请先登录");
		}
		return map;
	}
}


