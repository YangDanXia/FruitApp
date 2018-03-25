package cn.demo;

import android.app.Application;

import cn.demo.engine.Engine;


public class App extends Application {
    private static App sInstance;
    private Engine mEngine;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public static App getInstance() {
        return sInstance;
    }

    public Engine getEngine() {
        return mEngine;
    }
}