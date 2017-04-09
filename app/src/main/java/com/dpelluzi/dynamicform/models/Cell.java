package com.dpelluzi.dynamicform.models;

import android.support.annotation.IntDef;

import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Cell {

    @IntDef({CellType.FIELD, CellType.TEXT, CellType.IMAGE, CellType.CHECKBOX, CellType.SEND})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CellType {

        int FIELD = 1;
        int TEXT = 2;
        int IMAGE = 3;
        int CHECKBOX = 4;
        int SEND = 5;
    }

    @IntDef({FieldType.TEXT, FieldType.TEL_NUMBER, FieldType.EMAIL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FieldType {

        int TEXT = 1;
        int TEL_NUMBER = 2;
        int EMAIL = 3;
    }

    @SerializedName("id")
    private int mId;

    @SerializedName("type")
    private @CellType int mType;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("typefield")
    private @FieldType int mTypeField;

    @SerializedName("hidden")
    private boolean mHidden;

    @SerializedName("topSpacing")
    private float mTopSpacing;

    @SerializedName("show")
    private int mShow;

    @SerializedName("required")
    private boolean mRequired;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public @CellType int getType() {
        return mType;
    }

    public void setType(@CellType int type) {
        mType = type;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public @FieldType int getTypeField() {
        return mTypeField;
    }

    public void setTypeField(@FieldType int typeField) {
        mTypeField = typeField;
    }

    public boolean isHidden() {
        return mHidden;
    }

    public void setHidden(boolean hidden) {
        mHidden = hidden;
    }

    public float getTopSpacing() {
        return mTopSpacing;
    }

    public void setTopSpacing(float topSpacing) {
        mTopSpacing = topSpacing;
    }

    public int getShow() {
        return mShow;
    }

    public void setShow(int show) {
        mShow = show;
    }

    public boolean isRequired() {
        return mRequired;
    }

    public void setRequired(boolean required) {
        mRequired = required;
    }

}
