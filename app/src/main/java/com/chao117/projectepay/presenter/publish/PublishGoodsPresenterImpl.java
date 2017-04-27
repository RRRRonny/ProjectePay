package com.chao117.projectepay.presenter.publish;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.chao117.projectepay.base.APIHelper;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.Constant;
import com.chao117.projectepay.base.constant.GeneralConstant;
import com.chao117.projectepay.model.Goods;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.model.User;
import com.chao117.projectepay.view.activity.IPublishView;
import com.google.gson.Gson;

/**
 * Created by chan on 20/04/2017.
 */

public class PublishGoodsPresenterImpl implements IPublishGoodsPresenter, GeneralConstant, APIHelper {
    private IPublishView iPublishView;
    private Goods goods;
    private Context context;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_NET_SUCCESS:
                    ServerResult serverResult = (ServerResult) msg.obj;
                    String result = serverResult.getResult();
                    int code = serverResult.getErrorCode();
                    if (RESULT_SUCCESS.equals(result)) {
                        iPublishView.onDoCommit(true, code);
                    } else {
                        iPublishView.onDoCommit(false, code);
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

    public PublishGoodsPresenterImpl(Context context, IPublishView iPublishView) {
        this.iPublishView = iPublishView;
        this.context = context;
    }


    @Override
    public void doCommit(String name, String content, double price) {
        goods = new Goods();
        User user = new User();
        user.setId(Utils.getLocalUserId(context));
        goods.setUser(user);
        goods.setName(name);
        goods.setRemark(content);
        goods.setPrice(price);

        String json = new Gson().toJson(goods, Goods.class);
        json = Utils.requestStrBuilder(json);
        String apiURL = Utils.requestURLBuilder(API_TYPE_PUBLISH);
        BaseNetThread baseNetThread = new BaseNetThread(handler, apiURL, json);
        new Thread(baseNetThread).start();
    }

    @Override
    public void clearInputData() {
        iPublishView.onClearInputData();
    }
}
