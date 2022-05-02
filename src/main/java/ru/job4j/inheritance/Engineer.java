package ru.job4j.inheritance;

import java.util.Date;

public class Engineer extends Profession {
    private String specialization;

    public Engineer(String name, String surname, String education, Date birthday, String specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public int makeCalculations(int a, int b) {
        if (specialization == "sumEngineer") {
            return a + b;
        }
        else {
            return a - b;
        }
    }
}
