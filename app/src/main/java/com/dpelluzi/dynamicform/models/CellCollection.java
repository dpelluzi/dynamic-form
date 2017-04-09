package com.dpelluzi.dynamicform.models;

import android.content.res.AssetManager;
import android.util.Log;

import com.dpelluzi.dynamicform.DynamicFormApp;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CellCollection {

    @SerializedName("cells")
    private List<Cell> mCells;

    public static CellCollection loadCells() {
        Gson gson = new Gson();
        return gson.fromJson(loadJsonFromAsset(), CellCollection.class);
    }

    private static String loadJsonFromAsset() {
        String json;
        try {
            AssetManager assetManager = DynamicFormApp.getAppInstance().getAssets();
            InputStream inputStream = assetManager.open("cells.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.w("DynamicForm", "Fail to load cells.json");
            return null;
        }
        return json;
    }

    public List<Cell> getCells() {
        return mCells;
    }
}
