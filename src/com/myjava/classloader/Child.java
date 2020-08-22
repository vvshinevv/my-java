package com.myjava.classloader;

/**
 * Sub class of Parent, demonstrate when exactly sub class loading and initialization occurs.
 */
public class Child {
    static {
        System.out.println("static block of Sub class is initialized in Java ");
    }

    {
        System.out.println("non static blocks in sub class is initialized");
    }
}
