package com.chao117.projectepay.test.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.chao117.projectepay.base.APIHelper;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.GeneralConstant;
import com.chao117.projectepay.model.Goods;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.model.User;
import com.chao117.projectepay.test.view.ITestGoodsDetailView;

import java.util.List;

/**
 * Created by chan on 23/04/2017.
 */

public class TestGoodsDeatilPresenterImpl implements ITestGoodsDetailPresenter, GeneralConstant, APIHelper {
    private Context context;
    private ITestGoodsDetailView iTestGoodsDetailView;

    public TestGoodsDeatilPresenterImpl(Context context, ITestGoodsDetailView iTestGoodsDetailView) {
        this.context = context;
        this.iTestGoodsDetailView = iTestGoodsDetailView;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_NET_SUCCESS:
                    ServerResult serverResult = (ServerResult) msg.obj;
                    if (RESULT_SUCCESS.equals(serverResult.getResult())) {
                        serverResult = Utils.getAbsoluteServerResult(serverResult, Goods.class);
                        List<Goods> goodsList = serverResult.getObjects();
                        Goods goods = goodsList.get(0);
                        String name = goods.getName();
                        double price = goods.getPrice();
                        User user = goods.getUser();
                        int id = user.getId();
                        iTestGoodsDetailView.onDoCommit(true, name, id, price);
                    } else {
                        iTestGoodsDetailView.onDoCommit(false, null, -1, 0);
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
    public void doCommit(int id) {
        Goods goods = new Goods();
        goods.setId(id);
        String json = Utils.gsonBuilder(goods, Goods.class);
        json = Utils.requestStrBuilder(json);
        String apiURL = Utils.requestURLBuilder(APIHelper.API_TYPE_REQ_GOODS_DETAIL);
        BaseNetThread baseNetThread = new BaseNetThread(handler, apiURL, json);
        new Thread(baseNetThread).start();
    }
}
