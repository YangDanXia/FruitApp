package cn.demo.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


import butterknife.OnClick;
import cn.demo.R;
import cn.demo.base.BaseFragment;
import cn.demo.ui.activity.ListViewActivity;
import cn.demo.ui.activity.LoginActivity;

/**
 * Created by Administrator on 2018/3/24.
 */

public class  MainFragment extends BaseFragment {

    private List<String> imageArray;
    private List<String> imageTitle;
    private Banner mBanner;
    private Intent intent;


    @Override
    protected int getResourceId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(View rootView){
        super.initView(rootView);
        //设置图片加载集合
        imageArray=new ArrayList<>();
        imageArray.add("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg");
        imageArray.add("http://img.zcool.cn/community/015cb75718419a32f8758c9b132f6f.jpg");
        imageArray.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521870501036&di=73c47f060ff0987ad15b7a9b40b9f914&imgtype=0&src=http%3A%2F%2Fwww.lsnypt.cn%2Ffile%2Fupload%2F201612%2F16%2F14-53-32-23-1.jpg.thumb.jpg");
        imageArray.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521870435614&di=1723825f7a1cdf0419cef4a547b310a1&imgtype=0&src=http%3A%2F%2Fimg.yzcdn.cn%2Fupload_files%2F2015%2F08%2F15%2FFkh5gcUpCQkxYjCCWYRBNQvzLUJd.jpg%2521730x0.jpg");
        imageArray.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521870483720&di=724e02167ee3c729c25ce003586b234d&imgtype=0&src=http%3A%2F%2Fimg13.360buyimg.com%2Fimgzone%2Fjfs%2Ft145%2F204%2F875023852%2F186430%2F6301044c%2F539bd57fNf56897e3.jpg");


        //设置图片标题集合
        imageTitle=new ArrayList<>();
        imageTitle.add("你好");
        imageTitle.add("我是");
        imageTitle.add("水果");
        imageTitle.add("你好");
        imageTitle.add("我是");


        mBanner = (Banner)rootView.findViewById(R.id.banner);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(imageArray);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.RotateDown);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(imageTitle);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @OnClick({R.id.btn_to_research})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btn_to_research:
                intent = new Intent(getActivity(),ListViewActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }



    private class GlideImageLoader extends ImageLoader {
        public void displayImage(Context context, Object path, ImageView imageView) {
//         Glide 加载图片简单用法
            Glide.with(context).load((String) path).into(imageView);

        }
    }

}