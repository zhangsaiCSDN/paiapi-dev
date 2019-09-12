package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Announce implements Serializable{
    private Integer anid;

    private Integer gid;

    private String ancontent;

    private Date anstart;

    private Date anend;
}