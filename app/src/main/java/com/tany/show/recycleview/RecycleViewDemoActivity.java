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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_demo);
        initView();
    }

    private void initView() {
        rvContent = findViewById(R.id.rv_content);

        //设置layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvContent.setLayoutManager(layoutManager);


        //设置adapter
        adapter = new MultipleItemAdapter(this);
        rvContent.setAdapter(adapter);

        //添加数据并且刷新adapter

        List<String> list = new ArrayList<>();
        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }
}
