package com.bwie.demo.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;

import com.bwie.demo.recyclerviewdemo.R;
import com.bwie.demo.recyclerviewdemo.holder.BaseHolder;

import java.util.List;

/**
 * Created by ${薛亚南}
 * on 2016/12/27 17：33.
 */
public class MyrecyclerViewAdapter extends RecyclerView.Adapter<BaseHolder> {
    private Context context;
    private List<String> list;

    public MyrecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, android.R.layout.simple_list_item_1, null);
        BaseHolder holder = new BaseHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
