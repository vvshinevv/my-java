package com.myjava.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {
    private final List<Listener> listeners = new ArrayList<>();

    public void subscribe(Listener listener) {
        listeners.add(listener);
    }

    public void unSubscribe(Listener listener) {
        listeners.remove(listener);
    }

    public void publish(Object message) {
        listeners.forEach(t -> t.handler(message));
    }
}
