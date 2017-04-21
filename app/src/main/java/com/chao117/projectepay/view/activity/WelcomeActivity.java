package com.chao117.projectepay.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.Constant;
import com.chao117.projectepay.model.User;

public class WelcomeActivity extends AppCompatActivity implements Constant {


    private Intent intent;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
        next();
    }

    private void init() {
    }

    private void next() {
        //判断是否需要登录
        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        if (preferences.getBoolean(PRE_IS_LOGIN, false)) {
            jumpPage(MainActivity.class);
        } else {
            jumpPage(LoginActivity.class);
        }
    }


    private void jumpPage(Class target) {
        intent = new Intent(this, target);
        startActivity(intent);
    }
}
