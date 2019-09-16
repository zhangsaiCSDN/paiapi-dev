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

import com.woniuxy.domain.User;
import com.woniuxy.service.impl.UserServiceImpl;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@PostMapping
	@ResponseBody
	public void save(User user) {
		service.save(user);
	}

	@DeleteMapping
	@ResponseBody
	public void delete(Integer uid) {
		service.delete(uid);
	}

	@PutMapping
	@ResponseBody
	public void update(User user) {
		service.update(user);
	}

	@GetMapping(value = "/{uid}")
	@ResponseBody
	public User findOne(@PathVariable Integer uid) {
		return service.findOne(uid);
	}

	@GetMapping
	@ResponseBody
	public List<User> find() {
		return service.find();
	}

}
