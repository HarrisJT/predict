package com.predict.data.util;

import java.util.Properties;

public class ConfigManager {

    private static final Properties APPLICATION_PROPERTIES;

    /**
     * Static utility class
     */
    private ConfigManager() { }

    static {
        // Try to load application properties
        Properties properties = new Properties();
        try {
            properties.load(ConfigManager.class.getResourceAsStream("/application.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        APPLICATION_PROPERTIES = properties;
    }

    public static String getProperty(String key) {
        return APPLICATION_PROPERTIES.getProperty(key);
    }
    public static void setProperty(String property) { APPLICATION_PROPERTIES.setProperty("category", property); }
}
