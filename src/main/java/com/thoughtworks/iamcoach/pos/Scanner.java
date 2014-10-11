package com.thoughtworks.iamcoach.pos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Scanner {

    public LinkedList<CartItem> readCartFile(Path path) {
        LinkedList<CartItem> result = new LinkedList<CartItem>();
        try {
            List<String> fileLines = Files.readAllLines(path);
            for (int i = 0; i < fileLines.size(); i++) {
                String[] barcode = fileLines.get(i).split("-");

            }
        } catch (Exception e) {
            System.out.print("throw IOException when read all lines!");
        }

        return result;
    }

}
