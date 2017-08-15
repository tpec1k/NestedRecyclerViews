package com.example.sergeygorun.testrecyclercard.models;

import java.util.ArrayList;
import java.util.List;

public class Item {
    public String title;
    public String subtitle;

    public static class Helper {
        public static List<Item> produceItems(int n) {
            List<Item> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                Item item = new Item();
                item.title = "Title" + i;
                item.subtitle = "Subtitle item #" + i;
                result.add(item);
            }

            return result;
        }
    }
}