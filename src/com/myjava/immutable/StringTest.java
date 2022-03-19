package com.myjava.immutable;

public class StringTest {
    public static void main(String[] args) {
        StringTest st = new StringTest();
        st.stringTest("hello world");
    }

    public void stringTest(String helloWorld) {
        StringTestArea sta = new StringTestArea();
        System.out.println(sta.testString() == helloWorld);
    }
}
