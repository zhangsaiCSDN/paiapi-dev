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

import com.woniuxy.domain.Pricehistory;
import com.woniuxy.service.IPriceHistoryService;

@Controller
@RequestMapping("phistorys")
public class PHTestController {
	@Autowired
	private IPriceHistoryService service;
	
	@PostMapping
	@ResponseBody
	public void save(Pricehistory ph) {
		service.save(ph);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer phid) {
		service.delete(phid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(Pricehistory ph) {
		service.update(ph);
	}
	
	@GetMapping
	@ResponseBody
	public List<Pricehistory> find(Pricehistory ph){
		System.out.println(ph);
		List<Pricehistory> list = service.find(ph);
	
		for (Pricehistory p : list) {
			System.out.println(p);
		}
		return list;
	}
	
}
