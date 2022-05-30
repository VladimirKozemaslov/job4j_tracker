package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] arrLeft = left.toCharArray();
        char[] arrRight = right.toCharArray();
        char[] arr = arrLeft.length < arrRight.length ? arrLeft : arrRight;
        for (int i = 0; i < arr.length; i++) {
            if (arrLeft[i] > arrRight[i]) {
                return 1;
            } else if (arrLeft[i] < arrRight[i]) {
                return  -1;
            }
        }
        if (arrLeft.length == arrRight.length) {
            return 0;
        } else {
            return -1;
        }
    }
}