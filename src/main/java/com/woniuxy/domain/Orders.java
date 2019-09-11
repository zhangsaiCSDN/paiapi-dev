package com.woniuxy.domain;

import java.util.Date;

public class Orders {
    private Integer odid;

    private Double odmoney;

    private Date odtime;

    private Integer buyerid;

    private Integer salerid;

    private Double odfee;

    private Integer uid;

    private Integer gid;

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Double getOdmoney() {
        return odmoney;
    }

    public void setOdmoney(Double odmoney) {
        this.odmoney = odmoney;
    }

    public Date getOdtime() {
        return odtime;
    }

    public void setOdtime(Date odtime) {
        this.odtime = odtime;
    }

    public Integer getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    public Integer getSalerid() {
        return salerid;
    }

    public void setSalerid(Integer salerid) {
        this.salerid = salerid;
    }

    public Double getOdfee() {
        return odfee;
    }

    public void setOdfee(Double odfee) {
        this.odfee = odfee;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
}