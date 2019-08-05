package com.tany.show.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tany.show.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewDemoActivity extends AppCompatActivity {

    private RecyclerView rvContent;
    private MultipleItemAdapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_recycle_view_demo);
        this.initView();
    }

    private void initView() {
        this.rvContent = findViewById(R.id.rv_content);

        //设置layoutManager
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.rvContent.setLayoutManager(layoutManager);


        //设置adapter
        this.adapter = new MultipleItemAdapter(this);
        this.rvContent.setAdapter(this.adapter);

        //添加数据并且刷新adapter

        final List<String> list = new ArrayList<>();
        this.adapter.addAll(list);
        this.adapter.notifyDataSetChanged();
    }
}
