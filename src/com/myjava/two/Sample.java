package com.myjava.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {


    public static void main(String[] args) {
        //String result = solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        boolean result = solution(new String[]{"12","123","1235","567","88"});
        System.out.println(result);
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String ph1 = phone_book[i];
            String ph2 = phone_book[i + 1];
            if (ph2.startsWith(ph1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean compare(String ph1, String ph2) {

        char[] chs1 = ph1.toCharArray();
        char[] chs2 = ph2.toCharArray();

        if (chs1.length <= chs2.length) {
            for (int i = 0; i < chs1.length; i++) {
                if (chs1[i] != chs2[i]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < chs2.length; i++) {
                if (chs2[i] != chs1[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String solution(String[] participant, String[] completion) {
        List<String> pList = Arrays.stream(participant).sorted(String::compareTo).collect(Collectors.toList());
        List<String> cList = Arrays.stream(completion).sorted(String::compareTo).collect(Collectors.toList());

        for (int i = 0; i < cList.size(); i++) {

            if (!pList.get(i).equals(cList.get(i))) {
                return pList.get(i);
            }
        }

        return pList.get(pList.size() - 1);
    }
}
