package com.jeff.demo.androiddemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ttxs on 2018/1/9.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>
{
    private Context mContext;
    private String[] items;

    public MainAdapter(Context mContext, String[] items)
    {
        this.mContext = mContext;
        this.items = items;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout
                .item_main_recycler_layout, parent, false);
        return new MainViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position)
    {
        holder.mItemName.setText(items[position]);
        Random random = new Random();
        holder.mItemName.setBackgroundColor(Color.argb(random.nextInt(255),
                random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        holder.mItemName.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mListener != null){
                    mListener.itemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return items.length;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_name)
        TextView mItemName;

        public MainViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }
    public interface OnItemClickListener{
        void itemClick(int position);
    }
}
