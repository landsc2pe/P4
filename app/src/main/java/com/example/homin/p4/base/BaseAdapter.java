package com.example.homin.p4.base;

import android.support.v7.widget.RecyclerView;

import com.example.homin.p4.ViewHolder;

/**
 * Created by HOMIN on 2016-07-20.
 */
 public abstract class BaseAdapter extends RecyclerView.Adapter<ViewHolder> {
    public String TAG = getClass().getSimpleName();

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public abstract void setOnItemClickListener(OnItemClickListener listener);
}
