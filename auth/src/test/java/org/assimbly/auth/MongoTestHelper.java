package org.assimbly.auth;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.assimbly.auth.domain.Role;
import org.assimbly.auth.domain.Status;
import org.assimbly.auth.domain.Tenant;
import org.assimbly.auth.domain.User;
import org.bson.Document;

public class MongoTestHelper {

    private static final String EMAIL = "joe";
    private static final String PASSWORD = "abcdefg";
    private static final String DB = "testBase";

    public static User setup() {

        MongoDatabase database = MongoClients.create().getDatabase(DB);

        // Drop existing collections
        database.getCollection("users").drop();
        database.getCollection("tenants").drop();

        MongoCollection<Document> usersCollection = database.getCollection("users");
        MongoCollection<Document> tenantsCollection = database.getCollection("tenants");

        User user = null;
        if (usersCollection.countDocuments() == 0) {
            Tenant tenant1 = new Tenant("Tenant1", "tenant1", false);
            Tenant tenant2 = new Tenant("Tenant2", "tenant2", true);
            tenantsCollection.insertOne(tenant1.toDocument());
            tenantsCollection.insertOne(tenant2.toDocument());

            user = new User(EMAIL, PASSWORD, Role.ADMIN, Status.ACTIVE, tenant1.getId());
            User user2 = new User(EMAIL + "2", PASSWORD + "2", Role.ADMIN, Status.BLOCKED, tenant1.getId());
            User user3 = new User(EMAIL + "3", PASSWORD + "3", Role.ADMIN, Status.ACTIVE, tenant2.getId());

            usersCollection.insertOne(user.toDocument());
            usersCollection.insertOne(user2.toDocument());
            usersCollection.insertOne(user3.toDocument());
        }

        return user;
    }

    public static String getDb(){
        return DB;
    }

}