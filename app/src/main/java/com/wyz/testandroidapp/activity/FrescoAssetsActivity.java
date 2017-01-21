package com.wyz.testandroidapp.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wyz.testandroidapp.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wyz on 2017/1/21.
 */
public class FrescoAssetsActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fresco_assets);

        init();
    }

    private void init() {
        Uri uri = Uri.parse("res://"+ getApplication().getPackageName()+ R.mipmap.ic_launcher);
        Bitmap bmp = null;
        try {
            InputStream is = getAssets().open("j15.png");
            bmp = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("wyz", e.getMessage());
        }

        ImageView iv_res = (ImageView) findViewById(R.id.iv_res);
        ImageView iv_assets = (ImageView) findViewById(R.id.iv_assets);
        SimpleDraweeView sdv = (SimpleDraweeView) findViewById(R.id.sdv_simple);
        iv_res.setImageResource(R.mipmap.ic_launcher);
        iv_assets.setImageBitmap(bmp);
        //TODO Uri
        //sdv.setImageURI(uri);

    }
}
