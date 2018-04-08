package cn.demo.ui.activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Forever on 2018/3/26.
 */

public class RequestQueueManager {
    public static RequestQueue mRequestQueue = 	Volley.newRequestQueue(DemoApplication.getInstance());

    public static void addRequest(Request<?> request, Object object){
        if (object != null){
            request.setTag(object);
        }
        mRequestQueue.add(request);
    }

    public static void cancelAll(Object tag) {
        mRequestQueue.cancelAll(tag);
    }
}