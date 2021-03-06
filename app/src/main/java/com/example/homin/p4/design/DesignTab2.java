package com.example.homin.p4.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p4.R;

/**
 * Created by HOMIN on 2016-07-21.
 */
public class DesignTab2 extends Fragment {

    public static DesignTab2 newInstance() {
        Bundle args = new Bundle();
        DesignTab2 designTab2 = new DesignTab2();
        designTab2.setArguments(args);

        return designTab2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.design_tab2, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
