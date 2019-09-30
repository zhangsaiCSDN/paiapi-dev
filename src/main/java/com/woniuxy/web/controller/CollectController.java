package com.woniuxy.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Apply;
import com.woniuxy.domain.Collect;
import com.woniuxy.domain.Page;
import com.woniuxy.service.ICollectService;

@Controller
@RequestMapping("collects")
public class CollectController {

	@Autowired
	private ICollectService service;

	@GetMapping
	@ResponseBody
	public Page<Collect> find(Integer p) {
		
		if(p==null)p=1;
		int count = service.count();
		Page<Collect> page = new Page<>(p,count,5);
		List<Collect> list = service.find(page);
		page.setList(list);
		
		
		
		
		return page;
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
	public Map<String,Object> save(@RequestBody Collect collect,HttpSession session) {
		Integer uid=null;
		Map<String,Object> map=new HashMap<>();
		if(collect.getUid()==null) {
			String oldUid=(String) session.getAttribute("uid");
			if(oldUid!=null) {
				uid=Integer.parseInt(oldUid);
				collect.setUid(uid);
				map.put("status",200);
				service.save(collect);
			}else {
				map.put("status", 500);
				map.put("messge", "暂未登录,请先登录");
			}
		}else {
			service.save(collect);
			map.put("status", 200);
		}
		
		 return map;
	}

}
