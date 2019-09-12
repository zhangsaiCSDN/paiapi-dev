package com.woniuxy.domain;

import lombok.Data;

@Data
public class User {
    private Integer uid;

    private Integer cid;

    private String uname;

    private String upwd;

    private Integer ustate;

}