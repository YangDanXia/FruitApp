package cn.demo.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import cn.bingoogolapple.baseadapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.demo.App;
import cn.demo.R;
import cn.demo.engine.Engine;
import cn.demo.model.RefreshModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListViewActivity extends AppCompatActivity{
    private ListView mContentLv;
    private ContentAdapter mContentAdapter;

    private Engine mEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mContentLv = findViewById(R.id.lv_content);
        mEngine = App.getInstance().getEngine();

        initListView();
        loadContentData();
    }

    /**
     * 初始化ListView
     */
    private void initListView() {
        mContentAdapter = new ContentAdapter(this);
        mContentLv.setAdapter(mContentAdapter);
    }




    /**
     * 加载内容列表数据
     */
    private void loadContentData() {
//        获取json格式的数据
        mEngine.loadContentData("http://7xk9dj.com1.z0.glb.clouddn.com/refreshlayout/api/defaultdata.json").enqueue(new Callback<List<RefreshModel>>() {

            @Override
            public void onResponse(Call<List<RefreshModel>> call, Response<List<RefreshModel>> response) {
                mContentAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<RefreshModel>> call, Throwable t) {
                Toast.makeText(App.getInstance(), "加载内容数据失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class ContentAdapter extends BGAAdapterViewAdapter<RefreshModel> {

        public ContentAdapter(Context context) {
            super(context, R.layout.item_normal);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, RefreshModel model) {
            helper.setText(R.id.tv_item_normal_title, model.title).setText(R.id.tv_item_normal_detail, model.detail);
        }
    }
}
