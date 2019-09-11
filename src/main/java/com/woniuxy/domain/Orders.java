package com.woniuxy.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Integer odid;

    private BigDecimal odmoney;

    private Date odtime;

    private Integer buyerid;

    private Integer salerid;

    private BigDecimal odfee;

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public BigDecimal getOdmoney() {
        return odmoney;
    }

    public void setOdmoney(BigDecimal odmoney) {
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

    public BigDecimal getOdfee() {
        return odfee;
    }

    public void setOdfee(BigDecimal odfee) {
        this.odfee = odfee;
    }
}