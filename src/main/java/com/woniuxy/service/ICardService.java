package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Card;
import com.woniuxy.domain.Page;

public interface ICardService {
	void save(Card card);
	void delete(Integer cid);
	void update(Card card);
	Card findOne(Integer cid);
	List<Card> find(Page<Card> page);
	Integer count();
}
