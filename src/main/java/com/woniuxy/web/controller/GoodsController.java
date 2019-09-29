package com.woniuxy.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Goodstype;
import com.woniuxy.domain.Orders;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IGoodsService;
import com.woniuxy.service.IGoodsTypeService;
import com.woniuxy.service.impl.GoodsServiceImpl;

@Controller
@RequestMapping("goods")
public class GoodsController {
	
	@Autowired
	private IGoodsService service;
	@Autowired
	private IGoodsTypeService goodsTypeService; 
	
	
	
	
	//查询所有拍品 返回值是Page
	@GetMapping("page")
	@ResponseBody
	public Page<Goods> find(Integer p) {
		if(p==null)p=1;
		int count=service.count();
		Page<Goods> page=new Page<>(p,count,5);
		List<Goods> list=service.find(page);
		page.setList(list);
		return page;
	}
	
	//原生查询
	@GetMapping
	@ResponseBody
	public List<Goods> find(HttpServletResponse resp) {
		List<Goods> list = service.find();
		return list;
	}
	
	//模糊查询
	@GetMapping("findBySearch")
	@ResponseBody
	public List<Goods> find(@RequestParam Map<String,Object> map) {
		List<Goods> list = service.find(map);
		for (Goods goods : list) {
			System.out.println(goods);
		}
		return list;
	}
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Goods goods) {
		service.save(goods);
	}
	
	@DeleteMapping
	@ResponseBody 
	public void delete(Integer gid) {
		service.delete(gid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Goods goods) {
		service.update(goods); 
	}
	@GetMapping("getGoodsType")
	@ResponseBody
	public List<Goodstype> getGoodsType() {
		return goodsTypeService.find();
	}
	
	@GetMapping("image")
	@ResponseBody
	public Page<Goods> findImage(HttpServletResponse resp,Integer gid,Integer p) {
		Integer p1=p;
		if(p==null)p=1;
		int count=service.count();
		Page<Goods> page=new Page<>(p,count,10);
		Map<String,Object> map= new HashMap<>();
		map.put("gid", gid);
		if(p1!=null) {
			map.put("page", page);
		}else {
			map.put("page", null);
		}
		List<Goods> list=service.findByImages(map);
		page.setList(list);
		return page;
	}
	
	
}
