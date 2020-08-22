package com.myjava.classloader;

public class SingleSingle {
    private static SingleSingle ourInstance = new SingleSingle();

    public static SingleSingle getInstance() {
        return ourInstance;
    }

    private SingleSingle() {
    }
}
