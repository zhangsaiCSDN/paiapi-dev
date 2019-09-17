package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Goodshistory;
import com.woniuxy.service.IGoodsHistoryService;

//拍品历史记录表

@Controller
@RequestMapping("ghistorys")
public class GHTestController {

	@Autowired
	private IGoodsHistoryService service; 
	
	@PostMapping
	@ResponseBody
	public void save(Goodshistory gh) {
		service.save(gh);
	}
	
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer ghid) {
		service.delete(ghid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(Goodshistory gh) {
		System.out.println("GHTestController.update()");
		System.out.println(gh);
		service.update(gh);;
	}
	
	
	@GetMapping
	@ResponseBody
	public List<Goodshistory> find() {
		return service.find();
	}
}
