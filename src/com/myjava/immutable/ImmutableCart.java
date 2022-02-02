package com.myjava.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableCart<T> {
    private final List<T> items;

    public ImmutableCart(List<T> items) {
        this.items = new ArrayList<T>(items);
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int total() {
        return 0;
    }

}
