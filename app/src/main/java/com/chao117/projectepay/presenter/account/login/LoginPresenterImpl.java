package com.chao117.projectepay.presenter.account.login;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.chao117.projectepay.base.APIHelper;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.GeneralConstant;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.model.User;
import com.chao117.projectepay.view.activity.ILoginView;

/**
 * Created by chan on 17/04/2017.
 */

public class LoginPresenterImpl implements ILoginPresenter, GeneralConstant, APIHelper {
    private ILoginView iLoginView;
    private String json;
    private Context context;


    public LoginPresenterImpl(ILoginView iLoginView, Context context) {
        this.iLoginView = iLoginView;
        this.context = context;
    }

    @Override
    public void clearInputData() {
        iLoginView.onClearInputData();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                //通信成功
                case WHAT_NET_SUCCESS:
                    Log.v("tag", "服务器成功返回数据");
                    ServerResult serverResult = (ServerResult) msg.obj;
                    String result = serverResult.getResult();
                    int errorCode = serverResult.getErrorCode();
                    if (RESULT_SUCCESS.equals(result)) {
                        serverResult = Utils.getAbsoluteServerResult(serverResult, User.class);
                        User user = (User) serverResult.getObjects().get(0);
                        Utils.updateLocalUserInfo(context, user);
                        Log.v("tag", "登录成功,记录登录信息,name:" + Utils.getLocalUserName(context) + "  id:" + Utils.getLocalUserId(context));
                        iLoginView.onDoLogin(true, errorCode);
                    } else {
                        iLoginView.onDoLogin(false, errorCode);
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
    public void doLogin(String account, String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);

        json = Utils.gsonBuilder(user, User.class);
        json = Utils.requestStrBuilder(json);
        String apiURL = Utils.requestURLBuilder(API_TYPE_LOGIN);

        BaseNetThread baseNetThread = new BaseNetThread(handler, apiURL, json);
        new Thread(baseNetThread).start();
    }
}
