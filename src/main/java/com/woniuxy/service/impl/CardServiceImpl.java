package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.CardMapper;
import com.woniuxy.domain.Card;
import com.woniuxy.service.ICardService;

@Service
@Transactional
public class CardServiceImpl implements ICardService  {
	
	@Autowired 
	private CardMapper mapper;

	@Override
	public void save(Card card) {
		mapper.insert(card);
	}

	@Override
	public void delete(Integer cid) {
		mapper.deleteByPrimaryKey(cid);
	}

	@Override
	public void update(Card card) {
		mapper.updateByPrimaryKeySelective(card);
	}

	@Override
	public Card findOne(Integer cid) {
		Card card = mapper.selectByPrimaryKey(cid);
		return card;
	}

	@Override
	public List<Card> find() {
		List<Card> list = mapper.selectByExample(null);
		return list;
	}

}