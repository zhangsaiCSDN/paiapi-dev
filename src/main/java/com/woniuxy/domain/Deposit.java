package com.woniuxy.domain;

import java.io.Serializable;
   
import lombok.Data;

@Data
public class Deposit implements Serializable{
    private Integer did;

    private Integer gid;

    private Integer uid;

    private Double dmoney;

    private Integer gstate;
    
    private User user;
    
    private Goods goods;

 
}