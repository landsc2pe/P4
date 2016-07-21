package com.example.homin.p4.design;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.homin.p4.R;

/**
 * Created by HOMIN on 2016-07-20.
 */
public class DesignActivity extends AppCompatActivity {
    static final String TAG = DesignActivity.class.getSimpleName();
    private Toolbar mToolBar;
    private CollapsingToolbarLayout mCollapsingToolBar;
    private FloatingActionButton fab;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_drawer);

        init();
    }

    private void init() {
        setNavigationDrawer();
        setToolBar();
        setViewPager();
        setCollapsingToolbar();
        setFloatingActionButton();

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
        viewPager.setAdapter(new DesignViewPagerAdapter(getSupportFragmentManager(), DesignActivity.this, tabCount));


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

}
