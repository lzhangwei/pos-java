package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

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

    public void parseBarcode(List<String> barcodes) {
        cartItems = new ArrayList<CartItem>();
        for (int i = 0; i < barcodes.size(); i++) {
            String[] barcode = barcodes.get(i).split("-");
            for (int j = 0; j < items.size(); i++) {
                if (items.get(j).getBarcode().equals(barcode[0])) {
                    if (barcode.length == 1) {
                        cartItems.add(new CartItem(items.get(j), 1));
                    } else {
                        cartItems.add(new CartItem(items.get(j), Integer.parseInt(barcode[1])));
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < cartItems.size() - 1; i++) {
            for (int j = i + 1; j < cartItems.size(); j++) {
                if (cartItems.get(i).getItem().getBarcode().equals(cartItems.get(j).getItem().getBarcode())) {
                    CartItem cartItem = cartItems.get(i);
                    cartItem.setNum(cartItem.getNum() + cartItems.get(j).getNum());
                    cartItems.set(i, cartItem);
                    cartItems.remove(j);
                }
            }
        }
    }

    public ArrayList<CartItem> calFreePromotion(List<String> freeBarcode) {
        ArrayList<CartItem> result = cartItems;
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < freeBarcode.size(); j++) {
                if(result.get(i).getItem().getBarcode().equals(freeBarcode.get(j))) {
                    result.get(i).setSumPrice(result.get(i).getNum() * result.get(i).getItem().getPrice());
                    result.get(i).setSumPrice(result.get(i).getNum()/3 * result.get(i).getItem().getPrice());
                    break;
                }
            }
        }
        return result;
    }

}
