package com.myjava.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class NoticeMessageListener implements Listener {
    private final List<User> users = new ArrayList<>();

    @Override
    public void handler(Object event) {
        if (!(event instanceof NoticeMessage)) {
            return;
        }

        users.add(new User("1"));
        users.add(new User("2"));
        for (User user : users) {
            System.out.println(user.getName() + ": " + ((NoticeMessage) event).getMessage());
        }
    }
}
