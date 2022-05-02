package ru.job4j.inheritance;

import java.util.Date;

public class Doctor extends Profession {
    private int degree;

    public Doctor(String name, String surname, String education, Date birthday, int degree) {
        super(name, surname, education, birthday);
        this.degree = degree;
    }

    public Diagnosis heal(Pacient pacient) {
        return pacient.diagnosis;
    }
}
