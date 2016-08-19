package com.example.homin.p4.explorer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.homin.p4.R;

/**
 * Created by HOMIN on 2016-08-08.
 */
public class ExplorerViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout textViewContainer;
    public TextView textView;

    public ExplorerViewHolder(View itemView) {
        super(itemView);

        textViewContainer = (LinearLayout) itemView.findViewById(R.id.item_container);
        textView = (TextView) itemView.findViewById(R.id.item_list);
    }
}
