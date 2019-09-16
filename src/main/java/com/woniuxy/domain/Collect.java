package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class Collect implements Serializable{
    private Integer clid;

    private Date cltime;

    private Integer uid;

    private Integer gid;

   
}