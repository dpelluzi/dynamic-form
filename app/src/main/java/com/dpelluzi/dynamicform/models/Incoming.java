package com.dpelluzi.dynamicform.models;

import com.google.gson.annotations.SerializedName;

public class Incoming {

    @SerializedName("fund")
    private float fund;

    @SerializedName("CDI")
    private float cDI;

    public float getFund() {
        return fund;
    }

    public void setFund(float fund) {
        this.fund = fund;
    }

    public float getCDI() {
        return cDI;
    }

    public void setCDI(float cDI) {
        this.cDI = cDI;
    }

}
