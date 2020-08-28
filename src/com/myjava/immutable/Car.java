package com.myjava.immutable;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
