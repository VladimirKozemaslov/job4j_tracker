package ru.job4j.tracker;

public class SingleTracker extends Tracker {
    private static Tracker tracker = null;

    private SingleTracker() {

    }

    public Tracker getInstance() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    @Override
    public Item[] findAll() {
        return tracker.findAll();
    }

    @Override
    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    @Override
    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    @Override
    public boolean delete(int id) {
        return tracker.delete(id);
    }
}