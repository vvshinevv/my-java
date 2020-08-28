package com.myjava.syncronized;

import java.util.ArrayList;
import java.util.List;

public class SyncBlock1 {

    private List<Integer> mList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        SyncBlock1 syncblock1 = new SyncBlock1();
        System.out.println("Test start!");
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                syncblock1.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                syncblock1.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(syncblock1.mList.size());
        System.out.println("Test end!");

    }

    public void add(int val) {
        synchronized (SyncBlock1.class) {
            if (!mList.contains(val)) {
                mList.add(val);
            }
        }
    }
}
