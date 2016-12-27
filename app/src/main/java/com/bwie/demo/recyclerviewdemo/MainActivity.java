package com.bwie.demo.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.mtv_waterwall).setOnClickListener(this);
        findViewById(R.id.mtv_onFlush).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mtv_onFlush:
                jump(FlushActivity.class);
                break;
            case R.id.mtv_waterwall:
                jump(WaherWallActivity.class);
                break;
        }

    }

    public void jump(Class cla) {
        Intent intent = new Intent(this, cla);
        startActivity(intent);

    }
}
