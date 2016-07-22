package com.example.homin.p4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.example.homin.p4.base.BaseAdapter;
import com.example.homin.p4.base.util.ClickEvent;
import com.example.homin.p4.base.util.ClickEventID;
import com.example.homin.p4.design.DesignActivity;
import com.example.homin.p4.notification.NotiFragment;
import com.example.homin.p4.webview.WebView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> itemList;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        init();
    }

    private void init() {
        makeActionBar();
        makeItemList();
        setRecyclerView();
        setClickListener();
    }


    private void makeActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void makeItemList() {
        itemList = new ArrayList<>();

        itemList.add("Design Support Library");
        itemList.add("Notification");
        itemList.add("WebView");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
        itemList.add("Test");
    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
        mainAdapter = new MainAdapter(itemList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mainAdapter);

    }

    private void setClickListener() {
        mainAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        setClickInfo(new ClickEvent(ClickEventID.ITEM_LIST_ONE));
                        break;
                    case 1:
                        setClickInfo(new ClickEvent(ClickEventID.ITEM_LIST_TWO));
                        break;
                    case 2:
                        setClickInfo(new ClickEvent(ClickEventID.ITEM_LIST_THREE));
                        break;

                    default:
                        Snackbar.make(getCurrentFocus(), "It`s not ready yet", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setClickInfo(ClickEvent event) {
        if (event.getId() == ClickEventID.ITEM_LIST_ONE) {
            Intent mIntent = new Intent(getApplicationContext(), DesignActivity.class);
            startActivity(mIntent);

        } else if (event.getId() == ClickEventID.ITEM_LIST_TWO) {
            Fragment notiFragment = new NotiFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_container, notiFragment, NotiFragment.TAG);
            fragmentTransaction.addToBackStack(NotiFragment.TAG);
            fragmentTransaction.commit();
        } else if (event.getId() == ClickEventID.ITEM_LIST_THREE) {
            Fragment webViewFragment = new WebView();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_container, webViewFragment, WebView.TAG);
            fragmentTransaction.addToBackStack(WebView.TAG);
            fragmentTransaction.commit();

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_setting_meun, menu);
        return true;
    }




}
