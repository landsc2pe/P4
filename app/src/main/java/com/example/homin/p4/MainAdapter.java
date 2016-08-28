package com.example.homin.p4;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p4.base.BaseAdapter;
import com.example.homin.p4.base.ViewHolder;
import com.example.homin.p4.base.util.LogTag;

import java.util.List;

/**
 * Created by HOMIN on 2016-07-20.
 */
public class MainAdapter extends BaseAdapter {


    private final List<String> itemList;
    private OnItemClickListener onItemClickListener;
    private ViewGroup viewGroup;

    public MainAdapter(List<String> list) {
        itemList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        viewGroup = parent;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        int po = position%2;
        if(LogTag.DEBUG) Log.d(TAG, "position"+position);
        if(LogTag.DEBUG) Log.d(TAG, "int"+po);
        if (po == 0) {
            holder.textView.setBackgroundColor(viewGroup.getResources().
                    getColor(R.color.colorOrange));
        }else{
            holder.textView.setBackgroundColor(viewGroup.getResources().getColor(R.color.colorPrimary));
        }
        holder.textView.setText(itemList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }
}
