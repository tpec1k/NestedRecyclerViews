package com.example.sergeygorun.testrecyclercard.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sergeygorun.testrecyclercard.R;
import com.example.sergeygorun.testrecyclercard.models.Item;

/**
 * Created by sergeygorun on 8/14/17.
 */

public class ItemHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView subtitle;
    public ItemHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        subtitle = (TextView) itemView.findViewById(R.id.subtitle);
    }

    public void bind(Item item) {
        title.setText(item.title);
        subtitle.setText(item.subtitle);
    }
}