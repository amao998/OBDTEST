package com.mh.obdtest.obdtest;


import android.app.Application;
import com.jbt.mds.sdk.dbutils.x;
import com.jbt.mds.sdk.obd.JbtOBDSDK;

public class SdkApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化 OBD 检测SDK
        JbtOBDSDK.getInstance().init(this);
    }


}