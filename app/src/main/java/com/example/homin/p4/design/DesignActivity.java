package com.example.homin.p4.design;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.ClickEvent;
import com.example.homin.p4.base.util.ClickEventID;
import com.example.homin.p4.base.util.LogTag;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by HOMIN on 2016-07-20.
 */
public class DesignActivity extends AppCompatActivity implements BottomSheetNaming {
    static final String TAG = DesignActivity.class.getSimpleName();
    private Toolbar mToolBar;
    private CollapsingToolbarLayout mCollapsingToolBar;
    private FloatingActionButton fab;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private BottomSheetBehavior<View> mBottomSheetBehavior;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_drawer);

        EventBus.getDefault().register(this);

        resolveBundleAndIntent(savedInstanceState);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    private void init() {
        setNavigationDrawer();
        setToolBar();
        setViewPager();
        setCollapsingToolbar();
        setFloatingActionButton();
        setBottomSheet();

    }

    void resolveBundleAndIntent(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if(intent != null) {
            if(LogTag.DEBUG) Log.d(TAG, "intent : " + intent);
            if(LogTag.DEBUG) Log.d(TAG, "string : " + intent.getStringExtra("key"));
            Bundle bundle = intent.getExtras();
            if(LogTag.DEBUG) Log.d(TAG, "bundle : " + bundle);
            if(LogTag.DEBUG) Log.d(TAG, "int : " + bundle.getInt("int"));
        }
    }

    private void setToolBar() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorToolbar), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setNavigationDrawer() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    }


    private void setViewPager() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        int tabCount = 3;
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new DesignViewPagerAdapter(getSupportFragmentManager(), DesignActivity.this, tabCount, mBottomSheetBehavior));


    }


    private void setCollapsingToolbar() {
        mCollapsingToolBar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolBar.setTitle("P4");
        mCollapsingToolBar.setContentScrimColor(getResources().getColor(R.color.colorOrange));
        mCollapsingToolBar.setBackgroundColor(getResources().getColor(R.color.colorToolbar));
        mCollapsingToolBar.setExpandedTitleColor(getResources().getColor(R.color.colorBlue));
        mCollapsingToolBar.setCollapsedTitleTextColor(getResources().getColor(R.color.colorToolbar));

    }


    private void setFloatingActionButton() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Design Support Library", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void setBottomSheet() {
        View bottomSheet = findViewById(R.id.bottom_sheet);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setPeekHeight(300);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_setting_meun, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Subscribe
    public void onEvent(ClickEvent event) {
        if (event.getId() == ClickEventID.ITEM_BOTTOM_ONE) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else if (event.getId() == ClickEventID.ITEM_BOTTOM_TWO) {
            mBottomSheetBehavior.setPeekHeight(300);
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (event.getId() == ClickEventID.ITEM_BOTTOM_THREE) {
            mBottomSheetBehavior.setHideable(true);
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }

    }

    @Override
    public void showBottomSheet() {
        // TODO: 2016-07-23 show bottom sheet
    }

    @Override
    public void dismissBottomSheet() {
        // TODO: 2016-07-23 dismiss bottom sheet
    }
}
