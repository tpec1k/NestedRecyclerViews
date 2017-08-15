package com.example.sergeygorun.testrecyclercard.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sergeygorun.testrecyclercard.R;
import com.example.sergeygorun.testrecyclercard.models.Item;

/**
 * Created by sergeygorun on 8/15/17.
 */

public class HorizontalItemHolder extends RecyclerView.ViewHolder {
    private TextView title;
    public HorizontalItemHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
    }

    public void bind(Item item) {
        title.setText(item.title);
    }
}