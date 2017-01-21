package com.wyz.testandroidapp.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wyz.testandroidapp.R;

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
        ImageView iv_res = (ImageView) findViewById(R.id.iv_res);
        iv_res.setImageResource(R.mipmap.ic_launcher);
        SimpleDraweeView sdv = (SimpleDraweeView) findViewById(R.id.iv_simple);
        sdv.setImageURI(uri);

    }
}
