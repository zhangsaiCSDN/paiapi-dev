package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Image;
import com.woniuxy.domain.Page;

public interface IImageService {
	void save(Image image);
	void delete(Integer imgid);
	void update(Image image);
	List<Image> find(Page<Image> page);//分页查询	
	List<Image> find();				//查询
	Image findOne(Integer imgid);
	void updImg(Integer imgid,String img);
	Integer count();
}
 