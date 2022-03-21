package com.myjava.immutable;

public class CloneTest {
    public static void main(String[] args) {
        Department dept = new Department(1, "HR");
        Employee original = new Employee(1, "admin", dept);

        Employee clone = original.clone();
        clone.getDepartment().setName("FINANCE");

        System.out.println(original.getDepartment().getName());
        System.out.println(clone.getDepartment().getName());


    }
}
