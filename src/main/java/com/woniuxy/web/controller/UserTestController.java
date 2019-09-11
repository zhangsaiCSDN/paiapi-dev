package com.woniuxy.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Userstest;
import com.woniuxy.service.IUserTestService;

@Controller
@RequestMapping("usertests")
public class UserTestController {
	
	@Autowired
	private IUserTestService service;
	
	@GetMapping
	@ResponseBody
	public String save() {
		Userstest u2 = new Userstest();
		u2.setBirthday(new Date());
		u2.setMoney(999d);
		u2.setName("Kingmoon");
		service.save(u2);
		System.out.println("success");
		return "test";
	}
	
}
