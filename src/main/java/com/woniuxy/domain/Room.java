package com.woniuxy.domain;

import java.io.Serializable; 
 
import lombok.Data;

@Data
public class Room implements Serializable{
    private Integer rmid;

    private Integer gid;

    private Integer salerid;

    private String rmtitle;

  
}