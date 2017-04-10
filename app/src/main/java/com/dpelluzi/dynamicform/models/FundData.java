package com.dpelluzi.dynamicform.models;

import android.content.res.AssetManager;
import android.util.Log;

import com.dpelluzi.dynamicform.DynamicFormApp;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;

public final class FundData {

    @SerializedName("screen")
    private Fund mFund;

    public static FundData loadFundData() {
        Gson gson = new Gson();
        return gson.fromJson(loadJsonFromAsset(), FundData.class);
    }

    private static String loadJsonFromAsset() {
        String json;
        try {
            AssetManager assetManager = DynamicFormApp.getAppInstance().getAssets();
            InputStream inputStream = assetManager.open("fund.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.w("DynamicForm", "Fail to load fund.json");
            return null;
        }
        return json;
    }

    public Fund getFund() {
        return mFund;
    }
}
