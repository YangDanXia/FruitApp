package cn.demo.ui.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.demo.R;
import cn.demo.base.BaseActivity;
import cn.demo.http.adapter.GoodsAdapter;
import cn.demo.http.model.Goods;

import static cn.demo.ui.activity.LoginActivity.goodsList;


public class GoodListActivity extends BaseActivity {

    public static Bitmap b;

    @Override
    protected int getResourceId() {
        return R.layout.activity_goodlist;
    }


    public void initView()
    {
        super.initView();
        b = getBitmapFromResources(this, R.drawable.ic_launcher);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        List<Goods> dataList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Goods data = new Goods("商品名称", "商品图片.jpg");
            dataList.add(data);
        }
        GoodsAdapter adapter = new GoodsAdapter(this,dataList);
        recyclerView.setAdapter(adapter);
    }


    public static Bitmap getBitmapFromResources(Activity act, int resId) {
        Resources res = act.getResources();
        return BitmapFactory.decodeResource(res, resId);
    }
}

