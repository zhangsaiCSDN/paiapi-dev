package com.woniuxy.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Goodstype implements Serializable{
    private Integer gtid;

    private String gtname;

    private String img;

    private String gtdes;

}