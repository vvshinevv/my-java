package com.myjava.environment;

import java.util.Map;

public class EnvironmentTest {

    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();
        for (Map.Entry<String, String> entry : getenv.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println("# " + key + " : " + value);
        }
    }
}
