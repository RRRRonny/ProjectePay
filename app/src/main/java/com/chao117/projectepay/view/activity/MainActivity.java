package com.chao117.projectepay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.base.view.IconView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.icvMainHome)
    IconView icvMainHome;
    @BindView(R.id.icvMainCategory)
    IconView icvMainCategory;
    @BindView(R.id.icvMainAdd)
    IconView icvMainAdd;
    @BindView(R.id.icvMainMsg)
    IconView icvMainMsg;
    @BindView(R.id.icvMainMe)
    IconView icvMainMe;
    private Fragment homeFragment;
    private Fragment categoryFragment;
    private Fragment msgFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        homeFragment = getSupportFragmentManager().findFragmentById(R.id.fragMainHome);
        categoryFragment = getSupportFragmentManager().findFragmentById(R.id.fragMainCategory);
        msgFragment = getSupportFragmentManager().findFragmentById(R.id.fragMainMsg);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().show(homeFragment).hide(categoryFragment).hide(msgFragment).commit();
    }

    @OnClick({R.id.icvMainHome, R.id.icvMainCategory, R.id.icvMainAdd, R.id.icvMainMsg, R.id.icvMainMe})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.icvMainHome:
                fragmentManager.beginTransaction().show(homeFragment).hide(categoryFragment).hide(msgFragment).commit();
                break;
            case R.id.icvMainCategory:
                fragmentManager.beginTransaction().show(categoryFragment).hide(homeFragment).hide(msgFragment).commit();
                break;
            case R.id.icvMainMsg:
                fragmentManager.beginTransaction().show(msgFragment).hide(categoryFragment).hide(homeFragment).commit();
                break;
            case R.id.icvMainMe:
                jumpPage(MeActivity.class);
                break;
            case R.id.icvMainAdd:
                jumpPage(AddItemActivity.class);
                break;
            default:
                break;
        }
    }

    private void jumpPage(Class target) {
        startActivity(new Intent(this, target));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
