package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("The airplane takes off.");
    }

    @Override
    public void stop() {
        System.out.println("The plane is landing.");
    }
}
