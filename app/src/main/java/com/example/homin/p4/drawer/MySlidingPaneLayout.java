package com.example.homin.p4.drawer;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by HOMIN on 2016-12-17.
 **/

public class MySlidingPaneLayout extends SlidingPaneLayout {
    // ===========================================================
// Constructors
// ===========================================================
    public MySlidingPaneLayout(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public MySlidingPaneLayout(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public MySlidingPaneLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    // ===========================================================
// Methods for/from SuperClass/Interfaces
// ===========================================================
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return false;
//    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
//        if (this.closePane()) {
//            Toast.makeText(getContext(), "closed", Toast.LENGTH_SHORT).show();
//        }
        return true; // here it returns false so that another event's listener
        // should be called, in your case the MapFragment
        // listener
    }
}