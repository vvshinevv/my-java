package com.myjava.future;

import java.util.List;

public class ShopMain {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        long start = System.nanoTime();
        List<String> message = shopService.findPricesWithForJoinPoolAndParallelStream("건전지");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println(message);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
    }
}
