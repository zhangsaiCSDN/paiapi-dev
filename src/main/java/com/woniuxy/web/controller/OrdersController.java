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

import com.woniuxy.domain.Orders;
import com.woniuxy.service.impl.OrdersServiceImpl;

@Controller
@RequestMapping("orders")
public class OrdersController {
	
	@Autowired
	private OrdersServiceImpl service;
	
	
	@ResponseBody
	@PostMapping
	public void save (Orders orders) {
		System.out.println("OrdersController.save()");
		service.save(orders);
	}
	
	@ResponseBody
	@DeleteMapping
	public void delete(Integer odid) {
		service.delete(odid);
	}
	
	
	@PutMapping
	@ResponseBody
	public void update(Orders orders) {
		service.update(orders);
	}
	
	@GetMapping
	@ResponseBody
	public List<Orders> find(){
		System.out.println(111);
		List<Orders> find = service.find();
		for (Orders orders : find) {
			System.out.println(orders);
		} 
		return find;
	}
	
	
}
