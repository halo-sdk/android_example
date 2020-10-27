package com.example;

import android.app.Application;

import com.halo.HaloClient;

/**
 * @author : GuoXuan
 * @since : 2019/4/18
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        HaloClient.init("10000");
    }
}
