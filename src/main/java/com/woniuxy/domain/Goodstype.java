package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class Goodstype implements Serializable{
    private Integer gtid;

    private String gtname;

    private String img;

    private String gtdes;
    
    private Set<Goods> goods;

}