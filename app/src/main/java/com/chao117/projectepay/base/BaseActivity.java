package com.chao117.projectepay.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by chan on 17/04/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
