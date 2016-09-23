package com.example.homin.p4.selectmode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.afollestad.dragselectrecyclerview.DragSelectRecyclerView;
import com.afollestad.dragselectrecyclerview.DragSelectRecyclerViewAdapter;
import com.example.homin.p4.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOMIN on 2016-09-04.
 **/
public class ActionModeActivity extends AppCompatActivity implements ActionModeAdapter.ClickListener, DragSelectRecyclerViewAdapter.SelectionListener{

    private DragSelectRecyclerView list;
    private List<Integer> data;
    private ActionMode currentActionMode;
    private ActionModeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode_activity);

        init();

        adapter = new ActionModeAdapter(this, data);
        adapter.setSelectionListener(this);
        adapter.restoreInstanceState(savedInstanceState);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        list = (DragSelectRecyclerView) findViewById(R.id.list);
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
    }

    private void init() {
        setData();
        setToolBar();

    }

    private void setData() {
        data = new ArrayList<>();
        for(int i =0; i<100; i++){
            data.add(i);
        }

    }

    private void setToolBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (currentActionMode != null) { return false; }
                startActionMode(modeCallBack);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ActionMode.Callback modeCallBack = new ActionMode.Callback() {
        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("Actions");
            mode.getMenuInflater().inflate(R.menu.actions_textview, menu);
            return true;
        }

        // Called each time the action mode is shown.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_edit:
                    Toast.makeText(getApplicationContext(), "Editing!", Toast.LENGTH_SHORT).show();
                    mode.finish(); // Action picked, so close the contextual menu
                    return true;
                case R.id.menu_delete:
                    // Trigger the deletion here
                    mode.finish(); // Action picked, so close the contextual menu
                    return true;
                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            currentActionMode = null; // Clear current action mode
        }
    };



    @Override
    public void onClick(int index) {
        // Single click will select or deselect an item
        adapter.toggleSelected(index);
    }

    @Override
    public void onLongClick(int index) {
        // Long click initializes drag selection, and selects the initial item
        list.setDragSelectActive(true, index);
    }

    @Override
    public void onDragSelectionChanged(int count) {
        // TODO Selection was changed, updating an indicator, e.g. a Toolbar or contextual action bar
    }
}
