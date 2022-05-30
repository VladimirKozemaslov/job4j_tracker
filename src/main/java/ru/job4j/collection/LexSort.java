package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(getNum(left), getNum(right));
    }

    private static int getNum(String str) {
        String[] arr = str.split(" ")[0].split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String digit : arr) {
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }
}