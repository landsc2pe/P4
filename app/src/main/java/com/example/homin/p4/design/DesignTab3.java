package com.example.homin.p4.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.ClickEvent;
import com.example.homin.p4.base.util.ClickEventID;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by HOMIN on 2016-07-21.
 */
public class DesignTab3 extends Fragment {
    private Button button1, button2, button3;

    public static DesignTab3 newInstance() {
        Bundle args = new Bundle();
        DesignTab3 designTab3 = new DesignTab3();
        designTab3.setArguments(args);

        return designTab3;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.design_tab3, container, false);
//        bottomSheet = view.findViewById(R.id.bottom_sheet);
        button1 = (Button) view.findViewById(R.id.button_1);
        button2 = (Button) view.findViewById(R.id.button_2);
        button3 = (Button) view.findViewById(R.id.button_3);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();


    }

    private void init() {
        setButton1();
        setButton2();
        setButton3();

    }
    private void setButton1() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_1:
                        EventBus.getDefault().post(new ClickEvent(ClickEventID.ITEM_BOTTOM_ONE));
                        break;

                }
            }
        });
    }


    private void setButton2() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_2:
                        EventBus.getDefault().post(new ClickEvent(ClickEventID.ITEM_BOTTOM_TWO));
                        break;
                }
            }
        });
    }

    private void setButton3() {
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_3:
                        EventBus.getDefault().post(new ClickEvent(ClickEventID.ITEM_BOTTOM_THREE));
                        break;

                }
            }
        });
    }
}