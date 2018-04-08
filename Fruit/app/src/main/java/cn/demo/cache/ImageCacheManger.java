package cn.demo.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import cn.demo.ui.activity.DemoApplication;
import cn.demo.cache.ImageLreCache;
import cn.demo.ui.activity.RequestQueueManager;

/**
 * Created by saymagic on 15/1/27.
 */
public class ImageCacheManger {

    // 取运行内存阈值的1/8作为图片缓存
    private static final int MEM_CACHE_SIZE = 1024 * 1024 * ((ActivityManager) DemoApplication.getInstance()
            .getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass() / 8;

    //第五个 传入文件目录 完成两层缓存
    private static ImageLreCache mImageLreCache = new ImageLreCache(MEM_CACHE_SIZE,"images",10*1024*1024);

    //第四个
    public static ImageLoader  mImageLoder = new ImageLoader(RequestQueueManager.mRequestQueue,mImageLreCache);



    //第一点五个  获取bitmap
    public static ImageLoader.ImageListener getImageLinseter(final ImageView view,
                                                             final Bitmap defaultImageBitmap, final Bitmap errorImageBitmap){

        return new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer imageContainer, boolean b) {
                if(imageContainer.getBitmap() != null ){
                    view.setImageBitmap(imageContainer.getBitmap());
                }else if(defaultImageBitmap != null ){
                    view.setImageBitmap(defaultImageBitmap);
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(errorImageBitmap != null){
                    view.setImageBitmap(errorImageBitmap);
                }
            }
        };
    }

    /**
     * 第二个
     *
     * @param requestUrl
     * @param imageListener
     * @return
     */
    public static ImageLoader.ImageContainer loadImage(String requestUrl,
                                                       ImageLoader.ImageListener imageListener) {
        return loadImage(requestUrl, imageListener, 0, 0);
    }

    /**
     * 第三个
     *
     * @param url
     * @param listener
     * @param maxWidth
     * @param maxHeight
     * @return
     */
    public static ImageLoader.ImageContainer loadImage(String url,ImageLoader.ImageListener listener, int maxWidth, int maxHeight){
        return mImageLoder.get(url, listener, maxWidth, maxHeight);
    }

    /**
     * 第一个
     *
     * 外部调用次方法即可完成将url处图片现在view上，并自动实现内存和硬盘双缓存。
     * @param url 远程url地址
     * @param view 待现实图片的view
     * @param defaultImageBitmap 默认显示的图片
     * @param errorImageBitmap 网络出错时显示的图片
     */
    public static ImageLoader.ImageContainer loadImage(final String url, final ImageView view,
                                                       final Bitmap defaultImageBitmap, final Bitmap errorImageBitmap){
        return loadImage(url, getImageLinseter(view,defaultImageBitmap,
                errorImageBitmap));
    }

    /**
     * 外部调用次方法即可完成将url处图片现在view上，并自动实现内存和硬盘双缓存。
     * @param url 远程url地址
     * @param view 待现实图片的view
     * @param defaultImageBitmap 默认显示的图片
     * @param errorImageBitmap 网络出错时显示的图片
     * @param maxWidtn
     * @param maxHeight
     */
    public static ImageLoader.ImageContainer loadImage(final String url, final ImageView view,
                                                       final Bitmap defaultImageBitmap, final Bitmap errorImageBitmap, int maxWidtn, int maxHeight){
        return loadImage(url, getImageLinseter(view,defaultImageBitmap,
                errorImageBitmap),maxWidtn,maxHeight);
    }
}