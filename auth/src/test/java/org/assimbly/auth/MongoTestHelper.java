package org.assimbly.auth;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.assimbly.auth.domain.Role;
import org.assimbly.auth.domain.Status;
import org.assimbly.auth.domain.Tenant;
import org.assimbly.auth.domain.User;

public class MongoTestHelper {

    private static final String EMAIL = "joe";
    private static final String PASSWORD = "abcdefg";
    private static final String DB = "testBase";

    public static User setup() {

        Morphia morphia = new Morphia();
        morphia.mapPackage("org.assimbly.auth.domain");

        MongoClient client = new MongoClient("flux-mongo", 27017);

        Datastore datastore = morphia.createDatastore(client, DB);
        datastore.ensureIndexes();

        datastore.delete(datastore.createQuery(User.class));
        datastore.delete(datastore.createQuery(Tenant.class));

        User user = null;
        if (datastore.getCount(User.class) == 0) {
            Tenant tenant1 = new Tenant("Tenant1", "tenant1", false);
            Tenant tenant2 = new Tenant("Tenant2", "tenant2", true);
            datastore.save(tenant1);
            datastore.save(tenant2);

            user = new User(EMAIL, PASSWORD, Role.ADMIN, Status.ACTIVE, tenant1.getId());
            User user2 = new User(EMAIL + "2", PASSWORD + "2", Role.ADMIN, Status.BLOCKED, tenant1.getId());
            User user3 = new User(EMAIL + "3", PASSWORD + "3", Role.ADMIN, Status.ACTIVE, tenant2.getId());
            datastore.save(user);
            datastore.save(user2);
            datastore.save(user3);
        }

        client.close();

        return user;
    }

    public static String getDb(){
        return DB;
    }

}