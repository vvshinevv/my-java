package com.myjava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> result1 = imperativeStyle(numbers);
        Optional<Integer> result2 = functionalStyle(numbers);

        result1.ifPresent(System.out::println);
        result2.ifPresent(System.out::println);
    }

    private static Optional<Integer> imperativeStyle(List<Integer> numbers) {
        for (final Integer number : numbers) {
            System.out.println("number > 3");
            if (number > 3) {
                System.out.println("number * 2");
                final Integer newNumber = number * 2;
                System.out.println("number > 10");
                if (newNumber > 10) {
                    return Optional.of(newNumber);
                }
            }
        }
        return Optional.empty();
    }

    private static Optional<Integer> functionalStyle(List<Integer> numbers) {
        return numbers.stream()
                .filter((number) -> {
                    System.out.println("number > 3");
                    return number > 3;
                })
                .map((number) -> {
                    System.out.println("number * 2");
                    return number * 2;
                })
                .filter((number) -> {
                    System.out.println("number > 10");
                    return number > 10;
                })
                .findFirst();
    }
}
