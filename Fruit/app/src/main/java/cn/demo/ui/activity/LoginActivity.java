package cn.demo.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import cn.demo.R;
import cn.demo.base.BaseActivity;

/**
 * Created by Administrator on 2018/3/24.
 */

public class LoginActivity extends BaseActivity{

    private Intent intent;

    @Bind(R.id.top_text)
    TextView mTopText;

    @Override
    protected int getResourceId(){
        return R.layout.activity_login;
    }

    public void initView()
    {
        super.initView();
        mTopText.setText("登录");
    }

    @OnClick({R.id.login_btn,R.id.register_btn,R.id.login_miss})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.login_btn:
                break;
            case R.id.register_btn:
                intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_miss:
                intent = new Intent(this,MissActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
