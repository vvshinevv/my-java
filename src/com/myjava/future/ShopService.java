package com.myjava.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;

public class ShopService {
    private static List<Shop> shops = Arrays.asList(
            new Shop("1 상점"),
            new Shop("2 상점"),
            new Shop("3 상점"),
            new Shop("4 상점"),
            new Shop("5 상점"),
            new Shop("6 상점")
    );

    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> {
                    System.out.println(Thread.currentThread().getName() + " " + Runtime.getRuntime().availableProcessors());
                    return String.format("%s price is %.2f", shop.getName(), shop.getPrice(product));
                })
                .collect(Collectors.toList());
    }

    public List<String> findPricesStreamCombiningFuture(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public List<String> findPricesStreamDividingFuture(String product) {
        List<CompletableFuture<String>> futures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
                .collect(Collectors.toList());

        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public List<String> findPricesWithForkJoinPoolAndStream(String product) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        ForkJoinTask<List<String>> submit = forkJoinPool.submit(() -> shops.stream()
                .map(shop -> String.format("%s price is %.2f $s", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList()));

        return new ArrayList<>(submit.join());
    }

    public List<String> findPricesWithForJoinPoolAndParallelStream(String product) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        ForkJoinTask<List<String>> submit = forkJoinPool.submit(() -> shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f $s", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList()));

        return new ArrayList<>(submit.join());
    }

    public List<String> findPricesWithCompletableFutureAndForkJoinPool(String product) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        ForkJoinTask<List<CompletableFuture<String>>> submit = forkJoinPool.submit(() -> shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)), forkJoinPool))
                .collect(Collectors.toList()));

        return submit.join().stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public void asyncTask() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
                return "task";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }).join();
    }
}
