package com.example.administrator.test_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by Administrator on 2016/8/23.
 */

public class StaggeredAdapter extends MyAdapter{

    private List<Integer> mHeights;

    public StaggeredAdapter(Context context, List<String> datas) {
        //为了给瀑布流布局添加监听，让StaggeredAdapter继承MyAdapter， 此时必须调用父类构造方法
        super(context,datas);

        //设置随机数
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
                mHeights.add((int) (100+Math.random()*300));
        }

    }

    //绑定viewholder中的数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp=holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));

        //把所继承的MyAdapter中的回调方法抽出 写到onBindViewHolder中
        setUpItemEvent(holder);
    }
}

