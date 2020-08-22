package com.myjava.classloader;

/**
 * Java class which is not used in this program, consequently not loaded by JVM
 */
public class NotUsed {
    static {
        System.out.println("NotUsed Class is initialized ");
    }
}
