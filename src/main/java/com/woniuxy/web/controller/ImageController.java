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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Image;
import com.woniuxy.domain.Page;
import com.woniuxy.service.impl.GoodsServiceImpl;
import com.woniuxy.service.impl.ImageServiceImpl;

@Controller
@RequestMapping("images")
public class ImageController {
	
	@Autowired
	private ImageServiceImpl service;


	//查询图片分页 返回的是page 
	@GetMapping("page")
	@ResponseBody
	public Page<Image> find(Integer p) {
		if(p==null)p=1;
		int count=service.count();
		Page<Image> page=new Page<>(p,count,5);
		List<Image> list=service.find(page);
		page.setList(list);
		return page;
	}
	//查询图片
	@GetMapping
	@ResponseBody
	public List<Image> find() {
		return service.find();
	}

	@DeleteMapping
	@ResponseBody
	public void delete(Integer imgid) {
		service.delete(imgid);
	}
	
	@PutMapping
	@ResponseBody
	public void update(@RequestBody Image image) {
		service.update(image);
	}
 
    @PostMapping
	@ResponseBody
    public void save(@RequestParam MultipartFile photo,Integer gid,HttpServletRequest request){//支持多个文件的上传
        //实例化一个文件存放的目录地址
        String dir = request.getServletContext().getRealPath("/admin/goods/goodsImg");
       
 
          
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
            Image image = new Image();
            image.setGid(gid);
            image.setImg(newName);
            service.save(image);

    }
    //修改图片
    @PostMapping("updImg")
   	@ResponseBody
       public void udpImg(@RequestParam MultipartFile photo,Integer imgid,HttpServletRequest request){//支持多个文件的上传
           //实例化一个文件存放的目录地址
           String dir = request.getServletContext().getRealPath("/admin/goods/goodsImg");
          
    
             
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

               service.updImg(imgid, newName);


       }
	
}
