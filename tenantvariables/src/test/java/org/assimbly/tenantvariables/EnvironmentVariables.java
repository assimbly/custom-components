package org.assimbly.tenantvariables;

//Need this class because Mockito cannot mock java.lang.System's static methods.
public class EnvironmentVariables {
    public static String getEnv(String key) {
        return System.getenv(key);
    }
}