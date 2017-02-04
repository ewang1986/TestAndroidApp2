package com.wyz.testandroidapp.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wyz.testandroidapp.R;

/**
 * Created by wyz on 2017/1/20.
 */
public class FrescoSimpleActivity extends Activity{

    private String url = "http://www.dedecms.com/images/product_center.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fresco_simple);

        Uri uri = Uri.parse(url);
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);
    }
}
