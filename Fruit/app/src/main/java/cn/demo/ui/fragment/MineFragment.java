package cn.demo.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import cn.demo.R;
import cn.demo.base.BaseFragment;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.demo.ui.activity.LoginActivity;

/**
 * Created by Administrator on 2018/3/24.
 */

public class MineFragment extends BaseFragment
{

    private Intent intent;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.user_login,R.id.user_signIn,R.id.user_redeem,R.id.user_orders,R.id.user_afterSale,
              R.id.user_address,R.id.user_account,R.id.user_dreamTree,R.id.user_footprint,R.id.user_suggestion})
    public void onViewClicked(View view){
        switch(view.getId()){
            case R.id.user_login:
                intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.user_signIn:
                break;
            case R.id.user_redeem:
                break;
            case R.id.user_orders:
                break;
            case R.id.user_afterSale:
                break;
            case R.id.user_address:
                break;
            case R.id.user_account:
                break;
            case R.id.user_dreamTree:
                break;
            case R.id.user_footprint:
                break;
            case R.id.user_suggestion:
                break;
            default:
                break;
        }
    }



}