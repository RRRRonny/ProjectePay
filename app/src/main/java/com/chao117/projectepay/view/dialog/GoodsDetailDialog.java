package com.chao117.projectepay.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.model.Goods;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chan on 27/04/2017.
 */

public class GoodsDetailDialog {


    private Context context;
    private AlertDialog.Builder builder;
    private Goods goods;
    private View rootView;
    private TextView tvDiaGoodsBrandDetail;
    private TextView tvDiaGoodsNameDetail;
    private TextView tvDiaGoodsPriceDetail;
    private TextView tvDiaGoodsLocationDetail;
    private TextView tvDiaGoodFav;
    private boolean isFav;
    private int favColor;
    private int unFavColor;
    private Drawable favDrawable;
    private Drawable unFavDrawable;

    public GoodsDetailDialog(Context context, Goods goods) {
        this.context = context;
        this.goods = goods;

        favColor = context.getResources().getColor(R.color.colorFav, null);
        unFavColor = context.getResources().getColor(R.color.colorDivider, null);
        favDrawable = context.getResources().getDrawable(R.mipmap.fav_, null);
        favDrawable.setBounds(0, 0, 32, 32);
        unFavDrawable = context.getResources().getDrawable(R.mipmap.fav, null);
        unFavDrawable.setBounds(0, 0, 32, 32);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootView = inflater.inflate(R.layout.dialog_goods_details, null);
        tvDiaGoodsBrandDetail = (TextView) rootView.findViewById(R.id.tvDiaGoodsBrandDetail);
        tvDiaGoodsNameDetail = (TextView) rootView.findViewById(R.id.tvDiaGoodsNameDetail);
        tvDiaGoodsPriceDetail = (TextView) rootView.findViewById(R.id.tvDiaGoodsPriceDetail);
        tvDiaGoodsLocationDetail = (TextView) rootView.findViewById(R.id.tvDiaGoodsLocationDetail);
        tvDiaGoodFav = (TextView) rootView.findViewById(R.id.tvDiaGoodFav);
        tvDiaGoodFav.setCompoundDrawables(unFavDrawable, null, null, null);
        isFav = false;
        tvDiaGoodFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFav) {
                    Log.v("tag","UN_FAV!!!");
                    tvDiaGoodFav.setCompoundDrawables(unFavDrawable, null, null, null);
                } else {
                    Log.v("tag","FAV!!!");
                    tvDiaGoodFav.setCompoundDrawables(favDrawable, null, null, null);
                }
                isFav = !isFav;
            }
        });
    }

    public void show() {
        builder = new AlertDialog.Builder(context);
        builder.setTitle("商品详情")
                .setView(rootView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create();
        addInfo();
        builder.show();
    }


    private void addInfo() {
        Log.v("de", goods.toString());
        if (goods.getBrand() != null) {
            String brand = goods.getBrand().getName();
            tvDiaGoodsBrandDetail.setText(brand);
        }
        String name = goods.getName();
        String location = goods.getLocation().getName();
        String price = goods.getPrice() + "";
        if (name != null) {
            tvDiaGoodsNameDetail.setText(name);
        }
        tvDiaGoodsPriceDetail.setText(price);
        tvDiaGoodsLocationDetail.setText(location);
    }
}
