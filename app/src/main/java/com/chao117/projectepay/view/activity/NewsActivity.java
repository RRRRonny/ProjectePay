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

import static com.chao117.projectepay.R.id.icvNews;

public class NewsActivity extends AppCompatActivity {
    //消息页面返回按钮
    private TextView tvNewsReturn;
    //搜索按钮
    private TextView tvNewsSearch;
    //显示的ListView
    private ListView lvNewsShow;
    //下面的五个按钮
    private IconView icvNewsClassify;
    private IconView icvNews;
    private IconView icvNewsPublish;
    private IconView icvNewsTransaction;
    private IconView icvNewsMe;
    private LinearLayout activity_news;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
    }

    private void initView() {
        tvNewsReturn = (TextView) findViewById(R.id.tvNewsReturn);
        tvNewsSearch = (TextView) findViewById(R.id.tvNewsSearch);
        lvNewsShow = (ListView) findViewById(R.id.lvNewsShow);
        icvNewsClassify = (IconView) findViewById(R.id.icvNewsClassify);
        icvNews = (IconView) findViewById(R.id.icvNews);
        icvNewsPublish = (IconView) findViewById(R.id.icvNewsPublish);
        icvNewsTransaction = (IconView) findViewById(R.id.icvNewsTransaction);
        icvNewsMe = (IconView) findViewById(R.id.icvNewsMe);
        activity_news = (LinearLayout) findViewById(R.id.activity_news);
        icvNewsClassify.setOnClickListener(mListener);
        icvNewsPublish.setOnClickListener(mListener);
        icvNewsTransaction.setOnClickListener(mListener);
        icvNewsMe.setOnClickListener(mListener);
    }

    private View.OnClickListener mListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.icvNewsClassify:
                    intent=new Intent(NewsActivity.this,CategoryActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvNewsPublish:
                    intent=new Intent(NewsActivity.this,PublishActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvNewsTransaction:
                    intent=new Intent(NewsActivity.this,TransactionActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.icvNewsMe:
                    intent=new Intent(NewsActivity.this,MeActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }

        }
    };
}
