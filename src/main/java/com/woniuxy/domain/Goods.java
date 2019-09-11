package com.woniuxy.domain;

import java.util.Date;

public class Goods {
    private Integer gid;

    private Integer rmid;

    private Integer anid;

    private Integer did;

    private Integer gtid;

    private String gname;

    private Double gprice;

    private Date gstart;

    private Date gend;

    private Integer gcount;

    private Double ggap;

    private Date gpasstime;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public Integer getAnid() {
        return anid;
    }

    public void setAnid(Integer anid) {
        this.anid = anid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getGtid() {
        return gtid;
    }

    public void setGtid(Integer gtid) {
        this.gtid = gtid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public Date getGstart() {
        return gstart;
    }

    public void setGstart(Date gstart) {
        this.gstart = gstart;
    }

    public Date getGend() {
        return gend;
    }

    public void setGend(Date gend) {
        this.gend = gend;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    public Double getGgap() {
        return ggap;
    }

    public void setGgap(Double ggap) {
        this.ggap = ggap;
    }

    public Date getGpasstime() {
        return gpasstime;
    }

    public void setGpasstime(Date gpasstime) {
        this.gpasstime = gpasstime;
    }
}