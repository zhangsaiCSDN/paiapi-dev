package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Pricehistory implements Serializable {
    private Integer phid;

    private Integer gid;

    private Integer uid;

    private Double phmoney;

    private Date phtime;
}