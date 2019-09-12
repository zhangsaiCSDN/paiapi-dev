package com.woniuxy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Goods {
    private Integer gid;
 
    private String gname;

    private Double gprice;

    private Date gstart;

    private Date gend;

    private Integer gcount;

    private Double ggap;

    private Date gpasstime;

    private Integer gstate;

    private String garea;

    private String ginfo;

    private Integer salerid;

    private Integer gtid;

    
}