package com.wyz.testandroidapp.net;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.HashMap;

/**
 * Created by wyz on 2017/2/13.
 */

public class HttpUtil {
    public static void doGet(String url, HashMap<String, String> params, Callback callback) {
        OkHttpUtils
                .get()
                .url(url)
                .params(params)
                .build()
                .execute(callback);
    }
}
