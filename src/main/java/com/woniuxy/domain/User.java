package com.woniuxy.domain;

import java.util.Date;
import java.util.Set;

import lombok.Data;
@Data
public class User {
    private Integer uid;

    private Integer cid;

    private String uname;

    private String upwd;

    private Integer ustate;

    private String avatar;

    private String salt;

    private String tel;

    private Date regtime;

    private Date updatetime;

    private Set<Role> roles;
}