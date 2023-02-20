package world.dovetail.auth.mongo;

import org.junit.Before;
import org.junit.Test;
import world.dovetail.auth.MongoTestHelper;
import world.dovetail.auth.domain.Tenant;
import world.dovetail.auth.domain.User;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertFalse;

public class MongoDaoTest {

    private String email = "joe";
    private String password = "abcdefg";

    private String name = "Tenant1";
    private String dbName = "tenant1";

    private String database;
    private MongoDao mongoDao;

    @Before
    public void init() {
        MongoTestHelper.setup();

        database = MongoTestHelper.getDb();
        mongoDao = new MongoDao(database);
    }

    @Test
    public void testUserRetrieval() {
        User user = mongoDao.findUser(email, password);

        assertNotNull("User not found", user);
        assertEquals("Wrong email", email, user.getEmail());
        assertEquals("Wrong password", password, user.getPasswordDigest());

        Tenant tenant = mongoDao.findTenant(user);

        assertNotNull("Tenant not found", tenant);
        assertEquals("Wrong name", name, tenant.getName());
        assertEquals("Wrong db_name", dbName, tenant.getDbName());
        assertFalse("Wrong password", tenant.getDisabled());
    }

}
