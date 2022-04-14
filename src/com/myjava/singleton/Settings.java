package com.myjava.singleton;

public class Settings {

    private static Settings settings;

    private Settings() {}

    public static Settings getInstance() {
        if (settings == null) {
            settings = new Settings();
        }

        return settings;

    }
}
