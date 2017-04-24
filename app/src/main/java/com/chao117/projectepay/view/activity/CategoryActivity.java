package com.chao117.projectepay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.base.constant.UIConstant;
import com.chao117.projectepay.base.view.IconView;

public class CategoryActivity extends BaseActivity implements UIConstant {

    //地址选择
    private TextView tvCateLocation;
    //首页搜索框
    private EditText tvCateSearch;
    //搜索按钮
    private TextView btnCateSearch;
    //展示图片资源
    private ImageView imgCateShow;
    //数码产品
    private IconView icvCateDigital;
    //日常衣物
    private IconView icvCateClothe;
    //家电
    private IconView icvCateHousehold;
    //美容
    private IconView icvCateCosmetology;
    //体育用品
    private IconView icvCateSporting;
    //母婴儿童
    private IconView icvCateMaternal;
    //平板电脑
    private IconView icvCateTabletComputer;
    //笔记本电脑
    private IconView icvCateNotebookPc;
    //分类
    private IconView icvCateClassify;
    //消息
    private IconView icvCateNews;
    //发布
    private IconView icvCatePublish;
    //交易
    private IconView icvCateTransaction;
    //我的
    private IconView icvCateMe;
    private LinearLayout activity_main;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initView();
    }

    /**
     * 控件id
     */

    private void initView() {
        tvCateLocation = (TextView) findViewById(R.id.tvCateLocation);
        tvCateSearch = (EditText) findViewById(R.id.tvCateSearch);
        btnCateSearch = (TextView) findViewById(R.id.btnCateSearch);
        imgCateShow = (ImageView) findViewById(R.id.imgCateShow);
        icvCateDigital = (IconView) findViewById(R.id.icvCateDigital);
        icvCateClothe = (IconView) findViewById(R.id.icvCateClothe);
        icvCateHousehold = (IconView) findViewById(R.id.icvCateHousehold);
        icvCateCosmetology = (IconView) findViewById(R.id.icvCateCosmetology);
        icvCateSporting = (IconView) findViewById(R.id.icvCateSporting);
        icvCateMaternal = (IconView) findViewById(R.id.icvCateMaternal);
        icvCateTabletComputer = (IconView) findViewById(R.id.icvCateTabletComputer);
        icvCateNotebookPc = (IconView) findViewById(R.id.icvCateNotebookPc);
        icvCateClassify = (IconView) findViewById(R.id.icvCateClassify);
        icvCateNews = (IconView) findViewById(R.id.icvCateNews);
        icvCatePublish = (IconView) findViewById(R.id.icvCatePublish);
        icvCateTransaction = (IconView) findViewById(R.id.icvCateTransaction);
        icvCateMe = (IconView) findViewById(R.id.icvCateMe);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
        icvCateNews.setOnClickListener(mListener);
        icvCatePublish.setOnClickListener(mListener);
        icvCateTransaction.setOnClickListener(mListener);
        icvCateMe.setOnClickListener(mListener);



    }
private View.OnClickListener mListener=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.icvCateNews:
                intent=new Intent(CategoryActivity.this,NewsActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.icvCatePublish:
                intent=new Intent(CategoryActivity.this,PublishActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.icvCateTransaction:
                intent=new Intent(CategoryActivity.this,TransactionActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.icvCateMe:
                intent=new Intent(CategoryActivity.this,MeActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }
};

}
