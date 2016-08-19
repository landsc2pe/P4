package com.example.homin.p4.treeview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p4.R;
import com.example.homin.p4.ViewHolder;
import com.example.homin.p4.base.BaseAdapter;
import com.example.homin.p4.base.util.LogTag;

import java.io.File;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HOMIN on 2016-07-28.
 */
public class TreeAdapter extends BaseAdapter {

    private LinkedList<File> treeData;
    private OnItemClickListener onItemClickListener;
    private ViewGroup viewGroup;

    public TreeAdapter(LinkedList<File> treeData) {
        this.treeData = treeData;
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
        holder.textView.setText(treeData.get(position).getName());
        setColor(holder, position);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(position);

            }
        });
    }

    private void setColor(ViewHolder holder, int position) {
        String path = treeData.get(position).getAbsolutePath();
        if (LogTag.DEBUG) Log.d(TAG, path);
        int treeValue = path.indexOf("/Tree");
        String getValue = path.substring(treeValue);
        if (LogTag.DEBUG) Log.d(TAG, getValue);
        Pattern pattern = Pattern.compile("/");
        Matcher matcher = pattern.matcher(getValue);
        int count = 0;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            count++;
        }
        if(LogTag.DEBUG)Log.d(TAG, ""+count);

        if (count == 3)
            holder.textView.setBackgroundColor(viewGroup.getResources().getColor(R.color.colorMint));
        else if (count == 4) {
            holder.textView.setBackgroundColor(viewGroup.getResources().getColor(R.color.colorBlue));
        }else {
            holder.textView.setBackgroundColor(viewGroup.getResources().getColor(R.color.colorBlack));

        }

    }

    @Override
    public int getItemCount() {
        return treeData.size();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;


    }
}
