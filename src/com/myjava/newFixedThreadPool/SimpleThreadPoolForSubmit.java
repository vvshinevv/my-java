package com.myjava.newFixedThreadPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleThreadPoolForSubmit {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Future<Integer> future = executor.submit(() -> integers.stream().mapToInt(i -> i).sum());

        try {
            Integer result = future.get();
            System.out.print("result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        CompletableFuture<String> completedFuture = CompletableFuture.supplyAsync(() -> "hello", executor);
        String get = completedFuture.get();
        System.out.println(get);

        List<CompletableFuture<String>> multi = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            int finalI = i;

            CompletableFuture<String> ind = CompletableFuture.supplyAsync(() -> {
                        System.out.print(finalI + " ");
                        if (finalI == 6) {
                            System.out.print("aa");
                            throw new RuntimeException();
                        }
                        return "hello " + finalI;
                    }, executor)
                    .exceptionally(throwable -> "Stranger"); // 예외처리

            multi.add(ind);
        }

        CompletableFuture.allOf(multi.toArray(new CompletableFuture[0])).join();
        for (CompletableFuture<String> mul : multi) {
            System.out.println(mul.get());
        }
    }
}
