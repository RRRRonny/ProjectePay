package com.chao117.projectepay.presenter.account.login;

import android.os.Handler;
import android.os.Message;

import com.chao117.projectepay.base.APIHelper;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.GeneralConstant;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.model.User;
import com.chao117.projectepay.view.activity.IRegisterView;


/**
 * Created by chan on 20/04/2017.
 */

public class RegisterImpl implements IRegisterPresenter, GeneralConstant, APIHelper {
    private IRegisterView iRegisterView;
    private String json;


    public RegisterImpl(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_NET_SUCCESS:
                    ServerResult serverResult = (ServerResult) msg.obj;
                    String result = serverResult.getResult();
                    int code = serverResult.getErrorCode();
                    if (RESULT_SUCCESS.equals(result)) {
                        iRegisterView.onDoRegister(true, code);
                    } else {
                        iRegisterView.onDoRegister(false, code);
                    }
                    break;
                case WHAT_NET_ERROR:
                    break;
                case WHAT_RESPONSE_ILLEGAL:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void doRegister(String account, String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        json = Utils.gsonBuilder(user, User.class);
        json = Utils.requestStrBuilder(json);
        String apiURL = Utils.requestURLBuilder(API_TYPE_REGISTER);
        BaseNetThread baseNetThread = new BaseNetThread(handler, apiURL, json);
        new Thread(baseNetThread).start();
    }

    @Override
    public void clearInputData() {
        iRegisterView.onClearInputData();
    }
}
