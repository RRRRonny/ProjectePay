package com.chao117.projectepay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.UIConstant;
import com.chao117.projectepay.model.Follow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GeneralListViewActivity extends BaseActivity implements IGeneralListViewView, UIConstant {

    @BindView(R.id.tvGeneralTitle)
    TextView tvGeneralTitle;
    @BindView(R.id.layGeneralListView)
    ListView layGeneralListView;
    private Intent intent;
    private String title;
    private List datas;
    private int localUserId;


    private final String FOLLOW = "我的收藏";
    private final String GOODS = "我上架的";
    private final String HISTORY = "浏览历史";
    private final String AUCTION = "我竞拍的";
    private final String TRANSACTION = "我的交易";
    private final String PACKAGE = "我的物流";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_list_view);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        intent = getIntent();
        title = intent.getStringExtra(INTENT_GENERAL_TITLE);
        tvGeneralTitle.setText(title);
        datas = new ArrayList();
        localUserId = Utils.getLocalUserId(this);
        switch (title) {
            case FOLLOW:
                break;
            case GOODS:
                break;
            case HISTORY:
                break;
            case AUCTION:
                break;
            case TRANSACTION:
                break;
            case PACKAGE:
                break;
            default:
                showToast("未知错误");
                break;

        }
    }

}
