package com.chao117.projectepay.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.model.Goods;

import java.util.List;

/**
 * Created by chan on 27/04/2017.
 */

public class GoodsDetailsAdapter extends BaseAdapter {
    private Context context;
    private List<Goods> goodsList;
    private LayoutInflater inflater;

    public GoodsDetailsAdapter(Context context, List<Goods> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return goodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_item_goods_detail, null);
            holder = new Holder();
            holder.pic = (ImageView) convertView.findViewById(R.id.layItemGoodsPic);
            holder.name = (TextView) convertView.findViewById(R.id.layItemGoodsName);
            holder.other = (TextView) convertView.findViewById(R.id.layItemGoodsOther);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        ///todo 获取图片
        holder.name.setText(goodsList.get(position).getName());
        String price = Double.valueOf(goodsList.get(position).getPrice()).toString();
        holder.other.setText(price);
        return convertView;
    }

    class Holder {
        ImageView pic;
        TextView name;
        TextView other;
    }
}
