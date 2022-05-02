package ru.job4j.inheritance;

import java.util.Date;

public class Programmer extends Engineer {
    private String progLanguage;

    public Programmer(String name, String surname, String education, Date birthday, String specialization, String progLanguage) {
        super(name, surname, education, birthday, specialization);
        this.progLanguage = progLanguage;
    }

    public void printHelloWorld() {
        System.out.println("Hello world from " + progLanguage + "!");
    }
}
