package com.myjava.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CopyTest {
    public static void main(String[] args) {
        List<Name> names = new ArrayList<>();
        names.add(new Name(1, "a"));
        names.add(new Name(2, "b"));

        List<Name> unmodifiableList = (names);
        names.add(new Name(3, "c"));

        names.get(0).setName("aaa");

        for (Name name : unmodifiableList) {
            System.out.println(name.getName());
        }

        System.out.println(names.size());
        System.out.println(unmodifiableList.size());
    }
}
