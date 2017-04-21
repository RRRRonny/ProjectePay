package com.chao117.projectepay.base;

import com.chao117.projectepay.base.constant.DatabaseField;

/**
 * Created by chan on 19/04/2017.
 * api 助手,使用 epay api 必须实现该接口,该接口内有所有 api 的请求码, json 字段和必要的字段值
 */

public interface APIHelper extends DatabaseField {
    //服务器通信用标记
    String JSON = "json";
    String REQUEST_CODE = "requestCode";

    //返回 json 串必须有的类型
    String KIND = "kind";
    String ERROR_CODE = "errorCode";
    String RESULT = "result";


    String FIELD_WHAT = "what";

    String OBJECT = "object";
    String OBJECT_ARRY = "objectArray";

    //kind
    String KIND_OBJ = "kindObj";
    String KIND_ARR = "kindArr";

    //result
    String RESULT_SUCCESS = "resultSuccess";
    String RESULT_FAILURE = "resultFailure";

    //请求的 api 功能
    String API_TYPE_TEST = "test";
    String API_TYPE_LOGIN_BAK = "loginbak";
    //api 2.0:使用 ServerResult 返回结果
    String API_TYPE_LOGIN = "login";
    String API_TYPE_REGISTER = "register";
    String API_TYPE_PUBLISH = "publish";

    String API_TYPE_CHECK_USER = "forUser";

    //2017年04月21日10:55:46
    String API_TYPE_BROWSE = "simpleBrowse";                //简单浏览
    String API_TYPE_PASSWORD = "password";                  //修改密码
    String API_TYPE_FAV = "fav";                            //收藏商品
    String API_TYPE_REQUEST_TRANSACTION = "transRequest";   //请求交易
    String API_TYPE_ACCEPT_TRANSACTION = "transAccept";     //接受交易
    String API_TYPE_CANCEL_TRANSACTION = "transCancel";     //取消交易
    String API_TYPE_CHECK_TRANSACTION = "transCheck";       //查看交易状态
    String API_TYPE_UPDATE_TRANSACTION = "transUpdate";     //更新交易状态

    String API_TYPE_

    String API_TYPE_SEARCH_GOODS = "searchGoods";           //搜索商品
    String API_TYPE_REQUEST_MSGS = "requestMessages";       //请求 message 信息
    String API_TYPE_PUBLISH_MSG = "publishMessage";         //发布留言
}
