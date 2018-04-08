package cn.demo.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import cn.demo.R;
import cn.demo.base.BaseActivity;
import cn.demo.http.HttpUtil;
import cn.demo.http.model.Goods;
import cn.demo.http.model.Result;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/3/24.
 */

public class LoginActivity extends BaseActivity{

    private Intent intent;
    private static  int UPDATE_TEXT = 1;
    public static List<Goods> goodsList = new ArrayList<>();

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
                intent = new Intent(this,GoodListActivity.class);
                startActivity(intent);
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

    public void login() {
//        EditText username = findViewById(R.id.login_phone);
//        EditText password = findViewById(R.id.login_pass);
//        Map<String, String> map = new HashMap<String, String>();
//
//        String name = username.getText().toString();
//        String pwd = password.getText().toString();
//        map.put("userId", name);
//        map.put("userPwd",pwd);
//
//        HttpUtil.postDataWithParame("http://10.0.2.2:8080/Test/LoginServlet", map, new okhttp3.Callback() {
//
//            public void onResponse(Call call, Response response) throws IOException {
//                String responseDate = response.body().string();
//                Gson gson = new Gson();
//                Result result =  gson.fromJson(responseDate,Result.class);
//
//                if (result.getCode()==200){
//                    UPDATE_TEXT = 1;
//                }else {
//                    UPDATE_TEXT = 0;
//                }
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Message message = new Message();
//                        message.what = UPDATE_TEXT;
//                        handler.sendMessage(message);
//                    }
//                }).start();
//            }
//
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//        });

        initGoods();
        Intent intent = new Intent(LoginActivity.this, GoodListActivity.class);
        startActivity(intent);
    }

    private void initGoods() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "haiqian");

        HttpUtil.postDataWithParame("http://10.0.2.2:8080/Test/GoodsList", map, new okhttp3.Callback() {

            public void onResponse(Call call, Response response) throws IOException {
                String responseDate = response.body().string();
                Gson gson = new Gson();
                Result result =  gson.fromJson(responseDate,Result.class);
                for (int i=0; i<result.getGoods().size(); i++) {
                    Goods goods = new Goods(result.getGoods().get(i).getGoodsName(),result.getGoods().get(i).getgoodsImage() );
                    goodsList.add(goods);
                }
            }
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }

}
