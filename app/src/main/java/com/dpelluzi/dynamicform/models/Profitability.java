package com.dpelluzi.dynamicform.models;

import com.google.gson.annotations.SerializedName;

public class Profitability {

    @SerializedName("month")
    private Incoming month;

    @SerializedName("year")
    private Incoming year;

    @SerializedName("12months")
    private Incoming last12months;

    public Incoming getMonth() {
        return month;
    }

    public void setMonth(Incoming month) {
        this.month = month;
    }

    public Incoming getYear() {
        return year;
    }

    public void setYear(Incoming year) {
        this.year = year;
    }

    public Incoming get12months() {
        return last12months;
    }

    public void setLast12months(Incoming last12months) {
        this.last12months = last12months;
    }

}
