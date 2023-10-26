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
        mongoDao = new MongoDao(database);
    }

    @Test
    public void testUserRetrieval() {
        User user = mongoDao.findUser(email, password);

        assertNotNull(user, "User not found");
        assertEquals(user.getEmail(), "Wrong email", email);
        assertEquals(user.getPasswordDigest(), "Wrong password", password);

        Tenant tenant = mongoDao.findTenant(user);

        assertNotNull(tenant, "Tenant not found");
        assertEquals(tenant.getName(), "Wrong name", name);
        assertEquals(tenant.getDbName(), "Wrong db_name", dbName);
        assertFalse(tenant.getDisabled(), "Wrong password");
    }

}
