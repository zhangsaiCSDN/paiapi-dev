package com.woniuxy.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woniuxy.domain.Card;
import com.woniuxy.domain.Page;
import com.woniuxy.service.ICardService;

@Controller
@RequestMapping("cards")
public class CardController {

	@Autowired
	private ICardService service;
	
	@PostMapping
	@ResponseBody
	public void save(@RequestBody Card card) {
		service.save(card);
	}
	
	@DeleteMapping
	@ResponseBody
	public void delete(Integer cid) {
		service.delete(cid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(Card card) {
		service.update(card);
	}
	
	
	@GetMapping(value="/cid")
	@ResponseBody
	public Card findOne(Integer cid) {
		return service.findOne(cid);
	}
	
	@GetMapping
	@ResponseBody
	public Page<Card> find(Integer p){
		if(p==null) {
			p=1;
		}
		int count = service.count();
		Page<Card> page=new Page<Card>(p, count, 5);
		List<Card> list = service.find(page);
		page.setList(list);
 		return page;
	}
	
	
	@PostMapping("upload")
	@ResponseBody
	public Map<String,String> upload(@RequestParam MultipartFile cfront,MultipartFile cback,HttpServletRequest request) {
		Map<String,String> map = new HashMap<String,String>();
		String dir = request.getServletContext().getRealPath("/admin/card/IDCardImg");
		String name = cfront.getOriginalFilename();
		String backName = cback.getOriginalFilename();
		String dotName = name.substring(name.lastIndexOf("."));
		String dotBackName = backName.substring(backName.lastIndexOf("."));
		String fullName ="FRONT_"+ UUID.randomUUID().toString()+dotName;
		String fullBackName ="BACK_"+ UUID.randomUUID().toString()+dotBackName;
		map.put("cfront", "IDCardImg/"+fullName);
		map.put("cback", "/admin/card/IDCardImg/"+fullBackName);
		File dirFile = new File(dir,fullName);
		
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		File dirBackFile = new File(dir,fullBackName);
		if (!dirBackFile.exists()) {
			dirBackFile.mkdirs();
		}
		try {
			cfront.transferTo(dirFile);
			cback.transferTo(dirBackFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
}
