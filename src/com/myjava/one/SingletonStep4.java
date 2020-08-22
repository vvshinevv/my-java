package com.myjava.one;

import java.util.Vector;

public class SingletonStep4 {

    private static SingletonStep4 instance;
    private Vector<String> v;
    private boolean inUse;

    private SingletonStep4() {
        v = new Vector<>();
        v.addElement("test");
        inUse = true;
    }

    public static SingletonStep4 getInstance() {
        if (instance == null) {
            synchronized (SingletonStep4.class) { // 1
                if (instance == null) {  // 2
                    instance = new SingletonStep4(); // 3
                }
            }
        }
        return instance;
    }
}