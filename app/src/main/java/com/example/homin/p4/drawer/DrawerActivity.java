package com.example.homin.p4.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.homin.p4.R;
import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.MiniDrawer;

/**
 * Created by HOMIN on 2016-12-15.
 **/

public class DrawerActivity extends AppCompatActivity {
    private static final int PROFILE_SETTING = 1;

    private MiniDrawer miniResult;
    private Drawer result;
    private Bundle savedInstanceState;
    private DrawerLayout mDrawer;
    private AccountHeader headerResult;
    private Crossfader crossFader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity);

        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("mini");

//
        Fragment drawerFragment = new DrawerFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add( R.id.container_drawer, drawerFragment, DrawerFragment.TAG);
        transaction.commit();
//
//        // Create the AccountHeader
//        headerResult = new AccountHeaderBuilder()
//                .withActivity(this)
//                .withTranslucentStatusBar(false)
//                .addProfiles()
//                .withSavedInstance(savedInstanceState)
//                .build();
//
//
//        result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .withTranslucentStatusBar(false)
//                .addDrawerItems(
//
//                ) // add the items we want to use with our Drawer
//                .withGenerateMiniDrawer(true)
//                .withSavedInstance(savedInstanceState)
//                // build only the view of the Drawer (don't inflate it automatically in our layout which is done with .build())
//                .buildView();
//
//        //the MiniDrawer is managed by the Drawer and we just get it to hook it into the Crossfader
//        miniResult = result.getMiniDrawer();
//
//        //get the widths in px for the first and second panel
//        int firstWidth = (int) UIUtils.convertDpToPixel(360, this);
//        int secondWidth = (int) UIUtils.convertDpToPixel(70, this);
//
//        //create and build our crossfader (see the MiniDrawer is also builded in here, as the build method returns the view to be used in the crossfader)
//        //the crossfader library can be found here: https://github.com/mikepenz/Crossfader
//        crossFader = new Crossfader()
//                .withContent(findViewById(R.id.crossfade_content))
//                .withFirst(result.getSlider(), firstWidth)
//                .withSecond(miniResult.build(this), secondWidth)
//                .withSavedInstance(savedInstanceState)
//                .build();
//
//        //define the crossfader to be used with the miniDrawer. This is required to be able to automatically toggle open / close
//        miniResult.withCrossFader(new CrossfadeWrapper(crossFader));
//
//        //define a shadow (this is only for normal LTR layouts if you have a RTL app you need to define the other one
//        crossFader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
//    }
//
//    private class CrossfadeWrapper implements ICrossfader {
//        private Crossfader mCrossfader;
//
//        CrossfadeWrapper(Crossfader crossfader) {
//            this.mCrossfader = crossfader;
//        }
//
//        @Override
//        public void crossfade() {
//            mCrossfader.crossFade();
//        }
//
//        @Override
//        public boolean isCrossfaded() {
//            return mCrossfader.isCrossFaded();
//        }
    }
}
