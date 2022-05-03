package ru.job4j.pojo;

public class Book {
    private String name;
    private int pageAmount;

    public Book(String name, int pageAmount) {
        this.name = name;
        this.pageAmount = pageAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }
}
