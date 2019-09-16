package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Pricehistory implements Serializable {
	
	
    private Integer phid;

    private Integer gid;

    private Integer uid;

    private Double phmoney;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date phtime;
    
    private User user = new User();
    
    private Goods goods = new Goods();
}