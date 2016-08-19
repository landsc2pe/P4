package com.example.homin.p4.treeview;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p4.R;
import com.example.homin.p4.base.BaseAdapter;
import com.example.homin.p4.base.util.LogTag;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by HOMIN on 2016-07-28.
 */
public class TreeView extends Fragment {
    public static final String TAG = TreeView.class.getSimpleName();
    public static final String ROOT_FOLDER = "/Tree";

    public LinkedList<File> dataList;
    public LinkedList<File> dataCache;


    private String sdPath;
    private String rootPath;
    private String recentPath;
    private TreeData rootTree;
    private TreeAdapter treeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tree_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        setRootData();
        setRecyclerView();
        setOnClickListener();

    }

    private void setRecyclerView() {
        treeAdapter = new TreeAdapter(dataList);
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.tree_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(treeAdapter);
    }

    private void setOnClickListener() {
        treeAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                File file = dataList.get(position).getAbsoluteFile();
                dataCache = new LinkedList<>();
                Collections.addAll(dataCache, file.listFiles());
                dataList.addAll(position+1,dataCache);
                treeAdapter.notifyDataSetChanged();
            }
        });

    }

    private void setRootData() {
        sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        rootPath = sdPath + ROOT_FOLDER;
        recentPath = rootPath;

        File rootFile = new File(recentPath);
        dataList = new LinkedList<>();
        rootTree = new TreeData(rootFile);

        Collections.addAll(dataList, rootTree.getChildData());
        if(LogTag.DEBUG) Log.d(TAG, ""+dataList.size());

    }
}

