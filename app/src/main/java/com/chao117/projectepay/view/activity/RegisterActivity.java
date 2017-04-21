package com.chao117.projectepay.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.presenter.account.login.IRegisterPresenter;
import com.chao117.projectepay.presenter.account.login.RegisterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements IRegisterView {

    @BindView(R.id.edRegAccount)
    EditText edRegAccount;
    @BindView(R.id.edRegPassword)
    EditText edRegPassword;
    @BindView(R.id.btnRegRegister)
    Button btnRegRegister;
    @BindView(R.id.btnRegClear)
    Button btnRegClear;


    private IRegisterPresenter iRegisterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        iRegisterPresenter = new RegisterImpl(this);
    }

    @Override
    public void onDoRegister(boolean result, int code) {
        if (result) {
            showToast("注册成功");
        } else {
            showToast("注册失败,错误代码为:" + code);
        }
    }

    @Override
    public void onClearInputData() {
        edRegAccount.setText("");
        edRegPassword.setText("");
    }

    @OnClick({R.id.btnRegRegister, R.id.btnRegClear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnRegRegister:
                iRegisterPresenter.doRegister(edRegAccount.getText().toString().trim(), edRegPassword.getText().toString().trim());
                break;
            case R.id.btnRegClear:
                iRegisterPresenter.clearInputData();
                break;
        }
    }
}
