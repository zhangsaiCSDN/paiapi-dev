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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Deposit;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IDepositService;

@Controller
@RequestMapping("deposits")
public class DepositController {
	
	@Autowired
	public IDepositService service;
	
	@GetMapping
	@ResponseBody
	public Page<Deposit> find(Integer p){
		if(p==null)p=1;
		int count=service.count();
		Page<Deposit> page=new Page<>(p,count,5);
		List<Deposit> list=service.find(page);
		page.setList(list);
		return page;
	}
	
	@GetMapping(value ="/{did}")
	@ResponseBody
	public Deposit findOne(@PathVariable Integer did) {
		return service.findOne(did);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer did) {
		service.delete(did);
	} 
	
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Deposit deposit) {
		service.update(deposit);
	};
	
	@PostMapping
	@ResponseBody
	public void save(Deposit deposit) {
		service.save(deposit);
	}
}
