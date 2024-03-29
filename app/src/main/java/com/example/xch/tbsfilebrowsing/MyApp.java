package com.example.xch.tbsfilebrowsing;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initX5();
    }

    private void initX5() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("@@","加载内核是否成功:"+arg0);
            }

            @Override
            public void onCoreInitFinished() {
                Log.e("@@","加载内核是否onCoreInitFinished成功:");
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);
    }
}
