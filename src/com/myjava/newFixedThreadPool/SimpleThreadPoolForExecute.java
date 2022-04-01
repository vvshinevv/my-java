package com.myjava.newFixedThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class SimpleThreadPoolForExecute {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach(n -> executor.execute(() -> {
                    try {
                        sleep(300);
                        String threadName = Thread.currentThread().getName();
                        System.out.println("Hello " + threadName);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
        );
    }
}
