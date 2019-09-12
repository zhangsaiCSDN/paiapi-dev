package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.ImageMapper;
import com.woniuxy.domain.Image;
import com.woniuxy.service.IImageService;

@Service
@Transactional 
public class ImageServiceImpl implements IImageService {
	
	@Autowired
	public ImageMapper dao;

	@Override
	public void save(Image image) {
		dao.insert(image);
	}

	@Override
	public void delete(Integer imgid) {
		dao.deleteByPrimaryKey(imgid);
	}

	@Override
	public void update(Image image) {
		dao.updateByPrimaryKey(image);
	}

	@Override
	public List<Image> find() {
		return dao.selectByExample(null);
	}

	@Override
	public Image findOne(Integer imgid) {
		return dao.selectByPrimaryKey(imgid);
	}

}
