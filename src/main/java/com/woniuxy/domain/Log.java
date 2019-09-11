package com.woniuxy.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private Integer lig;

    private Integer uid;

    private Date ltime;

    private String loption;
 
}