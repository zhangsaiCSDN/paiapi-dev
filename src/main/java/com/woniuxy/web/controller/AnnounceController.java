package com.woniuxy.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Announce;
import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IAnnounceService;


//拍品公告管理
@Controller
@RequestMapping("announces")
public class AnnounceController {
	@Autowired
	private IAnnounceService service;
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Announce announce) {
		service.save(announce);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer anid) {
		service.delete(anid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Announce announce) {
		service.update(announce);
	}
	
	@GetMapping(value="/{anid}")
	@ResponseBody
	public Announce findOne(Integer anid) {
		return service.findOne(anid);
	}
	
	
	@GetMapping
	@ResponseBody
	public Page<Announce> find(Integer p){
		//如果后台接受到的p为null，就设置为1
		if(p==null) p=1;
		//从数据库中返回总行数
		int count=service.count();
		//调用page类，将返回的封装了各种运算结果的page对象放入到list集合中
		Page<Announce> page=new Page<>(p,count,5);
		List<Announce> list=service.find(page);
		page.setList(list);
		return page;
	}
	
	@GetMapping("goods")
	@ResponseBody
	public List<Goods> findAllGoods(){
		List<Goods> goods=service.findAllGoods();
		return goods;
	}
	
}
