package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void stop() {
        System.out.println("The bus stops.");
    }

    @Override
    public void move() {
        System.out.println("The bus moving.");
    }

    @Override
    public void takePassengers(int passengers) {
        System.out.printf("The bus take %d passengers", passengers);
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 50;
    }
}
