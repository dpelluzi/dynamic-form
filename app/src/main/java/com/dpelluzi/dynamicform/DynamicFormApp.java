package com.dpelluzi.dynamicform;

import android.app.Application;

public class DynamicFormApp extends Application {

    private static DynamicFormApp sAppInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppInstance = this;
    }

    public static DynamicFormApp getAppInstance() {
        return sAppInstance;
    }

}
