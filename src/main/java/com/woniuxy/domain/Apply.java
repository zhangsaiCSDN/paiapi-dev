package com.woniuxy.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Apply implements Serializable{
    private Integer apid;

    private String apno;

    private Integer apbusi;

    private String apinfo;

    private Integer apstate;

    private String apreason;

    private Integer uid;
 
 
}