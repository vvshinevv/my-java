package com.myjava.deepclone;

import java.util.Objects;

public class Student {
    private String name;
    private Car car;

    public Student(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(car, student.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, car);
    }
}
