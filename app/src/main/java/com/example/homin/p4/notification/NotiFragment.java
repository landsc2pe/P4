package com.example.homin.p4.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p4.R;
import com.example.homin.p4.base.BaseFragment;

/**
 * Created by HOMIN on 2016-07-20.
 */
public class NotiFragment extends BaseFragment {
    public static final String TAG = NotiFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.noti_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
        setNotification();
    }

    private void setNotification() {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(getContext())
                        .setSmallIcon(R.drawable.ic_noti_one)
                        .setContentTitle("P4 Notification")
                        .setContentText("Good Job ~!");

        NotificationManager mNotificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NotificationID.NOTI_TEST_ONE,mBuilder.build());
    }

    static class NotificationID {
        static int NOTI_TEST_ONE = 1;
    }
}
