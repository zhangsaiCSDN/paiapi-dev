package com.woniuxy.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	//后端查询
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
	
	//前端根据uid查询orders
	@GetMapping("findByUid")
	@ResponseBody
	public Page<Orders> findByUid(Integer p,Integer uid){
		//测试参数uid 接口留着接参数
//		int uid =562;
//		int uid =1;

		Map map = new HashMap<String,Object>();
		map.put("uid", uid);
		Integer rc = service.findCount(map); //根据条件查到rc
		
		if(p==null)p=1;
		int count=service.count();
		
		Page<Orders> page=new Page<>(p,rc,5);
		List<Orders> list=service.find(page);
		
		map.put("page", page);
		List find = service.find(map);
		page.setList(find);

		page.setRowCount(1); //总页数
		
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
		return service.findOne(odid);
	}
	//前端显示查一个  //@GetMapping(value = "/{odid}") @PathVariable接参数与HttpServletResponse resp有冲突
	@GetMapping("order") 
	@ResponseBody
	public Orders findOneGG(Integer odid) {
		return service.findOne(odid);
	}
	
	
}
