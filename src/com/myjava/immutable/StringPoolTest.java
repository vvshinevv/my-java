package com.myjava.immutable;

import java.nio.charset.StandardCharsets;

public class StringPoolTest {
    public static void main(String[] args) {
        String helloWorld = "HelloWorld";
        String world = "World";

        System.out.println((helloWorld == "HelloWorld") + " "); // t
        System.out.println((Other.helloWorld == helloWorld) + " "); // t

        System.out.println("== " + (helloWorld == ("Hello" + "World")) + " "); // t
        System.out.println("== " + (helloWorld == ("Hello" + world)) + " "); // f
        System.out.println(("Hello" + world).getClass().getName());
        System.out.println(("Hello" + "World").getClass().getName());

        System.out.println((helloWorld == ("Hello" + world).intern()) + " "); // t
        System.out.println(helloWorld == new String("HelloWorld")); // f


        String bc = "bc";
        System.out.println(("a" + "bc") == ("a" + bc));
        String a = TestInterface.aa;

        System.out.println(a);

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Hello").append("World");
        System.out.println(("HelloWorld") == append.toString());
    }


    static class Other {
        public static String helloWorld = "HelloWorld";
    }

}
