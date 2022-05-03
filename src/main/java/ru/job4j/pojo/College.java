package ru.job4j.pojo;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Kozemaslov Vladimir Sergeevich");
        student.setGroup(1);
        student.setBeginDate(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Имя студента " + student.getName() + ", группа " + student.getGroup() + ", дата начала обучения " + student.getBeginDate().format(formatter));
    }
}