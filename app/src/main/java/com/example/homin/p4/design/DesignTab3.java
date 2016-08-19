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
    static final String KEY_STATE1 = "state1";
    static final String KEY_STATE2 = "state2";
    int state1;
    int state2;
    BottomSheetNaming naming;

    public static DesignTab3 newInstance(int state1, int state2, BottomSheetNaming naming) {
        Bundle args = new Bundle();
        DesignTab3 designTab3 = new DesignTab3();
        args.putInt(KEY_STATE1, state1);
        args.putInt(KEY_STATE2, state2);
        designTab3.setArguments(args);

        designTab3.setState1(state1);
        designTab3.setState2(state2);
        designTab3.setBottomSheetName(naming);

        return designTab3;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        if(args != null) {
            state1 = args.getInt(KEY_STATE1);
            state2 = args.getInt(KEY_STATE2);
        }
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

    public void setState1(int state1) {
        this.state1 = state1;
    }

    public void setState2(int state2) {
        this.state2 = state2;
    }

    public void setBottomSheetName(BottomSheetNaming naming) {
        this.naming = naming;
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
//                        if(naming != null) {
//                            naming.showBottomSheet();
//                        }
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