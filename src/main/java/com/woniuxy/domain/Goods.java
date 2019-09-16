package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Goods implements Serializable {
    private Integer gid;
 
    private String gname;

    private Double gprice;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gstart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gend;

    private Integer gcount; 

    private Double ggap;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gpasstime;

    private Integer gstate;

    private String garea;

    private String ginfo;

    private Integer salerid;

    private Integer gtid;

    
}