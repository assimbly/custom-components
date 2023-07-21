package org.assimbly.tenantvariables.mongo;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.assimbly.tenantvariables.domain.EnvironmentValue;
import org.assimbly.tenantvariables.domain.TenantVariable;

import java.io.Serializable;

public class MongoClientProvider implements Serializable {

    private static final MongoClientProvider INSTANCE = new MongoClientProvider();

    private MongoClient client;
    private Morphia morphia;

    public static MongoClientProvider getInstance() {
        return INSTANCE;
    }

    /**
     * Get the `flux_production` Mongo database represented as a Morphia Datastore.
     *
     * @return the database represented as a Datastore.
     */
    Datastore getDatastore(String name) {
        if (morphia == null || client == null) {
            init();
        }

        Datastore datastore = morphia.createDatastore(client, name);
        datastore.ensureIndexes();

        return datastore;
    }

    Morphia getMorphia() {
        if (morphia == null || client == null) {
            init();
        }

        return morphia;
    }

    /**
     * Initialize Morphia and the MongoClient.
     * Point Morphia to the domain package.
     */
    private void init() {

        morphia = new Morphia();
        morphia.map(EnvironmentValue.class, TenantVariable.class);

        client = new MongoClient("flux-mongo", 27017);

        //client.getDatabase("default").getCollection("tenant_variables");

    }
}
