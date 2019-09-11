package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Card;

public interface ICardService {
	void save(Card card);
	void delete(Integer cid);
	void update(Card card);
	Card findOne(Integer cid);
	List<Card> find(); 
}
