package com.chao117.projectepay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.UIConstant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MeActivity extends BaseActivity implements UIConstant {

    @BindView(R.id.ivMeHeader)
    ImageView ivMeHeader;
    @BindView(R.id.ivMeSetting)
    ImageView ivMeSetting;
    @BindView(R.id.containerMeAccount)
    LinearLayout containerMeAccount;
    @BindView(R.id.tvMeName)
    TextView tvMeName;
    @BindView(R.id.containerMeMyFollow)
    LinearLayout containerMeMyFollow;
    @BindView(R.id.containerMeMyGoods)
    LinearLayout containerMeMyGoods;
    @BindView(R.id.containerMeMyHistory)
    LinearLayout containerMeMyHistory;
    @BindView(R.id.containerMeMyAuction)
    LinearLayout containerMeMyAuction;
    @BindView(R.id.containerMeMyTrans)
    LinearLayout containerMeMyTrans;
    @BindView(R.id.containerMeMyPackage)
    LinearLayout containerMeMyPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        tvMeName.setText(Utils.getLocalUserName(this));
    }

    @OnClick({R.id.containerMeMyFollow, R.id.containerMeMyGoods, R.id.containerMeMyHistory, R.id.containerMeMyAuction, R.id.containerMeMyTrans, R.id.containerMeMyPackage})
    public void onViewClicked(View view) {
        Intent intent = new Intent(this, GeneralListViewActivity.class);
        switch (view.getId()) {
            case R.id.containerMeMyFollow:
                intent.putExtra(INTENT_GENERAL_TITLE, getResources().getString(R.string.my_follow));
                break;
            case R.id.containerMeMyGoods:
                intent.putExtra(INTENT_GENERAL_TITLE, getResources().getString(R.string.my_goods));
                break;
            case R.id.containerMeMyHistory:
                intent.putExtra(INTENT_GENERAL_TITLE, getResources().getString(R.string.my_history));
                break;
            case R.id.containerMeMyAuction:
                intent.putExtra(INTENT_GENERAL_TITLE, getResources().getString(R.string.my_auction));
                break;
            case R.id.containerMeMyTrans:
                intent.putExtra(INTENT_GENERAL_TITLE, getResources().getString(R.string.my_transaction));
                break;
            case R.id.containerMeMyPackage:
                intent.putExtra(INTENT_GENERAL_TITLE, getResources().getString(R.string.my_package));
                break;
        }
        jumpPage(intent);
    }

    @OnClick(R.id.containerMeAccount)
    public void onViewClicked() {
        jumpPage(new Intent(this, AccountInfoActivity.class));
    }

    private void jumpPage(Intent intent) {
        startActivity(intent);
    }

}
