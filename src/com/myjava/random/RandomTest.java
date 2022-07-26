package com.myjava.random;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random(1);
        IntStream.range(0, 1).forEach(i -> System.out.println(random.nextInt(10)));

    }
}
