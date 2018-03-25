package cn.demo.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.OnClick;
import cn.demo.R;
import cn.demo.base.BaseActivity;
import cn.demo.ui.fragment.MainFragment;
import cn.demo.ui.fragment.MineFragment;


public class MainActivity extends BaseActivity{

    @Bind(R.id.img_show)
    LinearLayout img_show;
    @Bind(R.id.img_shopping)
    LinearLayout img_shopping;
    @Bind(R.id.img_mine)
    LinearLayout img_mine;

    private FragmentManager fManager;
    private MainFragment mMainFragment ;
    private MainFragment mShopFragment;
    private MineFragment mMineFragment ;


    @Override
    protected int getResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(){
        super.initView();
        fManager = getFragmentManager();//获取分页面ID
        img_show.performClick();   //模拟一次点击，既进去后选择第一项
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

    @OnClick({R.id.img_show,R.id.img_shopping,R.id.img_mine})
    public void onViewClicked(View view){
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);

        switch (view.getId()){
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