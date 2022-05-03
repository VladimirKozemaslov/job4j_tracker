package ru.job4j.inheritance;

import java.util.Date;

public class Dentist extends Doctor {
    private boolean certificated;

    public Dentist(String name, String surname, String education, Date birthday, int degree, boolean certificated) {
        super(name, surname, education, birthday, degree);
        this.certificated = certificated;
    }

    public void toothRepair() {
        if (certificated) {
            System.out.println("I know what i'm doing.");
        } else {
            System.out.println("So help me God.");
        }
    }
}
