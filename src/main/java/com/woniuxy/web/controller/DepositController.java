package com.woniuxy.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Deposit;
import com.woniuxy.service.IDepositService;

@Controller
@RequestMapping("deposits")
public class DepositController {
	
	@Autowired
	public IDepositService service;
	
	@GetMapping
	@ResponseBody
	public List<Deposit> find(){
		return service.find();
	}
	
	@GetMapping(value ="/{did}")
	@ResponseBody
	public Deposit findOne(@PathVariable Integer did) {
		System.out.println("DepositController.findOne()");
		return service.findOne(did);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer did) {
		service.delete(did);
	} 
	
	@PutMapping
	@ResponseBody
	public void update(Deposit deposit) {
		service.update(deposit);
	};
	
	@PostMapping
	@ResponseBody
	public void save(Deposit deposit) {
		System.out.println("DepositController.save()");
		service.save(deposit);
	}
}
