package com.wyz.testandroidapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        btn_simple.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simple:
                Intent simpleIntent = new Intent(this, FrescoSimpleActivity.class);
                startActivity(simpleIntent);
                break;
        }
    }
}
