package com.chao117.projectepay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.presenter.account.login.ILoginPresenter;
import com.chao117.projectepay.presenter.account.login.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.edLoginAccount)
    EditText edLoginAccount;
    @BindView(R.id.edLoginPassword)
    EditText edLoginPassword;
    @BindView(R.id.btnLoginLogin)
    Button btnLoginLogin;
    @BindView(R.id.btnLoginRegister)
    Button btnLoginRegister;
    @BindView(R.id.btnLoginClear)
    Button btnLoginClear;

    private ILoginPresenter iLoginPresenter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        iLoginPresenter = new LoginPresenterImpl(this,this);
    }

    @Override
    public void onClearInputData() {
        edLoginAccount.setText("");
        edLoginPassword.setText("");
    }

    @Override
    public void onDoLogin(boolean result, int code) {
        if (result) {
            jumpPage();
        } else {
            iLoginPresenter.clearInputData();
            //// TODO: 18/04/2017 提示是账户还是密码错误
            showToast("账户或者密码错误");
        }
    }

    private void jumpPage() {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.btnLoginLogin, R.id.btnLoginRegister, R.id.btnLoginClear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLoginLogin:
                iLoginPresenter.doLogin(edLoginAccount.getText().toString().trim(), edLoginPassword.getText().toString().trim());
                break;
            case R.id.btnLoginRegister:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.btnLoginClear:
                iLoginPresenter.clearInputData();
                break;
        }
    }
}
