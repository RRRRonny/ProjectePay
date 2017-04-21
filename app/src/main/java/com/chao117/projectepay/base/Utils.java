package com.chao117.projectepay.base;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.constant.Constant;
import com.chao117.projectepay.base.constant.ErrorCode;
import com.chao117.projectepay.base.constant.NetConstant;
import com.chao117.projectepay.model.ServerResult;
import com.chao117.projectepay.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chan on 19/04/2017.
 */

public class Utils implements APIHelper, NetConstant, ErrorCode, Constant {
    /**
     * 生成 BaseNetThread 所需的 json 串
     *
     * @param jsonString json串
     * @return
     */
    public static String requestStrBuilder(String jsonString) {
        StringBuffer requestStr = new StringBuffer();
        requestStr.append(JSON);
        requestStr.append("=");
        requestStr.append(jsonString);
        return requestStr.toString();
    }

    /**
     * 生成 BaseNetThread 所需的 json 串
     *
     * @param jsonObject json 对象
     * @return
     */
    public static String requestStrBuilder(JSONObject jsonObject) {
        StringBuffer requestStr = new StringBuffer();
        requestStr.append(JSON);
        requestStr.append("=");
        requestStr.append(jsonObject.toString());
        return requestStr.toString();
    }

    /**
     * 生成 api 请求地址
     *
     * @param apiType APIHelper 中的api 类型
     * @return
     */
    public static String requestURLBuilder(String apiType) {
        return API_URL_ + "/" + apiType;
    }

    /**
     * 用 gson 生成 json
     *
     * @param object      对象
     * @param targetClass 对象的类型
     * @return
     */
    public static String gsonBuilder(Object object, Class targetClass) {
        Gson gson = new Gson();
        String json = gson.toJson(object, targetClass);
        return json;
    }

    /**
     * 用 gson 解析 json, 生成实体类
     *
     * @param json
     * @param targetClass
     * @return
     */
    public static Object objectBuilder(String json, Class targetClass) {
        Object object = new Gson().fromJson(json, targetClass);
        return object;
    }

    /**
     * 用 toast 显示错误代码
     *
     * @param context
     * @param errorCode
     */
    public static void showErrorToast(Context context, int errorCode) {
        switch (errorCode) {
            case ERROR_NON:
                break;
        }
        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
    }

    /**
     * 更新 preferences 中的用户信息
     *
     * @param context
     * @param user
     */
    public static void updateLocalUserInfo(Context context, User user) {
        SharedPreferences preferences;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PRE_USER_ID, user.getId()).commit();
        editor.putString(PRE_USER_NAME, user.getName()).commit();
    }


    /**
     * 获取 preferences 中的用户 id 信息
     *
     * @param context
     * @return
     */
    public static int getLocalUserId(Context context) {
        SharedPreferences preferences;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        int id = preferences.getInt(PRE_USER_ID, -1);
        return id;
    }

    /**
     * 获取 preferences 中的用户昵称
     *
     * @param context
     * @return
     */
    public static String getLocalUserName(Context context) {
        SharedPreferences preferences;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        String name = preferences.getString(PRE_USER_NAME, context.getResources().getString(R.string.local_def_name));
        return name;
    }

    /**
     * 得到正确的 ServerResult
     *
     * @param serverResult 待处理的 ServerResult
     * @param cls          目标类型
     * @param <T>          目标类型
     * @return
     */
    public static <T> ServerResult<T> getAbsoluteServerResult(ServerResult serverResult, Class<T> cls) {
        String string = new Gson().toJson(serverResult.getObjects());
        List<T> tList = new ArrayList<>();
        JsonArray jsonArray = new JsonParser().parse(string).getAsJsonArray();
        for (JsonElement ele : jsonArray) {
            T ob = new Gson().fromJson(ele, cls);
            tList.add(ob);
        }
        serverResult.setObjects(tList);
        return serverResult;
    }
}
