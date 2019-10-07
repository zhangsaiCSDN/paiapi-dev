package com.woniuxy.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Goodshistory;
import com.woniuxy.domain.Page;
import com.woniuxy.domain.Pricehistory;
import com.woniuxy.service.IGoodsHistoryService;

//拍品历史记录表

@Controller
@RequestMapping("ghistorys")
public class GHTestController {

	@Autowired
	private IGoodsHistoryService service; 
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Goodshistory gh) {
		service.save(gh);
	}
	
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer ghid) {
		service.delete(ghid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Goodshistory gh) {
		service.update(gh);;
	}
	
	
	@GetMapping
	@ResponseBody
	public Page<Goodshistory> find(@RequestParam Map<String,Object> map) {

		if(map.get("p")==null ) {
			map.put("p", 1);
		}
		
		if(map.get("size")==null) {
			map.put("size", 5);
		}
	
		Page<Goodshistory> page = service.find(map);
		
		return page;
	}

	@GetMapping("findByUserCenter")
	@ResponseBody
	public Page<Goodshistory> findByUserCenter(@RequestParam Map<String,Object> map) {
		System.out.println(map);
		if(map.get("p")==null ) {
			map.put("p", 1);
		}
		
		if(map.get("size")==null) {
			map.put("size", 5);
		}
	
		Page<Goodshistory> page = service.findByBuyerid(map);
		
		System.out.println(page);
		return page;
	}
}
