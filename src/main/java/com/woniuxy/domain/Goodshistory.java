package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Goodshistory implements Serializable {
    private Integer ghid;

    private Integer gid;

    private Double ghmoney;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ghtime;

    private Integer buyerid;

    private String ghdes;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ghdeadline;

    private Integer paystate;
    
    private Goods goods;
    
    private User user;
    
    private Image image;
}