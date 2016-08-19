package com.example.homin.p4.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.homin.p4.R;

import java.util.ArrayList;

/**
 * Created by HOMIN on 2016-08-10.
 */
public class TestActivity extends Activity implements RemoveClickListner{
    private RecyclerView mRecyclerView;
    private TestAdapter mTestAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button btnAddItem;
    ArrayList<TestData> myList = new ArrayList<>();
    EditText etTitle, etDescription;
    String title = "",description = "";
    ImageView crossImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mTestAdapter = new TestAdapter(myList,this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mTestAdapter);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etDescription = (EditText) findViewById(R.id.etDescription);
        btnAddItem = (Button) findViewById(R.id.btnAddItem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = etTitle.getText().toString();
                description = etDescription.getText().toString();
                if (title.matches("")) {
                    Toast.makeText(v.getContext(), "You did not enter a Title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (description.matches("")) {
                    Toast.makeText(v.getContext(), "You did not enter a description", Toast.LENGTH_SHORT).show();
                    return;
                }

                TestData mLog = new TestData();
                mLog.setTitle(title);
                mLog.setDescription(description);
                myList.add(mLog);
                mTestAdapter.notifyData(myList);
                etTitle.setText("");
                etDescription.setText("");
            }
        });
    }
    @Override
    public void OnRemoveClick(int index) {
        myList.remove(index);
        mTestAdapter.notifyData(myList);
    }
}