package com.example.homin.p4.design;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homin.p4.R;

/**
 * Created by HOMIN on 2016-07-20.
 */
public class DesignTab1 extends Fragment {

    public static DesignTab1 newInstance() {
        Bundle args = new Bundle();
        DesignTab1 fragment = new DesignTab1();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.design_tab1, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text_test);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFilterPopup(view);
            }
        });
        return view;
    }

    private void showFilterPopup(View v) {
        PopupMenu popup = new PopupMenu(getContext(), v);
        // Inflate the menu from xml
        popup.getMenuInflater().inflate(R.menu.popup_filters, popup.getMenu());
        // Setup menu item selection
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_keyword:
                        Toast.makeText(getContext(), "Keyword!", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_popularity:
                        Toast.makeText(getContext(), "Popularity!", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        // Handle dismissal with: popup.setOnDismissListener(...);
        // Show the menu
        popup.show();
    }


}
