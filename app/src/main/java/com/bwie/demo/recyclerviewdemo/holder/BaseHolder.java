package com.bwie.demo.recyclerviewdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ${薛亚南}
 * on 2016/12/27 17：34.
 */
public class BaseHolder extends RecyclerView.ViewHolder {

    public final TextView tv;

    public BaseHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(android.R.id.text1);
    }
}
