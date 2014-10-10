package com.thoughtworks.iamcoach.pos;

import java.util.LinkedList;

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

    public void addItem(Item item) {
        int tag = 0;
        for (int i = 0; i < cartItemList.size(); i++) {
            if (cartItemList.get(i).getItem().getId() == item.getId()) {
                int num = cartItemList.get(i).getNum();
                cartItemList.get(i).setNum(num + 1);
                tag = 1;
                break;
            }
        }
        if (tag == 0) {
            cartItemList.push(new CartItem(item, 1));
        }
    }
}
