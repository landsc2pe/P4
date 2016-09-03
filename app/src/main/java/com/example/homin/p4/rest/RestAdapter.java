package com.example.homin.p4.rest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.homin.p4.R;

import java.util.List;

/**
 * Created by HOMIN on 2016-08-28.
 */
public class RestAdapter extends RecyclerView.Adapter<RestAdapter.ViewHolder> {
    private Context mContext;
    private List<RestPojo> restPojoList;

    public RestAdapter(List<RestPojo> restPojoList, Context mContext) {
        this.restPojoList = restPojoList;
        this.mContext = mContext;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rest_item_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(restPojoList.get(position).getTitle());
        holder.subtitleTextView.setText(restPojoList.get(position).getAuthor() + " - " +
                restPojoList.get(position).getSubreddit());
        holder.subtitle2TextView.setText(restPojoList.get(position).getComments() + " points - " +
                restPojoList.get(position).getPoints() + " comments");


        String imageUrl = restPojoList.get(position).getThumbnail();
        if(TextUtils.isEmpty(imageUrl)) {
            Glide.clear(holder.thumbnailImageView);
        } else {
            Glide.with(mContext)
                    .load(restPojoList.get(position).getThumbnail())
                    .centerCrop()
                    .into(holder.thumbnailImageView);
        }
    }

    @Override
    public int getItemCount() {
        return restPojoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView titleTextView;
        public TextView subtitleTextView;
        public TextView subtitle2TextView;
        public ImageView thumbnailImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            this.view = itemView;
            this.titleTextView = (TextView) view.findViewById(R.id.item_title);
            this.subtitleTextView = (TextView) view.findViewById(R.id.item_subtitle);
            this.subtitle2TextView = (TextView) view.findViewById(R.id.subtitle2);
            this.thumbnailImageView = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }
}
