package com.chao117.projectepay.test.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.chao117.projectepay.base.APIHelper;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.GeneralConstant;
import com.chao117.projectepay.model.Goods;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.test.view.ITestSimpleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chan on 24/04/2017.
 */

public class TestSimplePresenterImpl implements ITestSimplePresenter, GeneralConstant, APIHelper {
    private Context context;
    private ITestSimpleView iTestSimpleView;

    private List<Goods> goodsList;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.v("tag", "接受到 message");
            switch (msg.what) {
                case WHAT_NET_SUCCESS:
                    Log.v("tag", "接受到 success");
                    ServerResult serverResult = (ServerResult) msg.obj;
                    serverResult = Utils.getAbsoluteServerResult(serverResult, Goods.class);
                    goodsList = serverResult.getObjects();
                    List<String> names = new ArrayList<>();
                    List<Double> prices = new ArrayList<>();
                    for (int i = 0; i < goodsList.size(); i++) {
                        names.add(goodsList.get(i).getName());
                        prices.add(goodsList.get(i).getPrice());
                    }
                    iTestSimpleView.onDoCommit(names, prices);
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

    public TestSimplePresenterImpl(Context context, ITestSimpleView iTestSimpleView) {
        this.context = context;
        this.iTestSimpleView = iTestSimpleView;
    }

    @Override
    public void doCommit() {
        String apiUTL = Utils.requestURLBuilder(APIHelper.API_TYPE_BROWSE);
        Goods goods = new Goods();
        String json = Utils.gsonBuilder(goods, Goods.class);
        json = Utils.requestStrBuilder(json);
        BaseNetThread baseNetThread = new BaseNetThread(mHandler, apiUTL, json);
        new Thread(baseNetThread).start();
    }
}
