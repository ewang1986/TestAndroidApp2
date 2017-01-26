package com.wyz.testandroidapp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.wyz.testandroidapp.R;

/**
 * Created by ewang1986 on 2017/1/25.
 */
public class TestSystemServiceActivity extends Activity implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_system_service);

        init();
    }

    private void init() {
        Button btn_bluetooth = (Button) findViewById(R.id.btn_bluetooth);
        Button btn_account = (Button) findViewById(R.id.btn_account);
        btn_bluetooth.setOnClickListener(this);
        btn_account.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bluetooth:
                break;
            case R.id.btn_account:
                break;
        }
    }
}
