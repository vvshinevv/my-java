package com.myjava.syncronized;

public class BasicSynchronization {
    private String mMessage;

    public static void main(String[] args) {
        BasicSynchronization tmp = new BasicSynchronization();

        System.out.println("Thread Start!!");

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                tmp.callMe("Thread 1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                tmp.callMe("Thread 2");
            }
        }).start();
    }

    public void callMe(String whoCallMe) {
        mMessage = whoCallMe;
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!mMessage.equals(whoCallMe)) {
            System.out.println(whoCallMe + " | " + mMessage);
        }
    }

}
