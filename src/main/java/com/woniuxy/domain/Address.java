package com.woniuxy.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {
    private Integer aid;
    private User user;
    private String ainfo;
    private String apost;
    private String aphone;
    
}