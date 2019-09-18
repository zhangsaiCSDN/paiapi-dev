package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Announce;
import com.woniuxy.domain.Goods;
import com.woniuxy.service.IAnnounceService;

@Controller
@RequestMapping("announces")
public class AnnounceController {
	@Autowired
	private IAnnounceService service;
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Announce announce) {
		System.out.println(announce);
		service.save(announce);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer anid) {
		service.delete(anid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Announce announce) {
		System.out.println(announce);
		service.update(announce);
	}
	
	@GetMapping(value="/{anid}")
	@ResponseBody
	public Announce findOne(Integer anid) {
		return service.findOne(anid);
	}
	
	
	@GetMapping
	@ResponseBody
	public List<Announce> find(){
		return service.find();
	}
	
}
