package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                rsl[newSize] = items[i];
                newSize++;
            }
        }
        return Arrays.copyOf(rsl, newSize);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int newSize = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (Objects.equals(item.getName(), key)) {
                rsl[newSize] = item;
                newSize++;
            }
        }
        return Arrays.copyOf(rsl, newSize);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}