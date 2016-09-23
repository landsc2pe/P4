package com.example.homin.p4.selectmode;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.dragselectrecyclerview.DragSelectRecyclerViewAdapter;
import com.example.homin.p4.R;

import java.util.List;

/**
 * Created by HOMIN on 2016-09-04.
 **/
public class ActionModeAdapter extends DragSelectRecyclerViewAdapter<ActionModeAdapter.ViewHolder> {
    public static final String TAG = ActionModeAdapter.class.getSimpleName();

    private final ClickListener mCallback;
    private List<Integer> list;
    private ViewGroup viewGroup;

    public interface ClickListener {
        void onClick(int index);

        void onLongClick(int index);
    }

    // Constructor takes click listener callback
    protected ActionModeAdapter(ClickListener callback, List<Integer> list) {
        super();
        mCallback = callback;
        this.list = list;
    }


    @Override
    public ActionModeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mode_item_viewholder, parent, false);
        viewGroup = parent;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        holder.textView.setText(list.get(position).toString());
        if (isIndexSelected(position)) {
            // Item is selected, change it somehow
            holder.textView.setBackgroundColor(viewGroup.getResources().getColor(R.color.colorGreen));
        } else {
            // Item is not selected, reset it to a non-selected state
            holder.textView.setBackgroundColor(viewGroup.getResources().getColor(R.color.colorWhite));
        }
    }

    @Override
    protected boolean isIndexSelectable(int index) {
        return true;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView textView;

        public ViewHolder(final View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.item_mode_text);
            this.itemView.setOnClickListener(this);
            this.itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Forwards to the adapter's constructor callback
            if (mCallback != null) mCallback.onClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            // Forwards to the adapter's constructor callback
            if (mCallback != null) mCallback.onLongClick(getAdapterPosition());
            return true;
        }
    }
}