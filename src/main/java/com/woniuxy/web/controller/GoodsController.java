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

import com.woniuxy.domain.Goods;
import com.woniuxy.service.impl.GoodsServiceImpl;

@Controller
@RequestMapping("goods")
public class GoodsController {
	
	@Autowired
	private GoodsServiceImpl service;
	
	//查询所有拍品
	@GetMapping
	@ResponseBody
	public List<Goods> find() {
		List<Goods> list = service.find();
		return list;
	}
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Goods goods) {
		service.save(goods);
	}
	@DeleteMapping
	@ResponseBody 
	public void delete(Integer gid) {
		service.delete(gid);
	}
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Goods goods) {
		service.update(goods); 
	}
}
