package com.chao117.projectepay.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.model.Goods;
import com.chao117.projectepay.presenter.publish.IPublishGoodsPresenter;
import com.chao117.projectepay.presenter.publish.PublishGoodsPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PublishActivity extends BaseActivity implements IPublishView {
    @BindView(R.id.edLayPubName)
    EditText edLayPubName;
    @BindView(R.id.edLayPubContent)
    EditText edLayPubContent;
    @BindView(R.id.edLayPubPrice)
    EditText edLayPubPrice;
    @BindView(R.id.btnLayPubCommit)
    Button btnLayPubCommit;
    private IPublishGoodsPresenter iPublishGoodsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_publish);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        iPublishGoodsPresenter = new PublishGoodsPresenterImpl(this, this);
    }

    @Override
    public void onDoCommit(boolean result, int code) {
        if (result) {
            showToast("发布成功");
        } else {
            showToast("发布失败,错误代码:" + code);
        }
    }

    @Override
    public void onClearInputData() {
        edLayPubContent.setText("");
        edLayPubName.setText("");
        edLayPubPrice.setText("");
    }

    @OnClick(R.id.btnLayPubCommit)
    public void onViewClicked() {
        iPublishGoodsPresenter.doCommit(edLayPubName.getText().toString().trim(), edLayPubContent.getText().toString().trim(), Long.valueOf(edLayPubPrice.getText().toString()));
    }
}
