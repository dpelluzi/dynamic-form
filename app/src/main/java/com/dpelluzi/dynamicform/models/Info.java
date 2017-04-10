package com.dpelluzi.dynamicform.models;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("name")
    private String name;

    @SerializedName("data")
    private Object data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
