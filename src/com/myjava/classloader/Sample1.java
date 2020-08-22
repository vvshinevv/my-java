package com.myjava.classloader;

public class Sample1 {

    /**
     * 컴파일 시 Byte code 가 linear 하게 생성이 되기 때문에,
     * generateListCode() 메소드에서 NullPoint Exception 이 발생
     */
    private static final String[] LIST_CODE = generateListCode();
    private static final int[][] LIST_INTEGER = new int[][] {
            { 947, 947 }, { 110, 103 },
            { 947, 958 }, { 110, 120 },
            { 947, 954 }, { 103, 107 },
            { 947, 967 }, { 110, 99, 104 } };

    public static void main(String[] args) {

    }

    private static String[] generateListCode() {
        String[] listCode = new String[LIST_INTEGER.length];

        for (int i = 0; i < LIST_INTEGER.length; i++) {
            //do some stuff
        }

        return listCode;
    }
}
