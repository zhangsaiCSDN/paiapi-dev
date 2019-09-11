package com.woniuxy.domain;

public class CardWithBLOBs extends Card {
    private String cfront;

    private String cback;

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
}