package cn.demo.ui.activity;

import android.app.Application;

/**
 * Created by Forever on 2018/3/26.
 */

public class DemoApplication extends Application {
    public static String TAG;
    private static DemoApplication application;
    public static DemoApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TAG = this.getClass().getSimpleName();
        application = this;
    }
}