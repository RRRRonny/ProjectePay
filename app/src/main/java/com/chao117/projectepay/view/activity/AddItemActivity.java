package com.chao117.projectepay.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.base.view.IconView;
import com.chao117.projectepay.presenter.publish.IPublishGoodsPresenter;
import com.chao117.projectepay.presenter.publish.PublishGoodsPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddItemActivity extends BaseActivity implements IPublishView {


    @BindView(R.id.icvPubSelectImg)
    IconView icvPubSelectImg;
    @BindView(R.id.edAddName)
    EditText edAddName;
    @BindView(R.id.edAddCate)
    EditText edAddCate;
    @BindView(R.id.edAddBrand)
    EditText edAddBrand;
    @BindView(R.id.edAddPrice)
    EditText edAddPrice;
    @BindView(R.id.edAddContent)
    EditText edAddContent;
    @BindView(R.id.cbAddShare)
    CheckBox cbAddShare;
    @BindView(R.id.btnAddItemPublish)
    Button btnAddItemPublish;
    private IPublishGoodsPresenter iPublishGoodsPresenter;
    private List<EditText> editTextList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        iPublishGoodsPresenter = new PublishGoodsPresenterImpl(this, this);
        editTextList = new ArrayList<>();
        editTextList.add(edAddBrand);
        editTextList.add(edAddCate);
        editTextList.add(edAddContent);
        editTextList.add(edAddName);
        editTextList.add(edAddPrice);
    }

    @Override
    public void onDoCommit(boolean result, int code) {
        if (result) {
            showToast(getResources().getString(R.string.add_success));
        } else {
            showToast(getResources().getString(R.string.add_failure) + "," + getResources().getString(R.string.add_failure) + code);
        }

    }

    @Override
    public void onClearInputData() {
        for (int i = 0; i < editTextList.size(); i++) {
            editTextList.get(i).setText("");
        }
    }


    @OnClick({R.id.icvPubSelectImg, R.id.btnAddItemPublish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.icvPubSelectImg:
                break;
            case R.id.btnAddItemPublish:
                //todo 如果分享,启动分享线程
                String name = edAddName.getText().toString().trim();
                double price = Double.valueOf(edAddPrice.getText().toString().trim());
                String content = edAddContent.getText().toString().trim();
                String cate = edAddCate.getText().toString().trim();
                iPublishGoodsPresenter.doCommit(name, content, price);
                break;
        }
    }
}
