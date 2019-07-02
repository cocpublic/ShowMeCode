package com.tany.show;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * https://www.jianshu.com/p/4a8dc2f50ae6
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    private void demoHandlerThread() {

        //步骤1：创建HandlerThread实例对象
        //传入参数 = 线程名字，作用 = 标记该线程
        HandlerThread mHandlerThread = new HandlerThread("handlerThread") {
            @Override
            protected void onLooperPrepared() {
                super.onLooperPrepared();
            }
        };

        //步骤2：启动线程
        mHandlerThread.start();

        //步骤3: 创建工作线程Handler & 覆写 handlerMessage

        Handler workHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(final Message msg) {
                super.handleMessage(msg);
            }
        };

        //步骤4：使用工作线程Handler向工作线程的消息队列发送消息
        // 在工作线程中，当消息循环时取出对应消息 & 在工作线程 执行相关操作
        // a、定义要发送的消息

        Message msg = Message.obtain();
        msg.what = 2;
        msg.obj = "B";

        // b、通过Handler发送消息到其绑定的消息队列
        workHandler.sendMessage(msg);

        //5 介绍线程，即停止线程的消息循环
        mHandlerThread.quit();


    }
}
