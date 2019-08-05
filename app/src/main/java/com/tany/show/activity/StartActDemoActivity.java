package com.tany.show.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tany.show.MainActivity;
import com.tany.show.R;

/**
 * 2019年07月31日16:22:24
 */
public class StartActDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_start_act_demo);
        this.startActivity(new Intent(this, MainActivity.class));
        this.startActivityForResult(new Intent(this, MainActivity.class), 11);
    }

}
