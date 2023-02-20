package org.assimbly.soap.util.helpers;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public enum ConfigHelper {
    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger(ConfigHelper.class);
    private static final String PID = "org.assimbly.soap";

    private static ConfigurationAdmin configAdmin;

    public static String getProperty(String name) throws IOException {
        Configuration config = configAdmin.getConfiguration(PID);

        return (String) config.getProperties().get(name);
    }

    public void setConfigAdmin(ConfigurationAdmin configurationAdmin) {
        configAdmin = configurationAdmin;
    }
}
