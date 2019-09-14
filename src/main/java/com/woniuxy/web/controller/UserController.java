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
	void save(User user) {
		service.save(user);
	}

	@DeleteMapping
	void delete(Integer uid) {
		service.delete(uid);
	}

	@PutMapping
	void update(User user) {
		service.update(user);
	}

	@GetMapping(value = "/{uid}")
	@ResponseBody
	User find(@PathVariable Integer uid) {
		return service.findOne(uid);
	}

	@GetMapping
	@ResponseBody
	List<User> find() {
		return service.find();
	}
}
