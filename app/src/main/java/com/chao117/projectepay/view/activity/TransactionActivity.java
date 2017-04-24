package com.chao117.projectepay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.view.IconView;

public class TransactionActivity extends AppCompatActivity {
    //交易页面返回按钮
    private TextView tvTranReturn;
    //交易页面搜索按钮
    private TextView tvTranSearch;
    //买家显示选项按钮
    private TextView tvTranBuy;
    //卖家显示选项按钮
    private TextView tvTranSell;
    //买卖家显示内容
    private ListView lvTranBuy;
    //下面的按钮
    private IconView icvTranClassify;
    private IconView icvTranNews;
    private IconView icvTranPublish;
    private IconView icvTranTransaction;
    private IconView icvTranMe;
    private LinearLayout activity_transaction;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        initView();
    }

    private void initView() {
        tvTranReturn = (TextView) findViewById(R.id.tvTranReturn);
        tvTranSearch = (TextView) findViewById(R.id.tvTranSearch);
        tvTranBuy = (TextView) findViewById(R.id.tvTranBuy);
        tvTranSell = (TextView) findViewById(R.id.tvTranSell);
        lvTranBuy = (ListView) findViewById(R.id.lvTranBuy);
        icvTranClassify = (IconView) findViewById(R.id.icvTranClassify);
        icvTranNews = (IconView) findViewById(R.id.icvTranNews);
        icvTranPublish = (IconView) findViewById(R.id.icvTranPublish);
        icvTranTransaction = (IconView) findViewById(R.id.icvTranTransaction);
        icvTranMe = (IconView) findViewById(R.id.icvTranMe);
        activity_transaction = (LinearLayout) findViewById(R.id.activity_transaction);
        icvTranClassify.setOnClickListener(mListener);
        icvTranNews.setOnClickListener(mListener);
        icvTranPublish.setOnClickListener(mListener);
        icvTranMe.setOnClickListener(mListener);
    }
    private View.OnClickListener mListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.icvTranClassify:
                    intent=new Intent(TransactionActivity.this,CategoryActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvTranNews:
                    intent=new Intent(TransactionActivity.this,NewsActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvTranPublish:
                    intent=new Intent(TransactionActivity.this,PublishActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvTranMe:
                    intent=new Intent(TransactionActivity.this,MeActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }

        }
    };
}
