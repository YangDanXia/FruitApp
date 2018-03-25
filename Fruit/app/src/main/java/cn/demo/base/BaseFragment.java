package cn.demo.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/25.
 */

public abstract class BaseFragment extends Fragment {


    private View rootView; // 布局
    protected Activity mActivity;
    protected boolean isUIVisible; // UI是否被用户看见
    protected boolean isUICreated; // UI是否已被初始化完成


    /**
     * 懒加载方案：使用getUserVisibleHint()与setUserVisibleHint()这两个方法，实现加载延迟，提高用户体验。
     * 当fragment被用户可见时，setUserVisibleHint()会调用且传入true值；
     * 当fragment不被用户可见时，setUserVisibleHint()则得到false值。
     * 当页面切换时就执行setUserVisibleHint()方法
     * @param isVisibleToUser
     */
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            isUIVisible = true;
            loadingData();
        }else{
            isUIVisible = false;
        }
    }

    /**
     * 载入数据
     * 如果界面可被用户看见且初始化已完成则载入数据
     */
    private void loadingData(){
        if(isUICreated && isUIVisible){
            initData();
            isUIVisible = false;
            isUICreated = false;
        }
    }

    /**
     * 获取布局界面
     * @return
     */
    protected abstract int getResourceId();


    /**
     *  初始化数据
     */
    public void initData(){ }


    /**
     * 初始化view
     * @param rootView
     */
    public void initView(View rootView){ }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * LayoutInfalter经常用于加载视图.
     * 当按到home键退出或者进程被意外kill时，使用savedInstanceState就可以在再次打开应用时恢复原来的状态。
     * @param inflater
     * @param container
     * @param saveInstanceState：状态保存
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
//      @LayoutRes int resource  资源文件的ID
//      @Nullable ViewGroup root  待加载的View的父布局
//      boolean attachToRoot    是否加载到父布局中
        rootView = inflater.inflate(getResourceId(),container,false);
        ButterKnife.bind(this,rootView);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        isUICreated = true;
        loadingData();
    }

    /**
     * 当Fragment与Activity发生关联时调用。
     * @param context
     */
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        mActivity = (Activity) context;
    }


    /**
     * 与onCreateView相对应，当该Fragment的视图被移除时调用
     */
    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        isUICreated = false;
        isUIVisible = false;
        ButterKnife.unbind(this);
    }

    /**
     * 与onAttach相对应，当Fragment与Activity关联被取消时调用
     */
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        rootView = null;
    }
}
