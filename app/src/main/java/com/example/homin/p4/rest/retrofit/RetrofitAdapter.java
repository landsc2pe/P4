package com.example.homin.p4.rest.retrofit;

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
public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.ViewHolder> {
    private Context mContext;
    private List<RedditCustom> mRedditCustomList;

    public RetrofitAdapter(List<RedditCustom> redditCustomList, Context mContext) {
        this.mRedditCustomList = redditCustomList;
        this.mContext = mContext;

    }

    public void setRedditCustomList(List<RedditCustom> redditCustomList) {
        mRedditCustomList = redditCustomList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rest_item_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(mRedditCustomList.get(position).getTitle());
        holder.subtitleTextView.setText(mRedditCustomList.get(position).getAuthor() + " - " +
                mRedditCustomList.get(position).getSubreddit());
        holder.subtitle2TextView.setText(mRedditCustomList.get(position).getComments() + " points - " +
                mRedditCustomList.get(position).getPoints() + " comments");


        String imageUrl = mRedditCustomList.get(position).getThumbnail();
        if(TextUtils.isEmpty(imageUrl)) {
            Glide.clear(holder.thumbnailImageView);
        } else {
            Glide.with(mContext)
                    .load(mRedditCustomList.get(position).getThumbnail())
                    .centerCrop()
                    .into(holder.thumbnailImageView);
        }
    }

    @Override
    public int getItemCount() {
        if(mRedditCustomList == null){
            return 0;
        } else {
            return mRedditCustomList.size();
        }
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
