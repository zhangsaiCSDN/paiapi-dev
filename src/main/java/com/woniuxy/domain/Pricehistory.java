package com.woniuxy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Pricehistory {
    private Integer phid;

    private Integer gid;

    private Integer uid;

    private Double phmoney;

    private Date phtime;
}