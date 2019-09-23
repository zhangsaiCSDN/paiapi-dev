package com.woniuxy.web.controller;

import java.util.Map;
import java.util.Set;

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

import com.woniuxy.domain.Page;
import com.woniuxy.domain.Pricehistory;
import com.woniuxy.service.IPriceHistoryService;

@Controller
@RequestMapping("phistorys")
public class PHTestController {
	@Autowired
	private IPriceHistoryService service;
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Pricehistory ph) {
		service.save(ph);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer phid) {
		service.delete(phid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Pricehistory ph) {
		service.update(ph);
	}
	
	@GetMapping
	@ResponseBody
	public Page<Pricehistory> find(@RequestParam Map<String,Object> map){
		
		if(map.get("p")==null ) {
			map.put("p", 1);
		}
		
		if(map.get("size")==null) {
			map.put("size", 10);
		}
		
		Page<Pricehistory> page = service.find(map);
		return page;
	}
	
}
