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
import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IGoodsService;
import com.woniuxy.service.impl.GoodsServiceImpl;

@Controller
@RequestMapping("goods")
public class GoodsController {
	
	@Autowired
	private IGoodsService service;
	
	//查询所有拍品
	@GetMapping
	@ResponseBody
	public Page<Goods> find(Integer p) {
		if(p==null)p=1;
		int count=service.count();
		Page<Goods> page=new Page<>(p,count,5);
		List<Goods> list=service.find(page);
		for (Goods goods : list) {
			System.out.println(goods);
		}
		page.setList(list);
		return page;
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
