package com.chao117.projectepay.view.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.model.User;
import com.chao117.projectepay.presenter.account.base.CheckBaseInfoPresenterImpl;
import com.chao117.projectepay.presenter.account.base.ICheckBaseInfoPresenter;
import com.chao117.projectepay.presenter.account.base.IModifyBaseInfoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountInfoActivity extends BaseActivity implements IAccountInfoView {


    @BindView(R.id.containerAccountHeader)
    LinearLayout containerAccountHeader;
    @BindView(R.id.edAccountName)
    EditText edAccountName;
    @BindView(R.id.edAccountGender)
    EditText edAccountGender;
    @BindView(R.id.edAccountBirth)
    EditText edAccountBirth;
    @BindView(R.id.edAccountPsw)
    EditText edAccountPsw;
    @BindView(R.id.ibAccountLock)
    ImageButton ibAccountLock;

    private List<EditText> editTextList;
    private Drawable lockDrawable;
    private Drawable unlockDrawable;
    private int textColorPrimary;
    private int textColorSecondary;
    private boolean isLocked;


    private boolean isInfoChanged;

    private ICheckBaseInfoPresenter iCheckBaseInfoPresenter;
    private IModifyBaseInfoPresenter iModifyBaseInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        editTextList = new ArrayList<>();
        editTextList.add(edAccountBirth);
        editTextList.add(edAccountGender);
        editTextList.add(edAccountName);
        editTextList.add(edAccountPsw);
        lockDrawable = getResources().getDrawable(R.mipmap.lock, null);
        lockDrawable.setBounds(0, 0, 64, 64);
        unlockDrawable = getResources().getDrawable(R.mipmap.unlock, null);
        unlockDrawable.setBounds(0, 0, 64, 64);
        textColorPrimary = getResources().getColor(R.color.textPrimary, null);
        textColorSecondary = getResources().getColor(R.color.textSecondary, null);
        isLocked = true;
        isInfoChanged = false;
        iCheckBaseInfoPresenter = new CheckBaseInfoPresenterImpl(this, this);
        iCheckBaseInfoPresenter.doRequestInfo();
    }

    @Override
    public void onDoRequestInfo(boolean result, int code, User user) {
        if (result) {
            if (user.getBirth() != null) {
                edAccountBirth.setHint(Utils.getTimeString(user.getBirth()));
            }
            edAccountName.setHint(user.getName());
            edAccountGender.setHint(user.getGender());
        } else {
            showToast("获取用户信息失败,错误代码:" + code);
        }
    }

    @Override
    public void onDoModifyInfo(boolean result, int code) {

    }

    @OnClick({R.id.containerAccountHeader, R.id.ibAccountLock})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.containerAccountHeader:
                break;
            case R.id.ibAccountLock:
                if (isLocked) {
                    ibAccountLock.setImageDrawable(unlockDrawable);
                    for (int i = 0; i < editTextList.size(); i++) {
                        editTextList.get(i).setEnabled(true);
                        editTextList.get(i).setHintTextColor(textColorSecondary);
                    }
                } else {
                    ibAccountLock.setImageDrawable(lockDrawable);
                    for (int i = 0; i < editTextList.size(); i++) {
                        editTextList.get(i).setEnabled(false);
                        editTextList.get(i).setHintTextColor(textColorPrimary);
                    }
                }
                isLocked = !isLocked;
                break;
        }
    }
}
