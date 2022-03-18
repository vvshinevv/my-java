package com.myjava.deepclone;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("1", new Car("benz", 1));
        Student s2 = new Student("2", new Car("bmw", 1));



        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        List<Student> clone = new ArrayList<>(studentList); // shallow copy

        System.out.println(studentList.get(0).equals(clone.get(0)));
        System.out.println(studentList.get(0) == clone.get(0));

        studentList.get(0).getCar().setBrand("audi");
        System.out.println(clone.get(0).getCar().getBrand());
    }
}
