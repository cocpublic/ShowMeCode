package com.tany.show.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tany.show.MainActivity;
import com.tany.show.R;

public class StartActDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_act_demo);


        startActivity(new Intent(this, MainActivity.class));

        startActivityForResult(new Intent(this, MainActivity.class), 11);
    }
}
