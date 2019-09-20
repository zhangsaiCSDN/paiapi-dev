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
		Integer imgid = image.getImgid();
		Image oldImage = dao.selectByPrimaryKey(imgid); //查询出要修改的实体
		
		Integer gid = image.getGid();
		
		String img = image.getImg();
		
		oldImage.setGid(gid);
		dao.updateByPrimaryKey(oldImage);
	}

	@Override
	public List<Image> find() {
		return dao.selectByExample(null);
	}

	@Override
	public Image findOne(Integer imgid) {
		return dao.selectByPrimaryKey(imgid);
	}

	@Override
	public List<Image> findByGoods() {
		return dao.find();
	}

	@Override
	public void updImg(Integer imgid, String img) {

		Image image = dao.selectByPrimaryKey(imgid); //查询出要修改的实体
		image.setImg(img);	//修改图片路径
		
		dao.updateByPrimaryKeySelective(image);
		
	} 

}
