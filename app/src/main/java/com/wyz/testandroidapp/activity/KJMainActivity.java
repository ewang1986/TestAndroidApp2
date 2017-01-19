package com.wyz.testandroidapp.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.wyz.testandroidapp.R;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.KJBitmap;
import org.kymjs.kjframe.ui.BindView;

/**
 * Created by Administrator on 2017/1/19.
 */
public class KJMainActivity extends KJActivity{
    @BindView(id = R.id.iv_kj)
    public ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void init() {
        String iv_url = "http://www.yunmai11.com/tpl/System/Static/images/logo-pigcms.png";
        KJBitmap.Builder build = new KJBitmap.Builder();
        build.imageUrl(iv_url);
        build.view(iv);
        build.display(new KJBitmap());
    }

    @Override
    public void setRootView() {
        setContentView(R.layout.test_layout);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        init();
    }
}
