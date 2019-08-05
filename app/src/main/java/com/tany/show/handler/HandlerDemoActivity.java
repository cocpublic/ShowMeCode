package com.tany.show.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.tany.show.R;

/**
 * 查看Handler 相关源码
 */
public class HandlerDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_handler_demo);
        Handler handler = new Handler();
        Looper.prepare();

        handler.sendEmptyMessageDelayed(0, 1000);
    }
}
