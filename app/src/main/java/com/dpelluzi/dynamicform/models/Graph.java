package com.dpelluzi.dynamicform.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Graph {

    @SerializedName("CDI")
    private float[] cDI;

    @SerializedName("fund")
    private float[] fund;

    @SerializedName("x")
    private List<String> x;

    public float[] getCDI() {
        return cDI;
    }

    public void setCDI(float[] cDI) {
        this.cDI = cDI;
    }

    public float[] getFund() {
        return fund;
    }

    public void setFund(float[] fund) {
        this.fund = fund;
    }

    public List<String> getX() {
        return x;
    }

    public void setX(List<String> x) {
        this.x = x;
    }

}
