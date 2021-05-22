package com.myjava.properties;

import java.util.Enumeration;
import java.util.Properties;

public class PropertyTest {

    public static void main(String[] args) {
        Properties properties = System.getProperties();

        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = (String) properties.get(key);
            System.out.println("# " + key + " : " + value);
        }
    }
}
