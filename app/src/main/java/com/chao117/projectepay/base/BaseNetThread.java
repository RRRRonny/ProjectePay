package com.chao117.projectepay.base;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.chao117.projectepay.base.constant.Constant;
import com.chao117.projectepay.base.constant.NetConstant;
import com.chao117.projectepay.model.ServerResult;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by chan on 17/04/2017.
 */

public class BaseNetThread implements Runnable, Constant, NetConstant {
    protected Handler handler;
    protected String apiURL;
    private HttpURLConnection connection;
    private URL url;
    private String json;

    protected BufferedReader reader;
    protected BufferedWriter writer;

    public BaseNetThread(Handler handler, String apiURL, String json) {
        this.handler = handler;
        this.apiURL = apiURL;
        this.json = json;
        try {
            url = new URL(apiURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            connection = (HttpURLConnection) url.openConnection();
            if (connection != null) {
            }
            connection.setRequestMethod("POST");
            writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            Log.v("tag", json);
            writer.write(json);
            writer.flush();
            writer.close();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String tString = reader.readLine();
            StringBuffer responseString = new StringBuffer();
            while (tString != null) {
                responseString.append(tString);
                tString = reader.readLine();
            }
            Log.v("tag", "读取数据:" + responseString.toString());
//            try {
//                JSONObject jsonObject = new JSONObject(responseString.toString());
//                Message message = new Message();
//                message.what = WHAT_NET_SUCCESS;
//                message.obj = jsonObject;
//                //传出 json 串
//                handler.sendMessage(message);
//            } catch (JSONException e) {
//                //json 解析异常
//                handler.sendEmptyMessage(WHAT_RESPONSE_ILLEGAL);
//                e.printStackTrace();
//            }
            ServerResult serverResult = new Gson().fromJson(responseString.toString(), ServerResult.class);
            Message msg = new Message();
            msg.what = WHAT_NET_SUCCESS;
            msg.obj = serverResult;
            handler.sendMessage(msg);
        } catch (IOException e) {
            handler.sendEmptyMessage(WHAT_NET_ERROR);
            e.printStackTrace();
        }
    }
}

