package com.bwie.demo.recyclerviewdemo;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bwie.demo.recyclerviewdemo.adapter.MyrecyclerViewAdapter;

import java.util.ArrayList;

public class FlushActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout spf;
    private RecyclerView rlv_flush;
    private int index = 0;
    private int maxCount = 20;
    ArrayList<String> dataList = new ArrayList<>();
    private Handler handler = new Handler() {

        private MyrecyclerViewAdapter adapter;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //停止刷新
                    spf.setRefreshing(false);
                    break;
            }
            if (adapter == null) {
                adapter = new MyrecyclerViewAdapter(FlushActivity.this, dataList);
                rlv_flush.setAdapter(adapter);
            }else{
                adapter.notifyDataSetChanged();
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flush);
        spf = (SwipeRefreshLayout) findViewById(R.id.spf);
        rlv_flush = (RecyclerView) findViewById(R.id.rlv_flush);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rlv_flush.setLayoutManager(manager);
        //设置进度的衍颜色
        spf.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        //设置是否刷新---直接一进来就刷新
        spf.post(new Runnable() {
            @Override
            public void run() {
                //一上来先去做刷新的逻辑操作
                spf.setRefreshing(true);
                //请求数据
                //请求数据
                reFreshData();
            }
        });
        //设置可以下拉刷新
        spf.setOnRefreshListener(this);

    }

    //下拉刷新
    @Override
    public void onRefresh() {
        Toast.makeText(this, "刷新啦", Toast.LENGTH_LONG).show();
        //数据请求
        reFreshData();
    }

    public void reFreshData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                index = 0;
                dataList.clear();
                loadData();
                handler.sendEmptyMessage(0);
            }
        }.start();
    }

    public void loadData() {

        for (int i = index; i < index + maxCount; i++) {
            dataList.add("我是第" + i + "条目");

        }
    }
}
