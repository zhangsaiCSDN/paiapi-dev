package com.woniuxy.domain;

public class Permission {
    private Integer pmsid;

    private String pmsname;

    private String pmsdes;

    private Integer pid;

    private String url;

    public Integer getPmsid() {
        return pmsid;
    }

    public void setPmsid(Integer pmsid) {
        this.pmsid = pmsid;
    }

    public String getPmsname() {
        return pmsname;
    }

    public void setPmsname(String pmsname) {
        this.pmsname = pmsname;
    }

    public String getPmsdes() {
        return pmsdes;
    }

    public void setPmsdes(String pmsdes) {
        this.pmsdes = pmsdes;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}