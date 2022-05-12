package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(key, value[i])) {
                return i;
            }
        }
        throw new ElementNotFoundException("Данного элемента в массиве нет.");
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"Раз", "Два", "Три"}, "Четыре");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}