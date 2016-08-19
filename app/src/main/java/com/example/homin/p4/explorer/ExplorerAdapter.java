package com.example.homin.p4.explorer;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.LogTag;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by HOMIN on 2016-08-08.
 */
public class ExplorerAdapter extends RecyclerView.Adapter<ExplorerViewHolder> {
    public static final String TAG = ExplorerAdapter.class.getSimpleName();
    public static final String CONFIRM_LEAF = "/confirm_leaf.text";
    int type;
    ArrayList<File> data;
    RecyclerView recyclerView;

    public ExplorerAdapter(ArrayList data) {
        this.data = data;
        this.recyclerView = recyclerView;
    }
//
//    @Override
//    public int getItemViewType(int position) {
//        File confirmFile = new File(data[position].getPath() + CONFIRM_LEAF);
//        Boolean dataConfirm = confirmFile.isFile();
//
//        return -1;
//    }

    @Override
    public ExplorerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item, parent, false);
        return new ExplorerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExplorerViewHolder holder, final int position) {
        holder.textView.setText(data.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ExplorerFragment.recentPath += "/" + data.get(position).getName();
                ExplorerFragment.dataSort();
                if(LogTag.DEBUG) Log.d(TAG, ExplorerFragment.recentPath);
                if(LogTag.DEBUG) Log.d(TAG, ""+ExplorerFragment.root);
                ExplorerFragment.exRecyclerView.setAdapter(new  ExplorerAdapter(ExplorerFragment.fileLIst));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
