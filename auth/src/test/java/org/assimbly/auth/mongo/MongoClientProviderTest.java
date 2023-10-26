package org.assimbly.auth.mongo;

import org.junit.jupiter.api.Test;
import org.mongodb.morphia.Datastore;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MongoClientProviderTest {

    @Test
    public void getClient() {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore("test");

        assertNotNull(datastore, "MongoClient is null");
        assertNotEquals("Connection not set", "", datastore.getMongo().getConnectPoint());
    }

}
