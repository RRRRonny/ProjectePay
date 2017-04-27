package com.chao117.projectepay.view.activity;

import com.chao117.projectepay.model.User;

/**
 * Created by chan on 27/04/2017.
 */

public interface IAccountInfoView {
    void onDoRequestInfo(boolean result, int code, User user);

    void onDoModifyInfo(boolean result, int code);
}
