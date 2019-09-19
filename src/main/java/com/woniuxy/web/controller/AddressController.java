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

import com.woniuxy.domain.Address;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IAddressService;

@Controller
@RequestMapping("addresses")
public class AddressController {

	@Autowired
	private IAddressService service;
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Address address) {
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
	
	@GetMapping(value="/{aid}")
	@ResponseBody
	public Address findOne(@PathVariable Integer aid) {
		return service.findOne(aid);
	}
	
	@GetMapping
	@ResponseBody
	public Page<Address> find(Integer p){
		if(p==null) {
			p=1;
		}
		int count = service.count();
		Page<Address> page=new Page<Address>(p, count, 5);
		List<Address> list = service.find(page);
		page.setList(list);
 		return page;
	}
}
