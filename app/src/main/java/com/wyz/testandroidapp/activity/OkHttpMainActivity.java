package com.wyz.testandroidapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wyz.testandroidapp.R;
import com.wyz.testandroidapp.net.HttpUtil;
import com.wyz.testandroidapp.utils.CommonUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/1/19.
 */
public class OkHttpMainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "wyz";
    String url = "http://www.csdn.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_okhttp);

        init();
    }

    private void init() {
        Button btn_get = (Button) findViewById(R.id.btn_get);
        Button btn_post = (Button) findViewById(R.id.btn_post);
        Button btn_one = (Button) findViewById(R.id.btn_one_ok);
        Button btn_two = (Button) findViewById(R.id.btn_two_ok);
        btn_get.setOnClickListener(this);
        btn_post.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
    }

    private void doGet()
    {
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        CommonUtils.showToast(OkHttpMainActivity.this, "OnError");
                        Log.d(TAG, e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        CommonUtils.showToast(OkHttpMainActivity.this, "OnResponse");
                        Log.d(TAG, response);
                    }
                });
    }

    private void doPost()
    {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        CommonUtils.showToast(OkHttpMainActivity.this, "OnError");
                        Log.d(TAG, e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        CommonUtils.showToast(OkHttpMainActivity.this, "OnResponse");
                        Log.d(TAG, response);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                //doGet();
                MyStringCallback callback = new MyStringCallback();
                HttpUtil.doGet(url, null, callback);
            break;
            case R.id.btn_post:
                doPost();
                break;
            case R.id.btn_one_ok:
                CommonUtils.showToast(this, "one");
                break;
            case R.id.btn_two_ok:
                CommonUtils.showToast(this, "two");
                break;
        }
    }

    private class MyStringCallback extends StringCallback {
        @Override
        public void onError(Call call, Exception e, int id) {
            //call.cancel();
            //call.enqueue();
            //call.execute();
            Log.d(TAG, e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.d(TAG, response);
        }
    }
}
