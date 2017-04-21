package com.chao117.projectepay.base.constant;

/**
 * Created by chan on 18/04/2017.
 */

public interface ErrorCode {
    int ERROR_NON = 117;//无错误
    int ERROR_NET = 109;//网络错误
    int ERROR_TIME_OUT = 100;//超时
    int ERROR_ILLEGAL = 200;//非法状态
    int ERROR_REFUSE= 12312;//请求被拒绝
    int ERROR_PASSWORD =22222;//密码错误
    int ERROR_USER_EXIST = 111;//用户已经存在
    int ERROR_USER_INEXIST = 12312;//用户不存在
    int ERROR_GOODS_INEXIST = 123;//商品不存在
    int ERROR_OBJECT_INEXIST = 1033;//操作对象不存在
}
