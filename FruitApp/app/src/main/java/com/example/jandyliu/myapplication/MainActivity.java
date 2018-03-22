package com.example.jandyliu.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jandyliu.myapplication.MainFragment;
import com.example.jandyliu.myapplication.MineFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //UI Object
   //private TextView txt_topbar;
    private LinearLayout img_show;
    private LinearLayout img_shopping;
    private LinearLayout img_mine;

   // private FrameLayout ly_content;

    //Fragment Object

    private FragmentManager fManager;
    private MainFragment mMainFragment ;
    private MainFragment mShopFragment;
    private MineFragment mMineFragment ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();//获取分页面ID
        bindViews();//事件绑定
        img_show.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        img_show = (LinearLayout)findViewById(R.id.img_show);

        img_shopping = (LinearLayout) findViewById(R.id.img_shopping);
        img_mine = (LinearLayout) findViewById(R.id.img_mine);
        //ly_content = (FrameLayout) findViewById(R.id.ly_content);

        img_show.setOnClickListener(this);
        img_shopping.setOnClickListener(this);
        img_mine.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected(){
        img_show.setSelected(false);
        img_shopping.setSelected(false);
        img_mine.setSelected(false);

    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(mMineFragment != null)fragmentTransaction.hide(mMineFragment);
        if(mShopFragment != null)fragmentTransaction.hide(mShopFragment);
        if(mMainFragment != null)fragmentTransaction.hide(mMainFragment);

    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);

        switch (v.getId()){
            case R.id.img_show:
                setSelected();
                img_show.setSelected(true);
                if(mMainFragment == null){
                    mMainFragment = new MainFragment();
                    fTransaction.add(R.id.ly_content,mMainFragment);
                }else{
                    fTransaction.show(mMainFragment);
                }
                break;
            case R.id.img_shopping:
                setSelected();
                img_shopping.setSelected(true);
                if(mShopFragment == null){
                    mShopFragment = new MainFragment();
                    fTransaction.add(R.id.ly_content,mShopFragment);
                }else{
                    fTransaction.show(mShopFragment);
                }
                break;

            case R.id.img_mine:
                setSelected();
                img_mine.setSelected(true);
                if(mMineFragment == null){
//                    mMineFragment = new MyFragment("第一个Fragment");
                    mMineFragment = new MineFragment();
                    fTransaction.add(R.id.ly_content, mMineFragment);

                }else{
                    fTransaction.show(mMineFragment);
                }
                break;

        }
        fTransaction.commit();
    }
}