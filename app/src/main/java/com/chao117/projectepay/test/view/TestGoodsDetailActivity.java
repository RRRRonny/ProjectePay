package com.chao117.projectepay.test.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.test.presenter.ITestGoodsDetailPresenter;
import com.chao117.projectepay.test.presenter.TestGoodsDeatilPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestGoodsDetailActivity extends BaseActivity implements ITestGoodsDetailView {
    @BindView(R.id.etTestGDId)
    EditText etTestGDId;
    @BindView(R.id.btnTestGDCommit)
    Button btnTestGDCommit;
    @BindView(R.id.tvTestGBName)
    TextView tvTestGBName;
    @BindView(R.id.tvTestGBPrice)
    TextView tvTestGBPrice;
    @BindView(R.id.tvTestGBId)
    TextView tvTestGBId;
    private ITestGoodsDetailPresenter iTestGoodsDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_goods_detail);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        iTestGoodsDetailPresenter = new TestGoodsDeatilPresenterImpl(this, this);
    }

    @Override
    public void onDoCommit(boolean result, String name, int userId, double price) {
        if (result) {
            tvTestGBId.setText(""+userId);
            tvTestGBName.setText(name);
            tvTestGBPrice.setText(Double.valueOf(price).toString());
        }
    }

    @OnClick(R.id.btnTestGDCommit)
    public void onViewClicked() {
        Integer id = new Integer(etTestGDId.getText().toString().trim());
        iTestGoodsDetailPresenter.doCommit(id);
    }
}
