package com.thoughtworks.iamcoach.pos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Scanner {

    private Load load;

    {
        this.load = new Load();
    }

    public LinkedList<CartItem> readCartFile() {
        Path path = Paths.get("../resources/cart.txt");
        LinkedList<CartItem> result = new LinkedList<CartItem>();
        try {
            List<String> fileLines = Files.readAllLines(path);
            for (int i = 0; i < fileLines.size(); i++) {
                String[] barcode = fileLines.get(i).split("-");
                CartItem cartItem = new CartItem(load.findItemByBarcode(barcode[0]),Integer.parseInt(barcode[1]));
                result.push(cartItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
