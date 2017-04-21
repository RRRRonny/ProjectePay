package com.chao117.projectepay.model;

import java.util.List;

/**
 * Created by chan on 19/04/2017.
 */

public class  ServerResult<T> {
    private String result;//使用 APIHelper 中的常量
    private int errorCode;//返回的错误代码
    private List<T> objects;//返回的操作类


    public ServerResult() {
    }

    public ServerResult(String result, int errorCode, List<T> objects) {
        this.result = result;
        this.errorCode = errorCode;
        this.objects = objects;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "ServerResult{" +
                "result='" + result + '\'' +
                ", errorCode=" + errorCode +
                ", objects=" + objects +
                '}';
    }
}
