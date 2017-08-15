package com.example.sergeygorun.testrecyclercard.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergeygorun.testrecyclercard.R;
import com.example.sergeygorun.testrecyclercard.holders.NestedVerticalRecyclerHolder;
import com.example.sergeygorun.testrecyclercard.holders.VoidHolder;
import com.example.sergeygorun.testrecyclercard.models.Item;

import java.util.List;

/**
 * Created by sergeygorun on 8/14/17.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_HEADER = 1;
    private final int TYPE_LIST_HORIZONTAL = 2;
    private final int TYPE_NESTED_RECYCLER = 3;

    private LayoutInflater inflater;
    private Context context;
    public MainAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View header = inflater.inflate(R.layout.view_recycler_header, parent, false);
            return new VoidHolder(header);
        } else if (viewType == TYPE_LIST_HORIZONTAL) {
            View horizontalList = inflater.inflate(R.layout.view_recycler_list_horizontal, parent, false);
            HorizontalAdapter horizontalAdapter = new HorizontalAdapter(context, Item.Helper.produceItems(20));
            RecyclerView horizontalRecycler = (RecyclerView) horizontalList.findViewById(R.id.recycler);
            horizontalRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            horizontalRecycler.setAdapter(horizontalAdapter);
            return new VoidHolder(horizontalList);
        } else if (viewType == TYPE_NESTED_RECYCLER) {
            View layout = inflater.inflate(R.layout.view_recycler_list_horizontal, parent, false);
            RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(new CardAdapter(context));
            return new VoidHolder(layout);
        }

        throw new IllegalStateException("Unknown ViewType");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == 1 ){
            return TYPE_LIST_HORIZONTAL;
        } else {
            return TYPE_NESTED_RECYCLER;
        }
    }

    class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        CardAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layout = inflater.inflate(R.layout.view_recycler_list_horizontal, parent, false);
            return new NestedVerticalRecyclerHolder(layout);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            //we need fill in nested vertical recyclers here
            NestedVerticalRecyclerHolder h = (NestedVerticalRecyclerHolder) holder;
            h.bind(Item.Helper.produceItems(20));
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

}
