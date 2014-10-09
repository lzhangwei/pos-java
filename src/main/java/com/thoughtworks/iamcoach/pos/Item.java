package com.thoughtworks.iamcoach.pos;

/**
 * Created by zhangwei on 14-10-9.
 */
public class Item {
    private int id;
    private String barcode;
    private String name;
    private Category category;
    private String unit;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Item(int id, String barcode, String name, Category category, String unit, double price) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.price = price;
    }
}
