package com.woniuxy.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IAddressService;
import com.woniuxy.service.impl.UserServiceImpl;

@Controller
@RequestMapping("addresses")
public class AddressController {

	@Autowired
	private IAddressService service;
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Address address,HttpSession session) {
		Integer uid=Integer.parseInt((String)session.getAttribute("uid"));
		address.setUid(uid);
		address.setUser(userService.findOne(uid));
		service.save(address);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer aid) {
		service.delete(aid);
	}
	
//	前台删除
	@PostMapping("delete")
	@ResponseBody
	public void del(Integer aid) {
		System.out.println(aid+"------------------------");
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
	
	@GetMapping("findByUid")
	@ResponseBody
	public Page<Address> findByUid(Integer uid,Integer p) {
		Map map = new HashMap<String,Object>();
		map.put("uid", uid);
		Integer rc = service.findCount(map); //根据条件查到rc
		
		if(p==null)p=1;
		int count=service.count();
		
		Page<Address> page=new Page<>(p,rc,5);
		List<Address> list=service.find(page);
		map.put("page", page);
		List find = service.find(map);
		page.setList(find);

		page.setRowCount(1); //总页数
		
		return page;
	}
}
