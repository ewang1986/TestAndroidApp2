package com.wyz.testandroidapp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/19.
 */
public class CommonUtils {
    public static void showToast(Context context, String mString) {
        Toast.makeText(context, mString,Toast.LENGTH_SHORT).show();
    }
}
