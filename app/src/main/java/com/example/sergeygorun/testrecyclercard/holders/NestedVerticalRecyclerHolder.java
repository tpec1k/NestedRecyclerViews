package com.example.sergeygorun.testrecyclercard.holders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sergeygorun.testrecyclercard.adapters.NesterVerticalAdapter;
import com.example.sergeygorun.testrecyclercard.R;
import com.example.sergeygorun.testrecyclercard.models.Item;

import java.util.List;

/**
 * Created by sergeygorun on 8/15/17.
 */

public class NestedVerticalRecyclerHolder extends RecyclerView.ViewHolder {
    private RecyclerView recycler;
    public NestedVerticalRecyclerHolder(View itemView) {
        super(itemView);
        recycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(recycler.getContext(), LinearLayoutManager.VERTICAL, false));
    }

    public void bind(List<Item> items) {
        recycler.setAdapter(new NesterVerticalAdapter(recycler.getContext(), items));
    }
}