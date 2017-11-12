package com.hdy.fast;

import android.app.Application;
import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;

/**
 * 作者：By hdy
 * 日期：On 2017/10/7
 * 时间：At 21:50
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        OkHttpFinal.getInstance().init(builder.build());
        //初始化OkHttpFinal 此初始化只是简单赋值不会阻塞线程
    }
}
