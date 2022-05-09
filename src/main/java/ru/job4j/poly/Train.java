package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("The train moves on.");
    }

    @Override
    public void stop() {
        System.out.println("The train stops.");
    }
}
