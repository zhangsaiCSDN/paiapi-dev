package com.woniuxy.domain;

import java.util.Date;

public class Pricehistory {
    private Integer phid;

    private Integer gid;

    private Integer uid;

    private Double phmoney;

    private Date phtime;

    public Integer getPhid() {
        return phid;
    }

    public void setPhid(Integer phid) {
        this.phid = phid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getPhmoney() {
        return phmoney;
    }

    public void setPhmoney(Double phmoney) {
        this.phmoney = phmoney;
    }

    public Date getPhtime() {
        return phtime;
    }

    public void setPhtime(Date phtime) {
        this.phtime = phtime;
    }
}