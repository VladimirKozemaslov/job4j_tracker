package ru.job4j.tracker;

import ru.job4j.tracker.store.Store;

import java.util.List;

public class SingleTracker {
    private static SingleTracker instance = null;
    private Store memTracker = new MemTracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public boolean delete(int id) {
        return memTracker.delete(id);
    }
}