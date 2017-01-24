package com.wyz.testandroidapp.utils;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
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

    /**
     * 检测电量是否充足
     * @param context
     * @return
     */
    public static int hasPower(Context context) {
        BatteryManager bm = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        //bm.isCharging();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            int energy_counter = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER);
            return energy_counter;
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            long e = bm.getLongProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER);
            return (int)e;
        }


    }
}
