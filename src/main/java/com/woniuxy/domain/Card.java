package com.woniuxy.domain;

public class Card {
    private Integer cid;

    private Integer uid;

    private String cfront;

    private String cback;

    private Integer cstate;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCfront() {
        return cfront;
    }

    public void setCfront(String cfront) {
        this.cfront = cfront;
    }

    public String getCback() {
        return cback;
    }

    public void setCback(String cback) {
        this.cback = cback;
    }

    public Integer getCstate() {
        return cstate;
    }

    public void setCstate(Integer cstate) {
        this.cstate = cstate;
    }
}