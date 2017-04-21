package com.chao117.projectepay.presenter.publish;

import com.chao117.projectepay.model.Goods;
import com.chao117.projectepay.model.User;

/**
 * Created by chan on 14/04/2017.
 */

public interface IPublishGoodsPresenter {
    void doCommit(String name,String content,double price);

    void clearInputData();
}
