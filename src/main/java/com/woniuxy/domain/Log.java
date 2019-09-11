package com.woniuxy.domain;

import java.util.Date;

public class Log {
    private Integer lig;

    private Integer uid;

    private Date ltime;

    private String loption;

    public Integer getLig() {
        return lig;
    }

    public void setLig(Integer lig) {
        this.lig = lig;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    public String getLoption() {
        return loption;
    }

    public void setLoption(String loption) {
        this.loption = loption;
    }
}