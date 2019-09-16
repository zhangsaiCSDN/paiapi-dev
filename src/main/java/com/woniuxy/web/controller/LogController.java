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

import com.woniuxy.domain.Log;
import com.woniuxy.service.ILogService;

@Controller
@RequestMapping("logs")
public class LogController {
	
	@Autowired
	private ILogService logService;
	
	@PostMapping
	@ResponseBody
	public void save(Log log) {
		logService.save(log);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer lig) {
		logService.delete(lig);
	}
	
	@PutMapping
	@ResponseBody
	public void update(Log log) {
		logService.update(log);
	}
	
	
	@GetMapping(value = "/{uid}")
	@ResponseBody
	public List<Log> findByUid(@PathVariable Integer uid){
		System.out.println(uid);
		return logService.findByUid(uid);
	}
	
	@GetMapping
	@ResponseBody
	public List<Log> find() {
		return logService.find();
	}
	

}
