package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;

public class Load {
    private ArrayList<Item> items;
    private ArrayList<Category> categories;

    {
        this.items.set(0, new Item(0, "ITEM000000", "可口可乐", new Category(0, "饮料"), "瓶", 3.00));
        this.items.set(1, new Item(1, "ITEM000001", "雪碧", new Category(0, "饮料"), "瓶", 3.00));
        this.items.set(2, new Item(2, "ITEM000002", "苹果", new Category(1, "水果"), "瓶", 3.00));
        this.items.set(3, new Item(3, "ITEM000003", "荔枝", new Category(1, "水果"), "瓶", 3.00));
        this.items.set(4, new Item(4, "ITEM000004", "电池", new Category(2, "生活用品"), "瓶", 3.00));
        this.items.set(5, new Item(5, "ITEM000005", "方便面", new Category(3, "食品"), "瓶", 3.00));

        this.categories.set(0, new Category(0, "饮料"));
        this.categories.set(1, new Category(1, "水果"));
        this.categories.set(2, new Category(2, "生活用品"));
        this.categories.set(3, new Category(3, "食品"));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

}
