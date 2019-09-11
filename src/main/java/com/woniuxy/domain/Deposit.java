package com.woniuxy.domain;

import java.math.BigDecimal;

public class Deposit {
    private Integer did;

    private Integer gid;

    private Integer uid;

    private BigDecimal dmoney;

    private Integer gstate;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
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

    public BigDecimal getDmoney() {
        return dmoney;
    }

    public void setDmoney(BigDecimal dmoney) {
        this.dmoney = dmoney;
    }

    public Integer getGstate() {
        return gstate;
    }

    public void setGstate(Integer gstate) {
        this.gstate = gstate;
    }
}