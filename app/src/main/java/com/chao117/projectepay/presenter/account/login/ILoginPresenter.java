package com.chao117.projectepay.presenter.account.login;

/**
 * Created by chan on 14/04/2017.
 */

public interface ILoginPresenter {
    void clearInputData();
    void doLogin(String account,String password);
}
