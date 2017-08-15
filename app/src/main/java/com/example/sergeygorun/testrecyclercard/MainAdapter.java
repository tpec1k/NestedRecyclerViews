package com.example.sergeygorun.testrecyclercard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergeygorun.testrecyclercard.holders.ItemHolder;
import com.example.sergeygorun.testrecyclercard.holders.VoidHolder;

import java.util.List;

/**
 * Created by sergeygorun on 8/14/17.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MainActivity.Item> items;
    private View header;
    private View horizontalList;

    private final int TYPE_HEADER = 1;
    private final int TYPE_LIST_HORIZONTAL = 2;
    private final int TYPE_ITEM = 3;

    private LayoutInflater inflater;
    MainAdapter(Context context, List<MainActivity.Item> items) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new VoidHolder(header);
        } else if (viewType == TYPE_LIST_HORIZONTAL) {
            return new VoidHolder(horizontalList);
        } else if (viewType == TYPE_ITEM) {
            View item = inflater.inflate(R.layout.item_title_layout_2, null);
            return new ItemHolder(item);
        }

        throw new IllegalStateException("Unknown ViewType");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_ITEM) {
            ItemHolder itemHolder = (ItemHolder) holder;
            itemHolder.bind(getItem(position));
        }
    }

    MainActivity.Item getItem(int pos) {
        if (header != null) {
            pos =  pos -1;
        }
        if (horizontalList != null) {
            pos = pos - 1;
        }

        return items.get(pos);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (header != null) {
            count++;
        }
        if (horizontalList != null) {
            count++;
        }
        if (items == null) {
            return count;
        }
        return count + items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (header != null && position == 0) {
            return TYPE_HEADER;
        } else if (header != null && horizontalList != null && position == 1
                || header == null && horizontalList != null && position == 0){
            return TYPE_LIST_HORIZONTAL;
        } else {
            return TYPE_ITEM;
        }
    }

    public View getHeader() {
        return header;
    }

    public void setHeader(View header) {
        this.header = header;
    }

    public View getHorizontalList() {
        return horizontalList;
    }

    public void setHorizontalList(View horizontalList) {
        this.horizontalList = horizontalList;
    }

    public void update(List<MainActivity.Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
