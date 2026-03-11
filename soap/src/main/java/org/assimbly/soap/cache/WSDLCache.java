package org.assimbly.soap.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
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

    public File register(String url) {
        UUID uuid = UUID.randomUUID();

        locations.put(url, uuid);
        return new File(BASE_PATH + ASSIMBLY_PATH + CACHE_SOAP_PATH + uuid + ".wsdl");
    }

    public void remove(String url) {
        // Assuming getPath(url) returns a java.io.File or a java.nio.file.Path
        Path path = getPath(url).toPath();

        try {
            // Explicitly delete; throws exception if file is missing or locked
            Files.delete(path);
            LOG.info("Cached WSDL has been successfully deleted.");
        } catch (NoSuchFileException _) {
            LOG.warn("WSDL not found at {}; nothing to delete.", path);
        } catch (IOException e) {
            LOG.error("Failed to delete WSDL at {}. Reason: {}", path, e.getMessage());
            LOG.warn("New WSDL could not be cached or already cached WSDL could not be deleted.");
        } finally {
            // Ensure the reference is removed from the map regardless of disk outcome
            locations.remove(url);
        }
    }

    public boolean contains(String url) {
        return locations.containsKey(url);
    }

    public File getPath(String url) {
        UUID uuid = locations.get(url);

        return new File(BASE_PATH + ASSIMBLY_PATH + CACHE_SOAP_PATH + uuid + ".wsdl");
    }
}
