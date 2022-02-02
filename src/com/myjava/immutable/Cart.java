package com.myjava.immutable;

import java.util.List;

public class Cart<T> {
    private final List<T> items;

    public Cart(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public int total() {
        return 0;
    }
}
