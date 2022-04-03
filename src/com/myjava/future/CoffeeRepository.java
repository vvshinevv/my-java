package com.myjava.future;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CoffeeRepository {

    private static Map<String, Coffee> cache = new HashMap<>();

    static {
        cache.put("latte", new Coffee("latte", 1000));
        cache.put("mocha", new Coffee("mocha", 2000));
        cache.put("americano", new Coffee("americano", 500));
    }


    public int getPriceByName(String name) {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return cache.get(name).getPrice();
    }
}
