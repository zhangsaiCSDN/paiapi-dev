package com.woniuxy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Orders {
    private Integer odid;

    private Double odmoney;

    private Date odtime;

    private Integer buyerid;

    private Integer salerid;

    private Double odfee;

    private Integer uid;

    private Integer gid;

}