package com.tany.show.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tany.show.R;

/**
 * 原文地址：源码分析 https://www.jianshu.com/p/4a8dc2f50ae6
 * <p>
 * 语雀地址
 */
public class HandlerThreadDemoActivity extends AppCompatActivity {

    Handler mainHandler, workHandler;
    HandlerThread mHandlerThread;
    TextView text;
    Button button1, button2, button3;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_handler_thread_demo);

        //test
        this.demo();
    }


    /**
     * 演示 HandlerThread原理
     */
    private void demoHandlerThread() {

        //步骤1：创建HandlerThread实例对象
        //传入参数 = 线程名字，作用 = 标记该线程
        final HandlerThread mHandlerThread = new HandlerThread("handlerThread") {
            @Override
            protected void onLooperPrepared() {
                super.onLooperPrepared();
            }
        };

        //步骤2：启动线程
        mHandlerThread.start();

        //步骤3: 创建工作线程Handler & 覆写 handlerMessage

        final Handler workHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

        //步骤4：使用工作线程Handler向工作线程的消息队列发送消息
        // 在工作线程中，当消息循环时取出对应消息 & 在工作线程 执行相关操作
        // a、定义要发送的消息

        final Message msg = Message.obtain();
        msg.what = 2;
        msg.obj = "B";

        // b、通过Handler发送消息到其绑定的消息队列
        workHandler.sendMessage(msg);

        //5 介绍线程，即停止线程的消息循环
        mHandlerThread.quit();


    }

    private void demo() {
        // 显示文本
        this.text = findViewById(R.id.text1);

        // 创建与主线程关联的Handler
        this.mainHandler = new Handler();

        /**
         * 步骤1：创建HandlerThread实例对象
         * 传入参数 = 线程名字，作用 = 标记该线程
         */
        this.mHandlerThread = new HandlerThread("handlerThread");

        /**
         * 步骤2：启动线程
         */
        this.mHandlerThread.start();

        /**
         * 步骤3：创建工作线程Handler & 复写handleMessage（）
         * 作用：关联HandlerThread的Looper对象、实现消息处理操作 & 与其他线程进行通信
         * 注：消息处理操作（HandlerMessage（））的执行线程 = mHandlerThread所创建的工作线程中执行
         */

        this.workHandler = new Handler(this.mHandlerThread.getLooper()) {
            @Override
            // 消息处理的操作
            public void handleMessage(final Message msg) {
                //设置了两种消息处理操作,通过msg来进行识别
                switch (msg.what) {
                    // 消息1
                    case 1:
                        try {
                            //延时操作
                            Thread.sleep(1000);
                        } catch (final InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 通过主线程Handler.post方法进行在主线程的UI更新操作
                        HandlerThreadDemoActivity.this.mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                HandlerThreadDemoActivity.this.text.setText("我爱学习");
                            }
                        });
                        break;

                    // 消息2
                    case 2:
                        try {
                            Thread.sleep(3000);
                        } catch (final InterruptedException e) {
                            e.printStackTrace();
                        }
                        HandlerThreadDemoActivity.this.mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                HandlerThreadDemoActivity.this.text.setText("我不喜欢学习");
                            }
                        });
                        break;
                    default:
                        break;
                }
            }
        };

        /**
         * 步骤4：使用工作线程Handler向工作线程的消息队列发送消息
         * 在工作线程中，当消息循环时取出对应消息 & 在工作线程执行相关操作
         */
        // 点击Button1
        this.button1 = (Button) findViewById(R.id.button1);
        this.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                // 通过sendMessage（）发送
                // a. 定义要发送的消息
                final Message msg = Message.obtain();
                msg.what = 1; //消息的标识
                msg.obj = "A"; // 消息的存放
                // b. 通过Handler发送消息到其绑定的消息队列
                HandlerThreadDemoActivity.this.workHandler.sendMessage(msg);
            }
        });

        // 点击Button2
        this.button2 = (Button) findViewById(R.id.button2);
        this.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                // 通过sendMessage（）发送
                // a. 定义要发送的消息
                final Message msg = Message.obtain();
                msg.what = 2; //消息的标识
                msg.obj = "B"; // 消息的存放
                // b. 通过Handler发送消息到其绑定的消息队列
                HandlerThreadDemoActivity.this.workHandler.sendMessage(msg);
            }
        });

        // 点击Button3
        // 作用：退出消息循环
        this.button3 = (Button) findViewById(R.id.button3);
        this.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                HandlerThreadDemoActivity.this.mHandlerThread.quit();
            }
        });

    }
}

