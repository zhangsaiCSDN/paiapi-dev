package com.woniuxy.domain;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Integer pmsid;
    private String pmsname;
    private String pmsdes;
    
}