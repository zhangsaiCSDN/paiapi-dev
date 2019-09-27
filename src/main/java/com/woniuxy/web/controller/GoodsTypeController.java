package com.woniuxy.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woniuxy.domain.Goodstype;
import com.woniuxy.domain.Image;
import com.woniuxy.service.impl.GoodsTypeServiceImpl;

@Controller
@RequestMapping("goodsType")
public class GoodsTypeController {

	@Autowired
	private GoodsTypeServiceImpl service;
 
	// 查询所有商品类型 单表查询
	@GetMapping
	@ResponseBody
	public List<Goodstype> find() {
		List<Goodstype> list = service.find();
		return list;
	};
	// 查询所有商品类型 级联查询 goodType 一对多 goods ,goods一对多 Images
	@GetMapping("findAll")
	@ResponseBody
	public List<Goodstype> findAll() {
		List<Goodstype> goodTypeAll = service.goodTypeAll();
		return goodTypeAll;
	};

	@DeleteMapping
	@ResponseBody
	public void delete(Integer gtid) {
		service.delete(gtid);
	}

	@PutMapping
	@ResponseBody
	public void update(@RequestBody Goodstype goodstype) {
		service.update(goodstype);
	}

	@PostMapping
	@ResponseBody
	public void save(@RequestParam MultipartFile photo,String gtname,String gtdes, HttpServletRequest request) {// 支持多个文件的上传

			// 实例化一个文件存放的目录地址 
			String dir = request.getServletContext().getRealPath("/admin/goods/goodsTypeImg");
	
			String oldName = photo.getOriginalFilename(); // 文件名 
			int lastDot = oldName.lastIndexOf(".");
			String ext = oldName.substring(lastDot);
			String newName = UUID.randomUUID().toString() + ext; // 存入数据库的文件名
			// 创建要保存文件的路径
			File dirFile = new File(dir, newName);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			try {
				// 将文件写入创建的路径
				photo.transferTo(dirFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 存入数据库
			Goodstype goodstype=new Goodstype();
			goodstype.setGtname(gtname);
			goodstype.setGtdes(gtdes);
			goodstype.setImg(newName);

			service.save(goodstype);
	
		
	}	
	  //修改图片
    @PostMapping("updImg")
   	@ResponseBody
       public void udpImg(@RequestParam MultipartFile photo,Integer gtid,HttpServletRequest request){//支持多个文件的上传
           //实例化一个文件存放的目录地址
           String dir = request.getServletContext().getRealPath("/admin/goods/goodsTypeImg");
          
    
             
               String oldName = photo.getOriginalFilename();		//文件名
               int lastDot = oldName.lastIndexOf(".");
               String ext =oldName.substring(lastDot);
               String newName = UUID.randomUUID().toString()+ext;  //存入数据库的文件名
               //创建要保存文件的路径
               File dirFile = new File(dir,newName);
               if (!dirFile.exists()){
                   dirFile.mkdirs();
               } 
               try {
                   //将文件写入创建的路径
               	photo.transferTo(dirFile);
               } catch (IOException e) {
                   e.printStackTrace();
               }
               //存入数据库

               service.updImg(gtid, newName);


       }
}

