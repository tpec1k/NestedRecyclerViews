package com.example.sergeygorun.testrecyclercard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        LayoutInflater inflater = LayoutInflater.from(this);
        View header = inflater.inflate(R.layout.view_recycler_header, null);
        header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(120)));

        View horizontalList = inflater.inflate(R.layout.view_recycler_list_horizontal, null);
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(this, produceItems());
        RecyclerView horizontalRecycler = (RecyclerView) horizontalList.findViewById(R.id.recycler_horizontal);
        horizontalRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalRecycler.setAdapter(horizontalAdapter);

        MainAdapter mainAdapter = new MainAdapter(this, produceItems());
        mainAdapter.setHeader(header);
        mainAdapter.setHorizontalList(horizontalList);

        recyclerView.setAdapter(mainAdapter);
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private List<Item> produceItems() {
        List<Item> result = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Item item = new Item();
            item.title = "Title" + i;
            item.subtitle = "Subtitle item #" + i;
            result.add(item);
        }

        return result;
    }

    public static class Item {
        public String title;
        public String subtitle;
    }
}
