package com.myjava.sublist;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);


        List<Integer> sublist = integers.subList(0, 2);
        System.out.println(integers.size());
        System.out.println(sublist.size());


        List<Integer> test = new ArrayList<>(null);
    }
}
