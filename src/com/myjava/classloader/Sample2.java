package com.myjava.classloader;

/**
 * https://stackoverflow.com/questions/8704423/when-are-static-variables-initialized
 *
 */
public class Sample2 {
    private static Sample2 sample2 = new Sample2();
    private static final Object obj = new Object();

    private Sample2() {
        System.out.println(obj); // print null
    }

    public static void main(String[] args) {

    }
}
