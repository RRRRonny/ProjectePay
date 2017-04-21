package com.chao117.projectepay.presenter.account.login;

/**
 * Created by chan on 20/04/2017.
 */

public interface IRegisterPresenter {
    void doRegister(String account, String password);

    void clearInputData();
}
