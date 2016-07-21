package com.example.homin.p4;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by HOMIN on 2016-07-20.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private final LinearLayout textViewContainer;
    public TextView textView;

    public ViewHolder(View itemView) {
        super(itemView);

        textViewContainer = (LinearLayout) itemView.findViewById(R.id.item_container);
        textView = (TextView) itemView.findViewById(R.id.item_list);
    }
}
