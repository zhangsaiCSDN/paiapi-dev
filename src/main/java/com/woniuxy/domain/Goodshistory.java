package com.woniuxy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Goodshistory {
    private Integer ghid;

    private Integer gid;

    private Double ghmoney;

    private Date ghtime;

    private Integer buyerid;

    private String ghdes;

    private Date ghdeadline;

    private Integer paystate;
}