package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String left = o1.split("/")[0];
        String right = o2.split("/")[0];
        int rsl = right.compareTo(left);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}