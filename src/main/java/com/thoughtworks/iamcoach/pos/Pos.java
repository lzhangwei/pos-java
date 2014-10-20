package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;

public class Pos {
    public static final String CART_FILE = "../resources/cart.txt";
    public static final String FREE_FILE = "../resources/buy_two_get_one_free_promotion.txt";
    public static final String HALF_FILE = "../resources/second_half_price_promotion.txt";
    public static final String DISCOUNT_FILE = "../resources/discount_promotion.txt";

    private ArrayList<Item> items;
    private ArrayList<CartItem> cartItems;
    private double sumPrice;
    private double promotionPrice;
    {
        this.items.set(0, new Item(0, "ITEM000000", "可口可乐", "瓶", 3.00));
        this.items.set(1, new Item(1, "ITEM000001", "雪碧", "瓶", 3.00));
        this.items.set(2, new Item(2, "ITEM000002", "苹果", "瓶", 3.00));
        this.items.set(3, new Item(3, "ITEM000003", "荔枝", "瓶", 3.00));
        this.items.set(4, new Item(4, "ITEM000004", "电池", "瓶", 3.00));
        this.items.set(5, new Item(5, "ITEM000005", "方便面", "瓶", 3.00));
    }


}
