package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.ImageMapper;
import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Image;
import com.woniuxy.domain.Page;
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
	//分页查询
	@Override
	public List<Image> find(Page<Image> page) {
		return dao.find(page);
	}

	@Override
	public Image findOne(Integer imgid) {
		return dao.selectByPrimaryKey(imgid);
	}



	@Override
	public void updImg(Integer imgid, String img) {

		Image image = dao.selectByPrimaryKey(imgid); //查询出要修改的实体
		image.setImg(img);	//修改图片路径
		
		dao.updateByPrimaryKeySelective(image);
		
	} 
	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return  (int) dao.countByExample(null);
	}

	//查询
	@Override
	public List<Image> find() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
