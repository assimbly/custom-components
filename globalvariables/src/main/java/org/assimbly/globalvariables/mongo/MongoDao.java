package org.assimbly.globalvariables.mongo;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.assimbly.globalvariables.domain.EnvironmentValue;
import org.assimbly.globalvariables.domain.GlobalEnvironmentVariable;
import org.assimbly.globalvariables.exception.EnvironmentValueNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MongoDao {

    private static final Logger LOG = LoggerFactory.getLogger(MongoDao.class);

    private static final String NAME_FIELD = "name";

    private static final String CREATED_BY_SYSTEM = "System";
    private static final String UPDATED_BY_SYSTEM = "System";

    private static final String GLOBAL_EXPRESSION = "@\\{(.*?)}";

    static public GlobalEnvironmentVariable findVariableByName(String variableName, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        return datastore.find(GlobalEnvironmentVariable.class).field(NAME_FIELD).equal(variableName).get();
    }

    static public List<GlobalEnvironmentVariable> findAll(String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        return datastore.createQuery(GlobalEnvironmentVariable.class).asList();
    }

    static public String getGlobalEnvironmentValue(String globVarName, String tenant, String environment) {

        GlobalEnvironmentVariable globVar = MongoDao.findVariableByName(globVarName, tenant);
        if(globVar==null) {
            LOG.info(String.format("globVar %s is NULL", globVarName));
            return null;
        }

        StringBuffer output = new StringBuffer();
        String globalEnvironmentValue = globVar.find(environment)
                .orElseThrow(() -> new EnvironmentValueNotFoundException("Global variable (" + globVarName + ") value not found for environment: " + environment))
                .getValue();

        Pattern pattern = Pattern.compile(GLOBAL_EXPRESSION);
        Matcher matcher = pattern.matcher(globalEnvironmentValue);

        while(matcher.find()) {
            String internalGlobalVarName = matcher.group(1);

            GlobalEnvironmentVariable internalGlobalVar = findVariableByName(internalGlobalVarName, tenant);
            if(internalGlobalVar != null) {
                Optional<EnvironmentValue> optionalEnvironmentValue = internalGlobalVar.find(environment);
                if(optionalEnvironmentValue.isPresent()) {
                    internalGlobalVarName = optionalEnvironmentValue.get().getValue();
                } else {
                    internalGlobalVarName = "";
                }
            } else {
                internalGlobalVarName = "";
            }

            matcher.appendReplacement(output, Matcher.quoteReplacement(internalGlobalVarName));
        }
        matcher.appendTail(output);
        return output.toString();
    }

    static public void saveGlobalEnvironmentVariable(
            String globVarName, String globVarValue, String tenant, String environment
    ) {
        GlobalEnvironmentVariable globalEnvironmentVariable = findVariableByName(globVarName, tenant);

        if(Objects.isNull(globalEnvironmentVariable)) {
            globalEnvironmentVariable = new GlobalEnvironmentVariable(globVarName);
            globalEnvironmentVariable.setCreatedAt(new Date().getTime());
            globalEnvironmentVariable.setCreatedBy(CREATED_BY_SYSTEM);
        }

        if(!globalEnvironmentVariable.find(environment).isPresent())
            globalEnvironmentVariable.put(new EnvironmentValue(environment));

        EnvironmentValue variable = globalEnvironmentVariable.find(environment).get();

        variable.setEncrypted(false);
        variable.setValue(globVarValue);
        variable.setUpdatedAt(new Date().getTime());
        variable.setUpdatedBy(UPDATED_BY_SYSTEM);

        updateVariable(globalEnvironmentVariable, tenant);
    }

    static public void updateVariable(GlobalEnvironmentVariable globalEnvironmentVariable, String tenant){
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        datastore.save(globalEnvironmentVariable);
    }

    static public void deleteVariable(GlobalEnvironmentVariable globalEnvironmentVariable, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        datastore.delete(globalEnvironmentVariable);
    }

    static public void deleteVariablesByName(String varName, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        Query<GlobalEnvironmentVariable> query = datastore.createQuery(GlobalEnvironmentVariable.class)
                .field("name")
                .contains(varName);
        datastore.delete(query);
    }

}
