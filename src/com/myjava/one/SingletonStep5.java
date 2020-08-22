package com.myjava.one;

/**
 */
public class SingletonStep5 {

    private static SingletonStep5 instance;
    private boolean inUse;
    private int val;

    private SingletonStep5() {
        inUse = true;
        val = 5;
    }

    public static SingletonStep5 getInstance() {
        if (instance == null) {
            instance = new SingletonStep5();
        }
        return instance;
    }

}
