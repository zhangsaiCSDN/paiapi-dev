package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable{
    private Integer rid;
    private String rname;
    private String rdes;
    Set<Permission> permissions;
}