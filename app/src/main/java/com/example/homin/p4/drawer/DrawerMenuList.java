package com.example.homin.p4.drawer;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homin.p4.R;

/**
 * Created by HOMIN on 2016-12-15.
 **/

public class DrawerMenuList extends ArrayAdapter<DrawerMenuItem> {

    int resource;
    Activity activity;

    public DrawerMenuList(int resource, Activity activity, DrawerMenuItem[] items) {
        super(activity, resource, items);

        this.resource = resource;
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View getView (int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if(rowView == null) {
            rowView = activity.getLayoutInflater().inflate(resource, null);

            MenuItemViewHolder viewHolder = new MenuItemViewHolder();

            viewHolder.menuItemImageView = (ImageView)rowView.findViewById(R.id.menu_item_image_view);
            viewHolder.menuItemTextView = (TextView)rowView.findViewById(R.id.menu_item_text_view);

            rowView.setTag(viewHolder);
        }

        MenuItemViewHolder holder = (MenuItemViewHolder)rowView.getTag();

        if(position == DrawerMenuItem.ITEM1.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.mipmap.ic_launcher));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.item1));
        }
        else if(position == DrawerMenuItem.ITEM2.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.mipmap.ic_launcher));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.item1));
        }
        else if(position == DrawerMenuItem.ITEM3.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.mipmap.ic_launcher));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.item1));
        }
        else if(position == DrawerMenuItem.ITEM4.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.mipmap.ic_launcher));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.item1));
        }
        else if(position == DrawerMenuItem.ITEM5.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.mipmap.ic_launcher));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.item1));
        }

        return rowView;
    }

    private static class MenuItemViewHolder {
        public ImageView menuItemImageView;
        public TextView menuItemTextView;
    }
}