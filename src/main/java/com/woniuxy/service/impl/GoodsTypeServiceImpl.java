package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.AnnounceMapper;
import com.woniuxy.dao.GoodstypeMapper;
import com.woniuxy.domain.Goodstype;
import com.woniuxy.domain.Image;
import com.woniuxy.service.IGoodsTypeService;


@Service
@Transactional
public class GoodsTypeServiceImpl implements IGoodsTypeService {

	@Autowired
	private GoodstypeMapper mapper;
	
	@Override
	public void save(Goodstype goodstype) {
		mapper.insert(goodstype);
	}

	@Override
	public void delete(Integer gtid) {
		mapper.deleteByPrimaryKey(gtid);
	}

	@Override
	public void update(Goodstype goodstype) {

		Goodstype findOne = mapper.selectByPrimaryKey(goodstype.getGtid());
		//修改商品类型字段 除图片
		findOne.setGtname(goodstype.getGtname());
		findOne.setGtdes(goodstype.getGtdes());
		mapper.updateByPrimaryKey(findOne);
	}

	@Override
	public Goodstype findOne(Integer gtid) {
		return mapper.selectByPrimaryKey(gtid);
	}

	@Override
	public List<Goodstype> find() {
		return mapper.selectByExample(null);
	}

	@Override
	public void updImg(Integer gtid, String img) {
		 Goodstype goodstype = mapper.selectByPrimaryKey(gtid); //查询出要修改的实体
		 goodstype.setImg(img);	//修改图片路径
		
		mapper.updateByPrimaryKeySelective(goodstype);
		
	}
	
	//联合查询goods image 第一张图
	@Override
	public List<Goodstype> goodTypeAll() {
		// TODO Auto-generated method stub
		return mapper.goodTypeAll();
	}

}
