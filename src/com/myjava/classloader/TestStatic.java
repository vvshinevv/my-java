package com.myjava.classloader;

/**
 * static 변수 초기화는 클래스 로드 시점에 한번 실행돼서 JVM에 올라간다고 알고 있는데,
 * 만약 ClassLoader가 여러 개라면 각 ClassLoader마다 static 변수를 초기화 한다.
 *
 * 즉 ClassLoader가 2개 있다고 가정하면
 * static 변수는 총 2번 초기화가 된다.
 *
 * 야래 예시 코드 참고
 * 각 클래스 로더에 의해서 가져온 인스터스는 독립적이다.
 *
 */
public class TestStatic {
    public static void main(String[] args) throws Exception {

        JiaClassLoader loader1 = new JiaClassLoader();
        JiaClassLoader loader2 = new JiaClassLoader();
        if (loader1.equals(loader2)) {
            System.out.println("two classloaders are same");
        } else {
            System.out.println("two classloaders are different");
        }

        Class clsA = Class.forName("com.myjava.classloader.AStatic", true, loader1);
        Class clsB = Class.forName("com.myjava.classloader.AStatic", true, loader2);

        System.out.println("com.myjava.classloader.AStatic: " + clsA);
        System.out.println("com.myjava.classloader.AStatic: " + clsB);

        Object instanceA = clsA.newInstance();
        Object instanceB = clsB.newInstance();

        if (clsA.equals(clsB)) {
            System.out.println("class loaded in different customer classloader are same");
        } else {
            System.out.println("class loaded in different customer classloader are different.");
        }

        clsA.getMethod("setYiyu", int.class).invoke(instanceA, 1);
        clsA.getMethod("printYiyu", String.class).invoke(instanceA, "instanceA");
        clsB.getMethod("printYiyu", String.class).invoke(instanceB, "instanceB");

    }
}
