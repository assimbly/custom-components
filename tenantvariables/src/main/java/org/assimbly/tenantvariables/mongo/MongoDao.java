package org.assimbly.tenantvariables.mongo;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.assimbly.tenantvariables.domain.EnvironmentValue;
import org.assimbly.tenantvariables.domain.TenantVariable;
import org.assimbly.tenantvariables.exception.EnvironmentValueNotFoundException;
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

    private static final String TENANT_VARIABLE_EXPRESSION = "@\\{(.*?)}";

    static public TenantVariable findTenantVariableByName(String variableName, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        return datastore.find(TenantVariable.class).field(NAME_FIELD).equal(variableName).get();
    }

    static public List<TenantVariable> findAll(String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        return datastore.createQuery(TenantVariable.class).asList();
    }

    static public String getTenantVariableValue(String tenantVarName, String tenant, String environment) {

        TenantVariable tenantVar = MongoDao.findTenantVariableByName(tenantVarName, tenant);
        if(tenantVar==null) {
            LOG.info(String.format("tenantVar %s is NULL", tenantVarName));
            return null;
        }

        StringBuffer output = new StringBuffer();
        String tenantVariableValue = tenantVar.find(environment)
                .orElseThrow(() -> new EnvironmentValueNotFoundException("Tenant variable (" + tenantVarName + ") value not found for environment: " + environment))
                .getValue();

        Pattern pattern = Pattern.compile(TENANT_VARIABLE_EXPRESSION);
        Matcher matcher = pattern.matcher(tenantVariableValue);

        while(matcher.find()) {
            String internalTenantVarName = matcher.group(1);

            TenantVariable internalTenantVar = findTenantVariableByName(internalTenantVarName, tenant);
            if(internalTenantVar != null) {
                Optional<EnvironmentValue> optionalEnvironmentValue = internalTenantVar.find(environment);
                if(optionalEnvironmentValue.isPresent()) {
                    internalTenantVarName = optionalEnvironmentValue.get().getValue();
                } else {
                    internalTenantVarName = "";
                }
            } else {
                internalTenantVarName = "";
            }

            matcher.appendReplacement(output, Matcher.quoteReplacement(internalTenantVarName));
        }
        matcher.appendTail(output);
        return output.toString();
    }

    static public void saveTenantVariable(
            String tenantVarName, String tenantVarValue, String tenant, String environment
    ) {
        TenantVariable tenantVariable = findTenantVariableByName(tenantVarName, tenant);

        if(Objects.isNull(tenantVariable)) {
            tenantVariable = new TenantVariable(tenantVarName);
            tenantVariable.setCreatedAt(new Date().getTime());
            tenantVariable.setCreatedBy(CREATED_BY_SYSTEM);
        }

        if(!tenantVariable.find(environment).isPresent())
            tenantVariable.put(new EnvironmentValue(environment));

        EnvironmentValue variable = tenantVariable.find(environment).get();

        variable.setEncrypted(false);
        variable.setValue(tenantVarValue);
        variable.setUpdatedAt(new Date().getTime());
        variable.setUpdatedBy(UPDATED_BY_SYSTEM);

        updateTenantVariable(tenantVariable, tenant);
    }

    static public void updateTenantVariable(TenantVariable tenantVariable, String tenant){
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        datastore.save(tenantVariable);
    }

    static public void deleteTenantVariable(TenantVariable tenantVariable, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        datastore.delete(tenantVariable);
    }

    static public void deleteTenantVariablesByName(String tenantVarName, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        Query<TenantVariable> query = datastore.createQuery(TenantVariable.class)
                .field("name")
                .contains(tenantVarName);
        datastore.delete(query);
    }

}
