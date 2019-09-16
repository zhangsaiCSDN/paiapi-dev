package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Card;
import com.woniuxy.service.ICardService;

@Controller
@RequestMapping("cards")
public class CardController {

	@Autowired
	private ICardService service;
	
	@PostMapping
	@ResponseBody
	public void save(Card card) {
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
	public List<Card> find() {
		return service.find();
	}
}
