package com.myjava.thread;

public class Contribution {

    private static int amount = 0;

    public synchronized static void donate() {
        amount++;
    }

    public int getTotal() {
        return amount;
    }
}
