package ru.job4j.inheritance;

import java.util.Date;

public class Surgeon extends Doctor {
    private boolean isPlasticalSurgeon;

    public Surgeon(String name, String surname, String education, Date birthday, int degree, boolean isPlasticalSurgeon) {
        super(name, surname, education, birthday, degree);
        this.isPlasticalSurgeon = isPlasticalSurgeon;
    }

    public void correctFace() {
        if (isPlasticalSurgeon) {
            System.out.println("Face corrected");
        } else {
            System.out.println("I can't do it.");
        }
    }
}
