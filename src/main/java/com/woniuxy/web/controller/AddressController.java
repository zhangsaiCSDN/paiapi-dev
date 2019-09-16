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

import com.woniuxy.domain.Address;
import com.woniuxy.service.IAddressService;

@Controller
@RequestMapping("addresses")
public class AddressController {

	@Autowired
	private IAddressService service;
	
	@PostMapping
	@ResponseBody
	public void save(Address address) {
		service.save(address);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer aid) {
		service.delete(aid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(Address address) {
		service.update(address);
	}
	
	@GetMapping(value="/aid")
	@ResponseBody
	public Address findOne(Integer aid) {
		return service.findOne(aid);
	}
	
	@GetMapping
	@ResponseBody
	public List<Address> find(){
		return service.find();
	}
}
