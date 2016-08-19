package com.example.homin.p4.explorer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.LogTag;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by HOMIN on 2016-08-08.
 */
public class ExplorerFragment extends Fragment {
    public static final String TAG = ExplorerFragment.class.getSimpleName();
    public static final String ROOT_FOLDER = "/Tree";
    public static final String CONFIRM_LEAF = "/leaf_confirm.text";

    public static final int TYPE_BRANCH = 0;
    public static final int TYPE_LEAF = 1;

    public static String rootPath;
    public static String sdPath;
    public static String recentPath;
    public static RecyclerView exRecyclerView;
    public static ArrayList<File> fileLIst;
    public static File root;

    private static File[] rootFiles;


    private ExplorerAdapter exAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explorer_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        makeRootFolder();
        setRecyclerView();
        setOnClick();
        dataTest();


    }

    private void dataTest() {

        File root = new File(rootPath);
        File[] h1 = root.listFiles();
        h1[0].listFiles();

    }

    private void setOnClick() {
        Button branchButton = (Button) getView().findViewById(R.id.explorer_button1);
        Button leafButton = (Button) getView().findViewById(R.id.explorer_button2);



        branchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Input Folder Name");
                alertDialog.setMessage("check");

                final EditText folderName = new EditText(getContext());
                alertDialog.setView(folderName);

                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = folderName.getText().toString();
                        FolderCreator folderCreator = new FolderCreator(TYPE_BRANCH, recentPath, name);
                    }
                });

                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertDialog.show();


            }
        });

        leafButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Input Folder Name");
                alertDialog.setMessage("check");

                final EditText folderName = new EditText(getContext());
                alertDialog.setView(folderName);

                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = folderName.getText().toString();
                        FolderCreator folderCreator = new FolderCreator(TYPE_LEAF, recentPath, name);
                    }
                });

                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertDialog.show();

            }
        });
    }

    private void setRecyclerView() {


        dataSort();

        if (rootFiles == null) {
            //show empty view.
        } else {
            exRecyclerView = (RecyclerView) getView().findViewById(R.id.explorer_recycler_view);
            exRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            exAdapter = new ExplorerAdapter(fileLIst);
            exRecyclerView.setAdapter(exAdapter);
        }
    }

    public static void  dataSort() {

        root = new File(recentPath);
        rootFiles = root.listFiles();
        fileLIst = new ArrayList<>();


        for(File file : rootFiles) {
            File confirmFile = new File(file.getPath() + CONFIRM_LEAF);
            if(!confirmFile.isFile()){
                fileLIst.add(file);
            }
        }

        for(File file : rootFiles) {
            File confirmFile = new File(file.getPath() + CONFIRM_LEAF);
            if (confirmFile.isFile()) {
                fileLIst.add(file);
            }
        }

    }

    private void makeRootFolder() {
        sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        rootPath = sdPath + ROOT_FOLDER;
        recentPath = rootPath;
        if (LogTag.DEBUG) Log.d(TAG, sdPath);

        root = new File(recentPath);
        if (!root.exists()) root.mkdir();
    }
}
