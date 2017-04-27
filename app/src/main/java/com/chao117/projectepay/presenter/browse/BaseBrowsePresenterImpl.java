package com.chao117.projectepay.presenter.browse;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.BaseExpandableListAdapter;

import com.chao117.projectepay.base.APIHelper;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.GeneralConstant;
import com.chao117.projectepay.model.Goods;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.view.IBaseBrowseView;

/**
 * Created by chan on 27/04/2017.
 */

public class BaseBrowsePresenterImpl implements IBaseBrowsePresenter, GeneralConstant, APIHelper {
    private Context context;
    private IBaseBrowseView iBaseBrowseView;

    public BaseBrowsePresenterImpl(Context context, IBaseBrowseView iBaseBrowseView) {
        this.context = context;
        this.iBaseBrowseView = iBaseBrowseView;
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
                        serverResult = Utils.getAbsoluteServerResult(serverResult, Goods.class);
                        iBaseBrowseView.onDoBaseBrowse(serverResult.getObjects());
                    } else {
                        Utils.showToast(context, "从服务器获取信息错误,错误代码:" + code);
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
    public void doBrowse() {
        Goods goods = new Goods();
        String json = Utils.gsonBuilder(goods, Goods.class);
        json = Utils.requestStrBuilder(json);
        String apiURL = Utils.requestURLBuilder(API_TYPE_BROWSE);
        BaseNetThread baseNetThread = new BaseNetThread(handler, apiURL, json);
        new Thread(baseNetThread).start();

    }


}
