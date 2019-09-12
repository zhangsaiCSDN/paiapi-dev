package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Goodshistory implements Serializable {
    private Integer ghid;

    private Integer gid;

    private Double ghmoney;

    private Date ghtime;

    private Integer buyerid;

    private String ghdes;

    private Date ghdeadline;

    private Integer paystate;
}