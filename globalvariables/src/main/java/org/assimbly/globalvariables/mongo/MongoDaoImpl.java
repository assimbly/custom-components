package org.assimbly.globalvariables.mongo;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.assimbly.globalvariables.domain.GlobalEnvironmentVariable;


import java.util.List;

public class MongoDaoImpl implements MongoDao {

    private static final String NAME_FIELD = "name";
    private static final String ID_FIELD = "_id";

    @Override
    public GlobalEnvironmentVariable findVariableByName(String variableName, String tenant) {

        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        Query<GlobalEnvironmentVariable> query = datastore
                .find(GlobalEnvironmentVariable.class)
                .field(NAME_FIELD)
                .equal(variableName);

        GlobalEnvironmentVariable result = query.first();

        return result;
    }

    @Override
    public List<GlobalEnvironmentVariable> findAll(String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);

        return datastore.createQuery(GlobalEnvironmentVariable.class)
                .asList();
    }

    @Override
    public void updateVariable(GlobalEnvironmentVariable globalEnvironmentVariable, String tenant){
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);

        datastore.save(globalEnvironmentVariable);
    }

    @Override
    public void deleteVariable(GlobalEnvironmentVariable globalEnvironmentVariable, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);

        datastore.delete(globalEnvironmentVariable);
    }
}
