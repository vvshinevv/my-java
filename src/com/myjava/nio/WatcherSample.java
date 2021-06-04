package com.myjava.nio;

public class WatcherSample {
    public static void main(String[] args) {
        WatcherThread thread = new WatcherThread("/Users/nhn/Project/my-java");
        thread.start();
    }
}
