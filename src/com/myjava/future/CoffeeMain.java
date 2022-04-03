package com.myjava.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CoffeeMain {
    public static void main(String[] args) {
        CoffeeUseCase coffeeUseCase = new CoffeeService();

//        System.out.println("========= 동기 호출 =========");
//        long beforeTime = System.currentTimeMillis();
//        int resultPrice = coffeeUseCase.getPrice("latte");
//        System.out.println(resultPrice);
//        long afterTime = System.currentTimeMillis();
//        printDuration(beforeTime, afterTime);
//        System.out.println("========= 동기 호출 =========");
//
//        System.out.println("========= 비동기 호출 with 블록킹 =========");
//        beforeTime = System.currentTimeMillis();
//        CompletableFuture<Integer> future = coffeeUseCase.getPriceAsync("latte");
//        System.out.println("아직 최종 데이터를 전달 받지는 않았지만, 다른 작업 수행 가능");
//        Integer price = future.join();// 블록킹
//        System.out.println("최종 가격 전달 받음 :: " + price);
//        afterTime = System.currentTimeMillis();
//        printDuration(beforeTime, afterTime);
//        System.out.println("========= 비동기 호출 with 블록킹 =========");
        CompletableFuture<Integer> latte = coffeeUseCase.getDiscountPriceAsync("latte");
        System.out.println("aaaa");

        while(latte.isDone()) {
            // 다른일..
        }
        // 다른일
        //
        Integer integer = latte.join();
        System.out.println(integer);
        System.out.println("bbbb");

//                .thenApplyAsync(p -> {
//                    System.out.println(Thread.currentThread().getName());
//                    return p + 100;
//                })
//                .thenAcceptAsync(p -> {
//                    System.out.println(Thread.currentThread().getName());
//                    System.out.println("money :: " + p);
//                });

//        ThreadLocal<String> thread = new ThreadLocal<>();
//        Thread.currentThread().getName();
//        thread.set("aa");

    }

    private static void printDuration(long before, long after) {
        long secDiffTime = (after - before) / 1000;
        System.out.println("시간차이(m) : " + secDiffTime);
    }
}
