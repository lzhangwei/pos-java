package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PosTest {

    @Test
    public void parse_barcode_test() {
        List<String> barcodes = new ArrayList<String>();
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000003-2");
        barcodes.add("ITEM000005");
        barcodes.add("ITEM000005");
        barcodes.add("ITEM000005");
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.add(new CartItem(new Item(1, "ITEM000001", "雪碧","瓶",3.00),5));
        cartItems.add(new CartItem(new Item(3, "ITEM000003", "荔枝","千克",15.00),2));
        cartItems.add(new CartItem(new Item(5, "ITEM000005", "方便面","袋",2.50),3));
        Pos pos = new Pos();
        pos.parseBarcode(barcodes);
        assertThat(pos.getCartItems.size()).isEqualTo(3);
    }

    @Test
    public void calculate_free_promotion_test() {
        List<String> barcodes = new ArrayList<String>();
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000003-2");
        barcodes.add("ITEM000005");
        barcodes.add("ITEM000005");
        barcodes.add("ITEM000005");
        List<String> freeBarcodes = new ArrayList<String>();
        freeBarcodes.add("ITEM000001");
        freeBarcodes.add("ITEM000003");
        freeBarcodes.add("ITEM000005");
        Pos pos = new Pos();
        pos.parseBarcode(barcodes);
        pos.calFreePromotion(freeBarcodes);
        assertThat(pos.getCartItems.size()).isEqualTo(3);
        assertThat(pos.getCartItems.get(1).getSumPrice()).isEqualTo(15);
        assertThat(pos.getCartItems.get(1).getPromotionPrice()).isEqualTo(3);
    }

    
}
