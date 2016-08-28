package com.example.homin.p4.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.homin.p4.R;

/**
 * Created by HOMIN on 2016-07-20.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout textViewContainer;
    public TextView textView;

    public ViewHolder(View itemView) {
        super(itemView);

        textViewContainer = (LinearLayout) itemView.findViewById(R.id.item_container);
        textView = (TextView) itemView.findViewById(R.id.item_list);
    }
}
