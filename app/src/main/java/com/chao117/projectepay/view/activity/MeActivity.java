package com.chao117.projectepay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.view.IconView;

public class MeActivity extends AppCompatActivity {
    //登录按钮
    private IconView icvMeLogin;
    //设置
    private IconView icvMeSettings;
    //没用
    private TextView textView;
    //下面的五个按钮
    private IconView icvMeClassify;
    private IconView icvMeNews;
    private IconView icvMePublish;
    private IconView icvMeTransaction;
    private IconView icvMe;
    private LinearLayout activity_me;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        initView();
    }

    private void initView() {
        icvMeLogin = (IconView) findViewById(R.id.icvMeLogin);
        icvMeSettings = (IconView) findViewById(R.id.icvMeSettings);
        textView = (TextView) findViewById(R.id.textView);
        icvMeClassify = (IconView) findViewById(R.id.icvMeClassify);
        icvMeNews = (IconView) findViewById(R.id.icvMeNews);
        icvMePublish = (IconView) findViewById(R.id.icvMePublish);
        icvMeTransaction = (IconView) findViewById(R.id.icvMeTransaction);
        icvMe = (IconView) findViewById(R.id.icvMe);
        activity_me = (LinearLayout) findViewById(R.id.activity_me);
        icvMeClassify.setOnClickListener(mListener);
        icvMeNews.setOnClickListener(mListener);
        icvMePublish.setOnClickListener(mListener);
        icvMeTransaction.setOnClickListener(mListener);
    }
    private View.OnClickListener mListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.icvMeClassify:
                    intent=new Intent(MeActivity.this,CategoryActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvMeNews:
                    intent=new Intent(MeActivity.this,NewsActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvMePublish:
                    intent=new Intent(MeActivity.this,PublishActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvMeTransaction:
                    intent=new Intent(MeActivity.this,TransactionActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }

        }
    };
}
