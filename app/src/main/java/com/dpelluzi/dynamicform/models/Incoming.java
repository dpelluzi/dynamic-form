package com.dpelluzi.dynamicform.models;

import com.google.gson.annotations.SerializedName;

public class Incoming {

    @SerializedName("fund")
    private float fund;

    @SerializedName("CDI")
    private float cdi;

    public float getFund() {
        return fund;
    }

    public void setFund(float fund) {
        this.fund = fund;
    }

    public float getCdi() {
        return cdi;
    }

    public void setCdi(float cdi) {
        this.cdi = cdi;
    }

}
