package com.example.homin.p4.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p4.R;

/**
 * Created by HOMIN on 2016-12-15.
 **/

public class DrawerFragment extends Fragment {
    public static final String TAG = DrawerFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawer_fragment, container, false);

        return view;
    }
}
