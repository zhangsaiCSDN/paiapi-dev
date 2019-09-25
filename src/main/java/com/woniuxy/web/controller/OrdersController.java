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

import com.woniuxy.domain.Deposit;
import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;
import com.woniuxy.domain.User;
import com.woniuxy.service.IOrdersService;
import com.woniuxy.service.impl.OrdersServiceImpl;

@Controller
@RequestMapping("orders")
public class OrdersController {
	
	@Autowired
	private IOrdersService service;
	
	
	@ResponseBody
	@PostMapping
	public void save (@RequestBody Orders orders) {
		service.save(orders);
	}
	
	@ResponseBody
	@DeleteMapping
	public void delete(Integer odid) {
		service.delete(odid);
	}
	
	
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Orders orders) {
		service.update(orders);
	}
	
	@GetMapping
	@ResponseBody
	public Page<Orders> find(Integer p){
		if(p==null)p=1;
		int count=service.count();
		Page<Orders> page=new Page<>(p,count,5);
		List<Orders> list=service.find(page);
		page.setList(list);
		return page;
	}
	//查询orders
	@GetMapping("findAll")
	@ResponseBody
	public List<Orders> find(){
		List<Orders> list=service.find();
		return list;
	}
	
	@GetMapping(value = "/{odid}")
	@ResponseBody
	public Orders findOne(@PathVariable Integer odid) {
		System.out.println("findOne------"+odid);
		return service.findOne(odid);
	}
	
	
}
