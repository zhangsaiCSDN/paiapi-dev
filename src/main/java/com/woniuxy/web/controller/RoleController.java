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

import com.woniuxy.domain.Role;
import com.woniuxy.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("roles")
public class RoleController {

	@Autowired
	private RoleServiceImpl service;

	@PostMapping
	@ResponseBody
	public void save(@RequestBody Role role) {
		service.save(role);
	}

	@DeleteMapping
	@ResponseBody
	public void delete(Integer rid) {
		service.delete(rid);
	}

	@PutMapping
	@ResponseBody
	public void update(@RequestBody Role role) {
		service.update(role);
	}

	@GetMapping(value = "/{rid}")
	@ResponseBody
	public Role find(@PathVariable Integer rid) {
		return service.findOne(rid);
	}

	@GetMapping
	@ResponseBody
	public List<Role> find() {
		return service.find();
	}

}
