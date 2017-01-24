package com.wyz.testandroidapp.utils;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/19.
 */
public class CommonUtils {
    public static void showToast(Context context, String mString) {
        Toast.makeText(context, mString,Toast.LENGTH_SHORT).show();
    }

    /**
     * 检测是否有网络
     * @param context
     * @return
     */
    public static boolean hasNet(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        //cm.getActiveNetworkInfo().isAvailable();
        //cm.getActiveNetworkInfo().isConnected();
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return false;
        } else {
            return info.isConnected();
        }

    }
}
