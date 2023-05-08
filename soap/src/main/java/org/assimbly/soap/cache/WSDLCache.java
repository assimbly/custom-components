package org.assimbly.soap.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

public enum WSDLCache {
    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger(WSDLCache.class);
    private static final String BASE_PATH = System.getProperty("user.home");
    private static final String ASSIMBLY_PATH = "/.assimbly";
    private static final String CACHE_SOAP_PATH = "/cache/soap-component/";

    // Key: URL, Value: UUID FileName
    private static final HashMap<String, UUID> locations = new HashMap<>();

    /**
     * Register wsdl file url to the locations map.
     *
     * @param url
     * @return Path to where the file should be written.
     */
    public File register(String url) {
        UUID uuid = UUID.randomUUID();

        locations.put(url, uuid);
        return new File(BASE_PATH + ASSIMBLY_PATH + CACHE_SOAP_PATH + uuid + ".wsdl");
    }

    public void remove(String url) {
        File file = getPath(url);
        boolean isDeleted = file.delete();

        if (isDeleted)
            LOG.info("Cached WSDL has been successfully deleted.");
        else
            LOG.warn("New WSDL could not be cached or already cached WSDL could not be deleted. " +
                     "Check the error log for the possible cause.");

        locations.remove(url);
    }

    public boolean contains(String url) {
        return locations.containsKey(url);
    }

    public File getPath(String url) {
        UUID uuid = locations.get(url);

        return new File(BASE_PATH + ASSIMBLY_PATH + CACHE_SOAP_PATH + uuid + ".wsdl");
    }
}
