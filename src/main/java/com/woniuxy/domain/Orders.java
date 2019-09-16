package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Orders implements Serializable {
    private Integer odid;
    private Double odmoney;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date odtime;
    private Integer buyerid;
    private Integer salerid;
    private Double odfee;
    private Integer uid;
    private Integer gid;
    private Integer aid;
    
    private User user;
    private Goods goods;
    private Address address;

}