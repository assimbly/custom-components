package org.assimbly.auth.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.assimbly.auth.util.helper.EnvironmentHelper;

import java.io.Serializable;
import java.util.List;

/**
 * A Singleton class for maintaining a connection to the MongoDatabase.
 * This Client connection is set up once it is requested for the first time.
 */

public class MongoClientProvider implements Serializable {

    private static final MongoClientProvider INSTANCE = new MongoClientProvider();

    private static MongoClient client;

    public static MongoClientProvider getInstance() {
        return INSTANCE;
    }

    public static MongoClient getClient() {
        return client;
    }

    /**
     * Get the `flux_production` Mongo database.
     *
     * @return the database.
     */
    MongoDatabase getDatabase(String name) {
        if (client == null) {
            init();
        }
        return client.getDatabase(name);
    }

    /**
     * Initialize the MongoClient.
     */
    private static void init() {
        String host = EnvironmentHelper.get("MONGO_HOST", "mongo");
        int port = EnvironmentHelper.getInt("MONGO_PORT", 27017);

        client = MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(List.of(new ServerAddress(host, port))))
                .build());
    }
}