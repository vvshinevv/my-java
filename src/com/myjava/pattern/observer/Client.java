package com.myjava.pattern.observer;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.subscribe(new NoticeMessageListener());
        applicationContext.publish(new NoticeMessage("공지사항"));
    }
}
