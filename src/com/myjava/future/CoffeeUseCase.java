package com.myjava.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface CoffeeUseCase {
    int getPrice(String name); // 동기
    CompletableFuture<Integer> getPriceAsync(String name); // 비동기
    CompletableFuture<Integer> getDiscountPriceAsync(String name); // 비동기
}
