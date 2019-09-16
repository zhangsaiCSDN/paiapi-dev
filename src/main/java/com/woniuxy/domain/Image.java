package com.woniuxy.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Image implements Serializable {
    private Integer imgid;

    private Integer gid;

    private String img;

    private Goods goods;//外键 的实体
}