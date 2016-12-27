package com.bwie.demo.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.demo.recyclerviewdemo.utils.Images;

import java.util.ArrayList;
import java.util.List;

public class WaherWallActivity extends AppCompatActivity {

    private RecyclerView rlv_wt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waher_wall);
        initView();

    }

    private void initView() {
        rlv_wt = (RecyclerView) findViewById(R.id.rlv_wt);
        rlv_wt.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        rlv_wt.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        private final List<Integer> heiLsit;

        public MyAdapter() {
            heiLsit = new ArrayList<>();
            for (int i = 0; i < Images.imageUrls.length; i++) {
                int hei = (int) (100 + (Math.random() * 300));
                heiLsit.add(hei);

            }
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View veiw = View.inflate(WaherWallActivity.this, R.layout.item_img, null);
            MyHolder myHolder = new MyHolder(veiw);
            return myHolder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            //先得到图片的参数 改变图片的高度
            ViewGroup.LayoutParams layoutParams = holder.img.getLayoutParams();
            layoutParams.height = heiLsit.get(position);
            holder.img.setLayoutParams(layoutParams);
              holder.img.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(WaherWallActivity.this).load(Images.imageUrls[position]).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.img);

        }

        @Override
        public int getItemCount() {
            return Images.imageUrls.length;
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {

        public final ImageView img;

        public MyHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
