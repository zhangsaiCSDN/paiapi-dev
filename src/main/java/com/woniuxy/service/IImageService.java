package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Image;

public interface IImageService {
	void save(Image image);
	void delete(Integer imgid);
	void update(Image image);
	List<Image> find();
	Image findOne(Integer imgid);
	List<Image> findByGoods();
}
