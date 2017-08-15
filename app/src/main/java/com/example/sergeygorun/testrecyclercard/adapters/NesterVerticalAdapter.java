package com.example.sergeygorun.testrecyclercard.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergeygorun.testrecyclercard.R;
import com.example.sergeygorun.testrecyclercard.holders.ItemHolder;
import com.example.sergeygorun.testrecyclercard.models.Item;

import java.util.List;

/**
 * Created by sergeygorun on 8/15/17.
 */

public class NesterVerticalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;
    private LayoutInflater inflater;

    public NesterVerticalAdapter(Context context, List<Item> items) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.item_title_layout_2, parent, false);
        return new ItemHolder(item);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        itemHolder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
