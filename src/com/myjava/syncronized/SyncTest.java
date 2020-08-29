package com.myjava.syncronized;

public class SyncTest extends Thread {
    private static Integer syncObj = 0;
    private static SyncTest[] threads = new SyncTest[10];

    private boolean done = false;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (syncObj) {
                syncObj++;
            }
        }
        done = true;
    }

    public static void main(String[] args) {

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SyncTest();
            threads[i].start();
        }

        while (!allDone())
            ; //wait until all threads finished

        System.out.println(syncObj);
    }

    private static boolean allDone() {
        boolean done = true;
        for (int i = 0; i < threads.length; i++) {
            done &= threads[i].done;
        }

        return done;
    }
}
