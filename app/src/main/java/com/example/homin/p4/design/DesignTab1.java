package com.example.homin.p4.design;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.design_tab1, container, false);
        view.findViewById(R.id.nested_scroll);

        return view;
    }
}
