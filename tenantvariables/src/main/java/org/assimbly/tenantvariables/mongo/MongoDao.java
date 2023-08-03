package org.assimbly.tenantvariables.mongo;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.assimbly.tenantvariables.TenantVariablesProcessor;
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

    public static TenantVariable findTenantVariableByName(String variableName, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        return datastore.find(TenantVariable.class).field(NAME_FIELD).equal(variableName).get();
    }

    public static List<TenantVariable> findAll(String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        return datastore.createQuery(TenantVariable.class).asList();
    }

    public static String getTenantVariableValue(String tenantVarName, String tenant, String environment) {

        TenantVariable tenantVar = MongoDao.findTenantVariableByName(tenantVarName, tenant);
        if(tenantVar==null) {
            LOG.info(String.format("tenantVar %s is NULL", tenantVarName));
            return null;
        }

        StringBuffer output = new StringBuffer();
        String tenantVariableValue = tenantVar.find(environment)
                .orElseThrow(() -> new EnvironmentValueNotFoundException("Tenant variable (" + tenantVarName + ") value not found for environment: " + environment))
                .getValue();

        if(tenantVariableValue!=null) {
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
        }

        return output.toString();
    }

    public static String interpolatePossibleTenantVariable(String value, String tenant) {
        StringBuffer valueBuf = new StringBuffer();
        String environment = TenantVariablesProcessor.getEnvironment();
        Pattern pattern = Pattern.compile(TENANT_VARIABLE_EXPRESSION);
        Matcher matcher = pattern.matcher(value);

        while(matcher.find()){
            String varName = matcher.group(1);
            TenantVariablesProcessor tenantVarProcessor = new TenantVariablesProcessor();
            String environmentVarValue = "";

            TenantVariable tenantVar = MongoDao.findTenantVariableByName(varName, tenant);
            Optional<EnvironmentValue> environmentVar = tenantVar.find(environment);
            if(environmentVar.isPresent()) {
                environmentVarValue = tenantVarProcessor.getValueByEnvironmentValue(environmentVar.get());
            }

            matcher.appendReplacement(valueBuf, Matcher.quoteReplacement(environmentVarValue));
        }
        matcher.appendTail(valueBuf);

        return valueBuf.toString();
    }

    public static boolean isTenantVar(String value) {
        Pattern pattern = Pattern.compile(TENANT_VARIABLE_EXPRESSION);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public static void saveTenantVariable(
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

    public static void updateTenantVariable(TenantVariable tenantVariable, String tenant){
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        datastore.save(tenantVariable);
    }

    public static void deleteTenantVariable(TenantVariable tenantVariable, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        datastore.delete(tenantVariable);
    }

    public static void deleteTenantVariablesByName(String tenantVarName, String tenant) {
        Datastore datastore = MongoClientProvider.getInstance().getDatastore(tenant);
        Query<TenantVariable> query = datastore.createQuery(TenantVariable.class)
                .field("name")
                .contains(tenantVarName);
        datastore.delete(query);
    }

}
