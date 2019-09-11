package com.woniuxy.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.service.ICardService;

@Controller
@RequestMapping("usertests")
public class UserTestController {
	
	@Autowired
	private ICardService service;
	
	@GetMapping
	@ResponseBody
	public String save() {
		return "test";
	}
	
}
