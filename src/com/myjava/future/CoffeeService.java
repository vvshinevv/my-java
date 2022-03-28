package com.myjava.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CoffeeService implements CoffeeUseCase {

    private final Executor executor;
    private final CoffeeRepository coffeeRepository;

    public CoffeeService() {
        this.executor = Executors.newFixedThreadPool(10);
        this.coffeeRepository = new CoffeeRepository();
    }

    @Override
    public int getPrice(String name) {
        System.out.println("동기 호출 방식으로 가격 조회 시작");
        return coffeeRepository.getPriceByName(name);
    }

    @Override
    public CompletableFuture<Integer> getPriceAsync(String name) {
        System.out.println("비동기 호출 방식으로 가격 조회 시작");
        CompletableFuture<Integer> future = new CompletableFuture<>();
        executor.execute(() -> {
            System.out.println(executor + ":: 새로운 쓰레드로 작업 시작");
            int price = coffeeRepository.getPriceByName(name);
            future.complete(price);
        });

        return future;
    }

    @Override
    public CompletableFuture<Integer> getDiscountPriceAsync(String name) {
        return null;
    }
}
