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

import com.woniuxy.domain.Apply;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IApplyService;


@Controller
@RequestMapping("applys")
public class ApplyController {

	@Autowired
	private IApplyService service;

	@GetMapping
	@ResponseBody
	public List<Apply> find(){
		return service.find();
		
	}

	@GetMapping(value = "/{apid}")
	@ResponseBody
	public Apply findOne(@PathVariable Integer apid) {

		return service.findOne(apid);
	}

	@DeleteMapping
	@ResponseBody
	public void delete(Integer apid) {

		service.delete(apid);

	} 
	@PutMapping
	@ResponseBody
	public void update(Apply apply) {
		System.out.println("ApplyController.update()");
		
		service.update(apply);
	}

	@PostMapping
	@ResponseBody
	public void save(@RequestBody Apply apply) {
		service.save(apply);
	}
}
