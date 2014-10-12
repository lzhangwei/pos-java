package com.thoughtworks.iamcoach.pos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Promotion {

    public List<String> readBuyTwoGetOneFile(Path path) {
        List<String> result = new ArrayList<String>();
        try {
            List<String> fileLines = Files.readAllLines(path);
            for (int i = 0; i < fileLines.size(); i++) {
                result.set(i, fileLines.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> readSecondHalfPriceFile(Path path) {
        List<String> result = new ArrayList<String>();
        try {
            List<String> fileLines = Files.readAllLines(path);
            for (int i = 0; i < fileLines.size(); i++) {
                result.set(i, fileLines.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
