package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private int group;
    private LocalDateTime beginDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime date) {
        this.beginDate = date;
    }
}
