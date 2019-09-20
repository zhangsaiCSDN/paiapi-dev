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

import com.woniuxy.domain.Permission;
import com.woniuxy.service.impl.PermissionServiceImpl;

@Controller
@RequestMapping("permissions")
public class PermissionController {

	@Autowired
	private PermissionServiceImpl service;

	@PostMapping
	@ResponseBody
	public void save(@RequestBody Permission permission) {
		service.save(permission);
	}

	@DeleteMapping
	@ResponseBody
	public void delete(Integer pmsid) {
		service.delete(pmsid);
	}

	@PutMapping
	@ResponseBody
	public void update(Permission permission) {
		service.update(permission);
	}

	@GetMapping(value = "/{pmsid}")
	@ResponseBody
	public Permission findOne(@PathVariable Integer pmsid) {
		return service.findOne(pmsid); 
	}

	@GetMapping
	@ResponseBody
	public List<Permission> find() {
		return service.find();
	}

}
