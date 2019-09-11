package com.woniuxy.domain;

import java.util.Date;

public class Goodshistory {
    private Integer ghid;

    private Integer gid;

    private Double ghmoney;

    private Date ghtime;

    private Integer buyerid;

    private String ghdes;

    private Date ghdeadline;

    private Integer paystate;

    public Integer getGhid() {
        return ghid;
    }

    public void setGhid(Integer ghid) {
        this.ghid = ghid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Double getGhmoney() {
        return ghmoney;
    }

    public void setGhmoney(Double ghmoney) {
        this.ghmoney = ghmoney;
    }

    public Date getGhtime() {
        return ghtime;
    }

    public void setGhtime(Date ghtime) {
        this.ghtime = ghtime;
    }

    public Integer getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    public String getGhdes() {
        return ghdes;
    }

    public void setGhdes(String ghdes) {
        this.ghdes = ghdes;
    }

    public Date getGhdeadline() {
        return ghdeadline;
    }

    public void setGhdeadline(Date ghdeadline) {
        this.ghdeadline = ghdeadline;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }
}