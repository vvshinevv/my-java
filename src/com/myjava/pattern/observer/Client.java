package com.myjava.pattern.observer;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("1");
        User user2 = new User("2");

        chatServer.register("오징어게임", user1);
        chatServer.register("오징어게임", user2);
        chatServer.register("디자인퍁천", user1);

        chatServer.sendMessage(user1, "오징어게임", "아.. 이름 기억났어...");

    }
}
