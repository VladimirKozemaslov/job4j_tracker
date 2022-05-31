package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lengthComp = Integer.compare(left.length(), right.length());
        String str = lengthComp < 0 ? left : right;
        for (int i = 0; i < str.length(); i++) {
            int charComp = Character.compare(left.charAt(i), right.charAt(i));
            if (charComp != 0) {
                return charComp;
            }
        }
        return lengthComp == 0 ? 0 : -1;
    }
}