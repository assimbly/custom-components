package org.assimbly.auth.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.assimbly.auth.domain.Tenant;
import org.assimbly.auth.domain.User;

public class MongoDao {

    private final MongoDatabase database;

    public MongoDao(MongoDatabase database){
        this.database = database;
    }

    public MongoDao(MongoClient mongoClient, String databaseName) {
        this.database = mongoClient.getDatabase(databaseName);
    }

    private MongoCollection<Document> getCollection(String collectionName){
        return database.getCollection(collectionName);
    }

    /**
     * Find the user belonging to the given email and password in the
     * database belonging to the given tenant.
     *
     * @param email    of the user to find.
     * @param password of the user to find.
     * @return a User object representing the user if found, otherwise null.
     */
    public User findUser(String email, String password) {
        Document query = new Document(User.EMAIL_FIELD, email).append(User.PASSWORD_DIGEST_FIELD, password);
        Document userDocument = getCollection("users").find(query).first();
        if (userDocument != null) {
            return User.fromDocument(userDocument); // Convert Document to User object
        }
        return null;
    }

    public User findUser(String id) {
        Document query = new Document(User.ID_FIELD, id);
        Document userDocument = getCollection("users").find(query).first();
        if (userDocument != null) {
            return User.fromDocument(userDocument); // Convert Document to User object
        }
        return null;
    }

    public User findUserByEmail(String email) {
        Document query = new Document(User.EMAIL_FIELD, email);
        Document userDocument = getCollection("users").find(query).first();
        if (userDocument != null) {
            return User.fromDocument(userDocument); // Convert Document to User object
        }
        return null;
    }

    public Tenant findTenant(User user) {
        Document query = new Document(Tenant.ID_FIELD, user.getTenantId());
        Document tenantDocument = getCollection("tenants").find(query).first();
        if (tenantDocument != null) {
            return Tenant.fromDocument(tenantDocument);
        }
        return null;
    }

    public void updateAuthenticatorSettings(User user, String secretKey, Boolean usesTwoFactor) {
        getCollection("users").updateOne(new Document(User.ID_FIELD, user.getId()),
                new Document("$set", new Document("secret_key", secretKey)
                        .append("uses_two_factor", usesTwoFactor)));
    }

    public void removeAuthenticatorSettings(User user){
        getCollection("users").updateOne(new Document(User.ID_FIELD, user.getId()),
                new Document("$unset", new Document("secret_key", "")
                        .append("uses_two_factor", false)));
    }

}
