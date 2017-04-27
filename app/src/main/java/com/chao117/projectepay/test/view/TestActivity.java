package com.chao117.projectepay.test.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chao117.projectepay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.btnTestGoodsDetail)
    Button btnTestGoodsDetail;
    @BindView(R.id.btnTestAddHistory)
    Button btnTestAddHistory;
    @BindView(R.id.btnTestModifyPsw)
    Button btnTestModifyPsw;
    @BindView(R.id.btnTestBrowse)
    Button btnTestBrowse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnTestGoodsDetail, R.id.btnTestAddHistory, R.id.btnTestModifyPsw, R.id.btnTestBrowse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnTestGoodsDetail:
                jumpPage(TestGoodsDetailActivity.class);
                break;
            case R.id.btnTestAddHistory:
                break;
            case R.id.btnTestModifyPsw:
                break;
            case R.id.btnTestBrowse:
                jumpPage(TestSimpleActivity.class);
                break;
        }
    }

    private void jumpPage(Class target) {
        startActivity(new Intent(this, target));
    }


}
