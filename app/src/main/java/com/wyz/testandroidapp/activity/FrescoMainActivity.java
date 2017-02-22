package com.wyz.testandroidapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import com.wyz.testandroidapp.R;

/**
 * Created by wyz on 2017/1/20.
 */
public class FrescoMainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fresco_main);

        init();
    }

    private void init() {
        Button btn_simple = (Button) findViewById(R.id.btn_simple);
        Button btn_assets = (Button) findViewById(R.id.btn_assets);
        btn_simple.setOnClickListener(this);
        btn_assets.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simple:
                Intent simpleIntent = new Intent(this, FrescoSimpleActivity.class);
                startActivity(simpleIntent);
                break;
            case R.id.btn_assets:
                Intent assetsIntent = new Intent(this, FrescoAssetsActivity.class);
                startActivity(assetsIntent);
                break;
        }

        AlphaAnimation anim = new AlphaAnimation(1.0f, 0.5f);
        anim.setDuration(500);
        anim.setFillAfter(true);
        //anim.start();
        v.startAnimation(anim);
    }
}
