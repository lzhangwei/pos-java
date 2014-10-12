package com.thoughtworks.iamcoach.pos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Promotion {

    private Load load;

    {
        this.load = new Load();
    }

    public List<Item> readBuyTwoGetOneFile(Path path) {
        List<Item> result = new ArrayList<Item>();
        try {
            List<String> fileLines = Files.readAllLines(path);
            for (int i = 0; i < fileLines.size(); i++) {
                String barcode = fileLines.get(i);
                result.set(i, load.findItemByBarcode(barcode));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    
}
