package com.myjava.string;

public class StringTest1 {
    public static void main(String[] args) {
        String hello1 = new String("hello");
        String hello2 = hello1.intern();

        System.out.println(hello1);
        System.out.println(hello1 == hello2);
    }
}
