package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

public class Pos {

    private ArrayList<Item> items;
    private ArrayList<CartItem> cartItems;
    private double sumPrice;
    private double promotionPrice;

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    {
        this.items = new ArrayList<Item>();
        this.items.add(new Item(0, "ITEM000000", "可口可乐", "瓶", 3.00));
        this.items.add(new Item(1, "ITEM000001", "雪碧", "瓶", 3.00));
        this.items.add(new Item(2, "ITEM000002", "苹果", "瓶", 3.00));
        this.items.add(new Item(3, "ITEM000003", "荔枝", "瓶", 3.00));
        this.items.add(new Item(4, "ITEM000004", "电池", "瓶", 3.00));
        this.items.add(new Item(5, "ITEM000005", "方便面", "瓶", 3.00));
    }

    public void parseBarcode(List<String> barcodes) {
        cartItems = new ArrayList<CartItem>();
        for (int i = 0; i < barcodes.size(); i++) {
            String[] barcode = barcodes.get(i).split("-");
            for (int j = 0; j < items.size(); j++) {
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
                    i--;
                    break;
                }
            }
        }
    }

    public ArrayList<CartItem> calFreePromotion(List<String> freeBarcode) {
        ArrayList<CartItem> result = cartItems;
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < freeBarcode.size(); j++) {
                if (result.get(i).getItem().getBarcode().equals(freeBarcode.get(j))) {
                    result.get(i).setSumPrice(result.get(i).getNum() * result.get(i).getItem().getPrice());
                    double promotionPrice = (int) result.get(i).getNum() / 3 * result.get(i).getItem().getPrice();
                    result.get(i).setPromotionPrice(promotionPrice);
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<CartItem> calHalfPromotion(List<String> freeBarcode) {
        ArrayList<CartItem> result = cartItems;
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < freeBarcode.size(); j++) {
                if (result.get(i).getItem().getBarcode().equals(freeBarcode.get(j))) {
                    result.get(i).setSumPrice(result.get(i).getNum() * result.get(i).getItem().getPrice());
                    result.get(i).setPromotionPrice((int) result.get(i).getNum() / 2 * result.get(i).getItem().getPrice() / 2);
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<CartItem> calDiscountPromotion(List<String> freeBarcode) {
        ArrayList<CartItem> result = cartItems;
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < freeBarcode.size(); j++) {
                String[] barcode = freeBarcode.get(j).split(":");
                if (result.get(i).getItem().getBarcode().equals(barcode[0])) {
                    result.get(i).setSumPrice(result.get(i).getNum() * result.get(i).getItem().getPrice());
                    double discount = (100 - Integer.parseInt(barcode[1])) / 100.0;
                    result.get(i).setPromotionPrice(result.get(i).getNum() * result.get(i).getItem().getPrice() * discount);
                    break;
                }
            }
        }
        return result;
    }

    public double calSumPrice(ArrayList<CartItem> cartItems) {
        double result = 0;
        for (CartItem cartItem : cartItems) {
            result += cartItem.getSumPrice();
        }
        return result;
    }

    public double calSumPromotionPrice(ArrayList<CartItem> cartItems) {
        double result = 0;
        for (CartItem cartItem : cartItems) {
            result += cartItem.getPromotionPrice();
        }
        return result;
    }

    public void comparePrice(ArrayList<CartItem> cartItems1, ArrayList<CartItem> cartItems2, ArrayList<CartItem> cartItems3) {
        sumPrice = calSumPrice(cartItems1);
        promotionPrice = calSumPromotionPrice(cartItems1);
        if (calSumPromotionPrice(cartItems2) > promotionPrice) {
            cartItems = cartItems2;
            promotionPrice = calSumPromotionPrice(cartItems2);
        }
        if (calSumPromotionPrice(cartItems3) > promotionPrice) {
            cartItems = cartItems3;
            promotionPrice = calSumPromotionPrice(cartItems3);
        }
    }
}
