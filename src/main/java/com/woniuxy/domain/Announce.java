package com.woniuxy.domain;

import java.util.Date;

public class Announce {
    private Integer anid;

    private Integer gid;

    private String ancontent;

    private Date anstart;

    private Date anend;

    public Integer getAnid() {
        return anid;
    }

    public void setAnid(Integer anid) {
        this.anid = anid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getAncontent() {
        return ancontent;
    }

    public void setAncontent(String ancontent) {
        this.ancontent = ancontent;
    }

    public Date getAnstart() {
        return anstart;
    }

    public void setAnstart(Date anstart) {
        this.anstart = anstart;
    }

    public Date getAnend() {
        return anend;
    }

    public void setAnend(Date anend) {
        this.anend = anend;
    }
}