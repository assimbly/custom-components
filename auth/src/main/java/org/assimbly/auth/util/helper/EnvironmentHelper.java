package org.assimbly.auth.util.helper;

public class EnvironmentHelper {

    private EnvironmentHelper() {
    }

    public static String get(String key, String defaultValue) {
        String value = System.getenv(key);

        return value != null && !value.isBlank()
                ? value
                : defaultValue;
    }

    public static int getInt(String key, int defaultValue) {
        String value = System.getenv(key);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
