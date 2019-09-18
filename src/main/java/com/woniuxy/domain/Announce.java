package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announce implements Serializable{
    private Integer anid;

    private Integer gid;
    
    private String ancontent;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date anstart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date anend;
    
    
    private Goods goods;
}