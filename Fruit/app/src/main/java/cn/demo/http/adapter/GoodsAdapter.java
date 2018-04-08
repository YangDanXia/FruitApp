package cn.demo.http.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.demo.R;
import cn.demo.cache.ImageCacheManger;
import cn.demo.http.model.Goods;

import static cn.demo.ui.activity.GoodListActivity.b;

/**
 * Created by Forever on 2018/3/28.
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder>{

    private List<Goods> mGoodsList;
    private LayoutInflater layoutInflater;

    public GoodsAdapter(Context context, List<Goods> goodsList) {
        mGoodsList = goodsList;
        layoutInflater = LayoutInflater.from(context);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_goods, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    //设置图片
    public void onBindViewHolder(ViewHolder holder, int position) {
        Goods goods = mGoodsList.get(position);
//        holder.goodsImage.setImageBitmap(goods.getGoodsPicBitmap());
//        holder.goodsImage.setImageResource(goods.getGoodsPicture());
        holder.goodsName.setText(goods.getGoodsName()); //获得商品的名称
//        ImageCacheManger.loadImage(goods.getGoodsPicture(), holder.goodsImage,
//                b, b);
    }

    public int getItemCount() {
        return mGoodsList.size();
    }


    /**
     * 找到需要放置的内容的位置
     * @params goodsImage 商品的图片
     * @params goodsName 商品的名字
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView goodsImage;
        TextView goodsName;

        public ViewHolder(View view) {
            super(view);
            goodsImage = view.findViewById(R.id.goods_image);
            goodsName = view.findViewById(R.id.goods_name);
        }
    }
}
