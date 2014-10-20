package com.thoughtworks.iamcoach.pos;

public class CartItem {
    private Item item;
    private double num;
    private double sumPrice;
    private double promotionPrice;

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public double getSumPrice() {
        return num*item.getPrice();
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public CartItem(Item item, double num) {
        this.item = item;
        this.num = num;
    }
}
