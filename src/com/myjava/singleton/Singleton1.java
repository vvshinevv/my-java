package com.myjava.singleton;

public class Singleton1 {

    private static final Singleton1 example = new Singleton1();

    private Singleton1() {
        System.err.println("example create");
    }

    public static Singleton1 getInstance() {
        System.err.println("getInstance");
        return example;
    }

    public static void commonsMethod() {
        System.err.println("commonsMethod");
    }
}
