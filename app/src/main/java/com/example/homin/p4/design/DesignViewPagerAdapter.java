package com.example.homin.p4.design;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.LogTag;


/**
 * Created by HOMIN on 2016-07-20.
 */
public class DesignViewPagerAdapter extends FragmentStatePagerAdapter {

    final String TAG = DesignViewPagerAdapter.class.getSimpleName();

    int numOfTabs;
    //    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };
    private Fragment[] cacheFragment;
    private int imageResId[] = {R.drawable.ic_action_name, R.drawable.ic_two, R.drawable.ic_three};
    private Context context;
    private BottomSheetBehavior bottomSheetBehavior;
    BottomSheetNaming naming;

    public DesignViewPagerAdapter(FragmentManager fm, Context context, int numOfTabs, BottomSheetBehavior bottomSheetBehavior) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.context = context;
        this.bottomSheetBehavior = bottomSheetBehavior;

        cacheFragment = new Fragment[numOfTabs];
    }

    public DesignViewPagerAdapter(FragmentManager fm, Context context, int numOfTabs,
                                  BottomSheetBehavior bottomSheetBehavior,
                                  BottomSheetNaming naming) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.context = context;
        this.bottomSheetBehavior = bottomSheetBehavior;

        cacheFragment = new Fragment[numOfTabs];
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if (LogTag.DEBUG) Log.d(TAG, "getItem() : position : " + position);
        if (cacheFragment[position] == null) {
            Log.d(TAG, "cache miss.");
            if (position == 0) {
                fragment = DesignTab1.newInstance();
            }
            else if (position == 1) fragment = new DesignTab2();
            else if
                    (position == 2) {
                fragment = new DesignTab3();
            }

            cacheFragment[position] = fragment;
        } else {
            Log.d(TAG, "cache hit.");
            fragment = cacheFragment[position];
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        Drawable image = ContextCompat.getDrawable(context, imageResId[position]);
//        image.setColorFilter(0xffffffff, PorterDuff.Mode.SRC_ATOP);
        image.setBounds(0, 0, (int) (image.getIntrinsicWidth() / 1.2), (int) (image.getIntrinsicHeight() / 1.2));
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }
}
