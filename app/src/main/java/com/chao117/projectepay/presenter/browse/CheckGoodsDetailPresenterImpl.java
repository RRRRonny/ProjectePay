package com.chao117.projectepay.presenter.browse;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.chao117.projectepay.base.APIHelper;
import com.chao117.projectepay.base.BaseNetThread;
import com.chao117.projectepay.base.Utils;
import com.chao117.projectepay.base.constant.GeneralConstant;
import com.chao117.projectepay.model.Goods;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.view.ICheckGoodsDetailView;

import java.util.List;

/**
 * Created by chan on 27/04/2017.
 */

public class CheckGoodsDetailPresenterImpl implements ICheckGoodsDetailPresenter, GeneralConstant, APIHelper {
    private Context context;
    private ICheckGoodsDetailView iCheckGoodsDetailView;


    public CheckGoodsDetailPresenterImpl(Context context, ICheckGoodsDetailView iCheckGoodsDetailView) {
        this.context = context;
        this.iCheckGoodsDetailView = iCheckGoodsDetailView;
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
                        List<Goods> goodsList = serverResult.getObjects();
                        Goods goods = goodsList.get(0);
                        iCheckGoodsDetailView.onDoCheckGoodsDetail(goods);
                    } else {
                        Utils.showToast(context, "获取信息错误,错误代码:" + code);
                    }
                    break;
                case WHAT_NET_ERROR:
                    Utils.showToast(context, "网络连接错误,请检查网络连接");
                    break;
                case WHAT_RESPONSE_ILLEGAL:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void doCheckGoodsDetail(int id) {
        Goods goods = new Goods();
        goods.setId(id);
        String json = Utils.gsonBuilder(goods, Goods.class);
        json = Utils.requestStrBuilder(json);
        String apiURL = Utils.requestURLBuilder(APIHelper.API_TYPE_REQ_GOODS_DETAIL);
        BaseNetThread baseNetThread = new BaseNetThread(handler, apiURL, json);
        new Thread(baseNetThread).start();
    }
}
