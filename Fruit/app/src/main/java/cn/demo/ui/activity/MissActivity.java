package cn.demo.ui.activity;

import android.widget.TextView;

import butterknife.Bind;
import cn.demo.R;
import cn.demo.base.BaseActivity;

/**
 * Created by Administrator on 2018/3/25.
 */

public class MissActivity extends BaseActivity {

    @Bind(R.id.top_text)
    TextView mTopText;

    @Override
    protected int getResourceId() {
        return R.layout.activity_miss;
    }

    public void initView()
    {
        super.initView();
        mTopText.setText("重置密码");
    }
}
