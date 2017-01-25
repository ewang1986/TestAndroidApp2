package com.wyz.testandroidapp.utils;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
public class CommonUtils {
    private static final String TAG = "wyz";

    public static void showToast(Context context, String mString) {
        Toast.makeText(context, mString, Toast.LENGTH_SHORT).show();
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
    public static int countPower(Context context) {
        BatteryManager bm = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        //bm.isCharging();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            int energy_counter = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER);
            return energy_counter;
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            long e = bm.getLongProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER);
            return (int) e;
        }

        return -1;
    }

    public static void testAccount(Context context) {
        AccountManager am = (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Account[] mAccounts = am.getAccounts();
        for (Account a : mAccounts) {
            Log.d(TAG , "name->"+a.name);
            Log.d(TAG, "type->"+a.type);
            //a.describeContents();
            Log.d(TAG, "toString->"+a.toString());
        }
    }

    /**
     * 测试蓝牙服务
     * @param context
     */
    public static void testBluttooth(Context context) {
        BluetoothManager bm = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            List<BluetoothDevice> list = bm.getConnectedDevices(BluetoothGatt.GATT);
            for (BluetoothDevice device:list) {
                Log.d(TAG, "bluetooth device name->"+device.getName());
                //device.createBond();
            }
        }
    }

    /**
     * 测试粘贴板
     * @param context
     */
    public static void testClipboard(Context context) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData cd = cm.getPrimaryClip();
        showToast(context, cd.toString());
    }
}
