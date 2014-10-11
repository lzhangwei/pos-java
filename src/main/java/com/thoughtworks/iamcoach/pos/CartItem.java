package com.thoughtworks.iamcoach.pos;

public class CartItem {
    private Item item;
    private double num;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CartItem(Item item, double num) {
        this.item = item;
        this.num = num;
    }
}
