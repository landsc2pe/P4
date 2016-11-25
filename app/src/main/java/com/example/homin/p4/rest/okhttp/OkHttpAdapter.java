package com.example.homin.p4.rest.okhttp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homin.p4.R;

import java.util.List;

/**
 * Created by HOMIN on 2016-08-28.
 */
public class OkHttpAdapter extends RecyclerView.Adapter<OkHttpAdapter.ViewHolder> {
    private Context mContext;
    private List<OkHttpCustom> customData;
    private OnItemClickListener itemClickListener;

    public OkHttpAdapter(List<OkHttpCustom> customData, Context mContext) {
        this.customData = customData;
        this.mContext = mContext;

    }

    public void setCustomData(List<OkHttpCustom> customData) {
        this.customData = customData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rest_item_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (customData.get(position).getGetHtmlUrl() == null) {
            holder.titleTextView.setText(customData.get(position).getPostHtmlUrl());
        } else {
            holder.titleTextView.setText(customData.get(position).getGetHtmlUrl());
        }
//        holder.subtitleTextView.setText(gistsData.get(position).getFileName());
//        holder.subtitle2TextView.setText(gistsData.get(position).getLanguage());
        holder.titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customData.get(position).getGetHtmlUrl() == null) {
                    itemClickListener.onClick(customData.get(position).getPostHtmlUrl());
                } else {
                    itemClickListener.onClick(customData.get(position).getGetHtmlUrl());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (customData == null) {
            return 0;
        } else {
            return customData.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        TextView titleTextView;
        TextView subtitleTextView;
        TextView subtitle2TextView;
        ImageView thumbnailImageView;

        ViewHolder(View itemView) {
            super(itemView);

            this.view = itemView;
            this.titleTextView = (TextView) view.findViewById(R.id.item_title);
            this.subtitleTextView = (TextView) view.findViewById(R.id.item_subtitle);
            this.subtitle2TextView = (TextView) view.findViewById(R.id.subtitle2);
            this.thumbnailImageView = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }
}
