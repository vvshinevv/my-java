package com.myjava.pattern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {

    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void register(String subject, Subscriber subscriber) {
        if (subscribers.containsKey(subject)) {
            subscribers.get(subject).add(subscriber);
        } else {
            List<Subscriber> subs = new ArrayList<>();
            subs.add(subscriber);
            subscribers.put(subject, subs);
        }
    }

    public void unregister(String subject, Subscriber subscriber) {
        if (subscribers.containsKey(subject)) {
            subscribers.get(subject).remove(subscriber);
        }
    }

    public void sendMessage(User user, String subject, String message) {
        if (subscribers.containsKey(subject)) {
            String userMessage = user.getName() + ": " + message;
            subscribers.get(subject).forEach(s -> s.handleMessage(userMessage));
        }
    }
}
