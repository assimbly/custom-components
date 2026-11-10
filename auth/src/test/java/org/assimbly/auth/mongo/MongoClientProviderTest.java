package org.assimbly.auth.mongo;

import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MongoClientProviderTest {

    @Test
    void getClient() {
        MongoDatabase database = MongoClientProvider.getInstance().getDatabase("test");

        assertNotNull(database, "MongoClient is null");

    }

}
