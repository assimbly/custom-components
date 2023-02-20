package org.assimbly.auth.mongo;

import org.junit.Test;
import org.mongodb.morphia.Datastore;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class MongoClientProviderTest {

    @Test
    public void getClient() {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore("test");

        assertNotNull("MongoClient is null", datastore);
        assertNotEquals("Connection not set", "", datastore.getMongo().getConnectPoint());
    }

}
