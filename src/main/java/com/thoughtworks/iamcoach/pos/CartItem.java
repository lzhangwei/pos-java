package com.thoughtworks.iamcoach.pos;

/**
 * Created by zhangwei on 14-10-9.
 */
public class CartItem {
    private Item item;
    private int num;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CartItem(Item item, int num) {
        this.item = item;
        this.num = num;
    }
}
