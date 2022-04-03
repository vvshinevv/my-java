package com.myjava.thread;

import com.myjava.future.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadLocal<Coffee> threadLocal = new ThreadLocal<>();
        threadLocal.set(new Coffee(Thread.currentThread().getName(), 1));
        Coffee coffee = threadLocal.get();
        System.out.println(coffee);


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<CompletableFuture<Coffee>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            CompletableFuture<Coffee> completableFuture = CompletableFuture.supplyAsync(() -> {
                threadLocal.set(new Coffee(Thread.currentThread().getName(), finalI));
                return threadLocal.get();
            }, executorService);

            list.add(completableFuture);
        }

        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        for (CompletableFuture<Coffee> com : list) {
            Coffee coffee1 = com.get();
            System.out.println(coffee1);
        }
    }
}
