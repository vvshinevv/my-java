package com.myjava.reflection;

public class ReflectionTest {

    public static void main(String[] args) {

        AClass aClass = new AClass();

        Class<? extends AClass> aClass1 = aClass.getClass();
        Class<? extends AClass> aClass2 = aClass.getClass();

        String name = aClass.getClass().getName();
        System.out.println(name);


    }
}
