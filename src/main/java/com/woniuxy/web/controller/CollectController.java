package com.woniuxy.web.controller;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Collect;
import com.woniuxy.service.ICollectService;

import lombok.Getter;

@Controller
@RequestMapping("collects")
public class CollectController {

	@Autowired
	private ICollectService service;

	@GetMapping
	@ResponseBody
	public List<Collect> find() {
		return service.find();
	}
  
	@GetMapping(value = "/{clid}")
	@ResponseBody
	public Collect findOne(@PathVariable Integer clid) {

		return service.findOne(clid);
	}

	@DeleteMapping
	@ResponseBody
	public void delete(Integer clid) {

		service.delete(clid);
	}

	@PutMapping
	@ResponseBody
	public void update(Collect collect) {
		service.update(collect);

	}

	@PostMapping
	@ResponseBody
	public void save(Collect collect) {
		service.save(collect);
	}

}
