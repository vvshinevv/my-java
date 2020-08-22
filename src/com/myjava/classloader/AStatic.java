package com.myjava.classloader;

public class AStatic {
    public static int yiyu = -1;

    public static int getYiyu() {
        return yiyu;
    }

    public static void setYiyu(int yiyu) {
        AStatic.yiyu = yiyu;
    }

    public static void printYiyu(String instanceName) {
        System.out.println("The static member yiyu's value in "
                + instanceName + " is " + AStatic.yiyu);
    }
}
