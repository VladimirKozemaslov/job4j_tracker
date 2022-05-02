package ru.job4j.inheritance;

import java.util.Date;

public class Builder extends Engineer {
    private String helmetColor;

    public Builder(String name, String surname, String education, Date birthday, String specialization, String helmetColor) {
        super(name, surname, education, birthday, specialization);
        this.helmetColor = helmetColor;
    }

    public void whatHelmet() {
        System.out.println("I wear " + helmetColor + "helmet.");
    }
}
