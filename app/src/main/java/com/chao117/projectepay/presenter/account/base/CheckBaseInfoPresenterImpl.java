package com.chao117.projectepay.presenter.account.base;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.chao117.projectepay.base.APIHelper;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.GeneralConstant;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.model.User;
import com.chao117.projectepay.view.activity.IAccountInfoView;

import java.util.List;

/**
 * Created by chan on 27/04/2017.
 */

public class CheckBaseInfoPresenterImpl implements ICheckBaseInfoPresenter, GeneralConstant, APIHelper {
    private Context context;
    private IAccountInfoView iAccountInfoView;

    public CheckBaseInfoPresenterImpl(Context context, IAccountInfoView iAccountInfoView) {
        this.context = context;
        this.iAccountInfoView = iAccountInfoView;
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
                        serverResult = Utils.getAbsoluteServerResult(serverResult, User.class);
                        List<User> users = serverResult.getObjects();
                        User user = users.get(0);
                        iAccountInfoView.onDoRequestInfo(true, code, user);
                    } else {
                        iAccountInfoView.onDoRequestInfo(true, code, null);
                    }
                    break;
                case WHAT_NET_ERROR:
                    Utils.showToast(context, "网络错误");
                    break;
                case WHAT_RESPONSE_ILLEGAL:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void doRequestInfo() {
        User user = new User();
        user.setId(Utils.getLocalUserId(context));
        String json = Utils.gsonBuilder(user, User.class);
        json = Utils.requestStrBuilder(json);
        String apiURL = Utils.requestURLBuilder(APIHelper.API_TYPE_REQ_USER);
        BaseNetThread baseNetThread = new BaseNetThread(handler, apiURL, json);
        new Thread(baseNetThread).start();
    }
}
