package com.example.administrator.test_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    protected List<String> mDatas;

    public interface onItemClickListener {
        void onItemClick(View view, int positon);

        void onItemLongClick(View view, int positon);
    }

    private onItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(onItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public MyAdapter(Context context, List<String> datas) {
        //赋值
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);

    }

    //创建ViewHolder
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_single_text, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //绑定viewholder中的数据
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv.setText(mDatas.get(position));

        setUpItemEvent(holder);
    }



    //从onBindViewHolder中抽出方法
    protected void setUpItemEvent(final MyViewHolder holder) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //设定position的位置  holder.getLayoutPosition()代替getView中传入的position
                    int layoutPositon = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, layoutPositon);
                }
            });
            //longclick
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPositon = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, layoutPositon);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public void addData(int positon) {
        mDatas.add(positon, "Insert One");
//       不使用 notifyDataSetChanged();
        notifyItemInserted(positon);
    }

    public void delData(int positon) {
        mDatas.remove(positon);
//       不使用 notifyDataSetChanged();
        notifyItemRemoved(positon);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}

