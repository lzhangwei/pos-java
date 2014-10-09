package com.thoughtworks.iamcoach.pos;

import java.util.LinkedList;

/**
 * Created by zhangwei on 14-10-9.
 */
public class Cart {
    private LinkedList<CartItem> cartItemList;

    public LinkedList<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(LinkedList<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public Cart() {
        this.cartItemList = new LinkedList<CartItem>();
    }
}
