package com.example.sergeygorun.testrecyclercard.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergeygorun.testrecyclercard.MainActivity;
import com.example.sergeygorun.testrecyclercard.R;
import com.example.sergeygorun.testrecyclercard.holders.HorizontalItemHolder;
import com.example.sergeygorun.testrecyclercard.models.Item;

import java.util.List;

/**
 * Created by sergeygorun on 8/15/17.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;

    private LayoutInflater inflater;
    public HorizontalAdapter(Context context, List<Item> items) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.item_title_layout, parent, false);
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
