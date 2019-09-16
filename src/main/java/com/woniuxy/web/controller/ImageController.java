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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woniuxy.domain.Goods;
import com.woniuxy.domain.Image;
import com.woniuxy.service.impl.GoodsServiceImpl;
import com.woniuxy.service.impl.ImageServiceImpl;

@Controller
@RequestMapping("images")
public class ImageController {
	
	@Autowired
	private ImageServiceImpl service;
	@Autowired
	private GoodsServiceImpl goodsService; //查goods返回所有外键
	//查询所有拍品图片
	@GetMapping
	@ResponseBody
	public List<Image> find() {
		return service.findByGoods();
	}

	@DeleteMapping
	@ResponseBody
	public void delete(Integer imgid) {
		service.delete(imgid);
	}

 
    @PostMapping
	@ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] files,Integer gid,HttpServletRequest request){//支持多个文件的上传
    	
        //实例化一个文件存放的目录地址
        String dir = request.getServletContext().getRealPath("/goodsImg");
        for (MultipartFile file : files){
            System.out.println("文件类型:"+file.getContentType());

          
            String oldName = file.getOriginalFilename();		//文件名
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
                file.transferTo(dirFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //存入数据库
            Image image = new Image();
            image.setGid(gid);
            image.setImg(newName);
            service.save(image);
        }
        return "OK";
    }

	
}
