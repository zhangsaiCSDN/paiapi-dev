package com.woniuxy.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userstest {
    private Integer id;
    private String name;
    private Date birthday;
    private Double money;
}