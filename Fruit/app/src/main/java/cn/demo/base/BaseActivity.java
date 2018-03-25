package cn.demo.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import cn.demo.R;
import cn.demo.ui.activity.MainActivity;

/**
 * Created by Administrator on 2018/3/25.
 */

public abstract class BaseActivity extends AppCompatActivity{

//    LinkedList其实就是链表,可以模拟链式队列，链式堆栈等数据结构
    static List<Activity> mActivities = new LinkedList<>();
    protected Bundle savedInstanceState; // 保存状态
    private static long mPreTime;
    private static Activity mCurrentActivity; // 当前所在页面

    /**
     * 获取布局界面
     * @return
     */
    protected abstract int getResourceId();


    /**
     * 返回当前所在页面
     * @return
     */
    public static Activity getmCurrentActivity(){
        return mCurrentActivity;
    }


    /**
     *  初始化数据
     */
    public void initData(){ }


    /**
     * 初始化view
     */
    public void initView(){ }

    @Override
    public final void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        //      synchronized关键字用来给对象和方法或者代码块加锁；
//      当它锁定一个方法或者一个代码块的时候，同一时刻最多只有一个线程执行这段代码
        synchronized (mActivities)
        {
//          初始化的时候将其添加到集合中
            mActivities.add(this);
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设置Activity不允许横屏
        setContentView(getResourceId());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    /**
     *  在页面展示时调用
     */
    @Override
    protected void onResume()
    {
        super.onResume();
        mCurrentActivity = this;
    }

    /**
     * 当页面被隐藏时调用
     */
    @Override
    protected void onPause()
    {
        super.onPause();
        mCurrentActivity = null;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        synchronized(mActivities){
            mActivities.remove(this);
        }
    }

    /**
     * 统一退出控制
     */
    @Override
    public void onBackPressed()
    {
        if (mCurrentActivity instanceof MainActivity)
        {
            //如果是主页面
            if (System.currentTimeMillis() - mPreTime > 2000)
            {
                Toast.makeText(this, "再次按返回键关闭", Toast.LENGTH_SHORT).show();
                mPreTime = System.currentTimeMillis();
                return;
            }
        }
        super.onBackPressed();// finish()
    }
}
