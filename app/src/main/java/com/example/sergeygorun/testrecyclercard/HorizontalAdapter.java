package com.example.sergeygorun.testrecyclercard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergeygorun.testrecyclercard.holders.HorizontalItemHolder;

import java.util.List;

/**
 * Created by sergeygorun on 8/15/17.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MainActivity.Item> items;

    private LayoutInflater inflater;
    HorizontalAdapter(Context context, List<MainActivity.Item> items) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.item_title_layout, null);
        return new HorizontalItemHolder(item);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HorizontalItemHolder itemHolder = (HorizontalItemHolder) holder;
        itemHolder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
