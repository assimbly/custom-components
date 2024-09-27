package org.assimbly.auth.mongo;

import org.assimbly.auth.MongoTestHelper;
import org.assimbly.auth.domain.Tenant;
import org.assimbly.auth.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MongoDaoTest {

    private String email = "joe";
    private String password = "abcdefg";

    private String name = "Tenant1";
    private String dbName = "tenant1";

    private String database;
    private MongoDao mongoDao;

    @BeforeEach
    public void init() {
        MongoTestHelper.setup();

        database = MongoTestHelper.getDb();

        mongoDao = new MongoDao(MongoClientProvider.getInstance().getDatabase(database));
    }

    @Test
    public void testUserRetrieval() {
        User user = mongoDao.findUser(email, password);
        assertNotNull(user, "User not found");

        Tenant tenant = mongoDao.findTenant(user);
        assertNotNull(tenant, "Tenant not found");
        assertFalse(tenant.getDisabled(), "Wrong password");
    }

}
