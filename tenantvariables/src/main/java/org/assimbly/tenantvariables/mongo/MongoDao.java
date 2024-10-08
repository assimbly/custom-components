package org.assimbly.tenantvariables.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.tenantvariables.TenantVariablesProcessor;
import org.assimbly.tenantvariables.domain.EnvironmentValue;
import org.assimbly.tenantvariables.domain.TenantVariable;
import org.assimbly.tenantvariables.exception.EnvironmentValueNotFoundException;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MongoDao {

    private static final Logger LOG = LoggerFactory.getLogger(MongoDao.class);

    private static final String TENANT_VARIABLES_COLLECTION_NAME = "tenant_variables";
    private static final String NAME_FIELD = "name";

    private static final String CREATED_BY_SYSTEM = "System";
    private static final String UPDATED_BY_SYSTEM = "System";

    private static final String TENANT_VARIABLE_EXPRESSION = "@\\{(.*?)}";

    public static TenantVariable findTenantVariableByName(String variableName, String tenant) {
        return findTenantVariableByName(variableName, tenant, TenantVariable.TenantVarType.TenantVariable);
    }

    public static TenantVariable findTenantVariableByName(String variableName, String tenant, TenantVariable.TenantVarType tenantVarType) {
        MongoDatabase database = MongoClientProvider.getInstance().getDatabase(tenant);
        MongoCollection<Document> collection = database.getCollection(TENANT_VARIABLES_COLLECTION_NAME);

        Document query = new Document()
                .append(TenantVariable.NAME_FIELD, variableName)
                .append(TenantVariable.TYPE_FIELD, tenantVarType.name());

        Document document = collection.find(query).first();
        if (document != null) {
            return TenantVariable.fromDocument(document);
        }
        return null;
    }

    public static List<TenantVariable> findAll(String tenant) {
        MongoDatabase database = MongoClientProvider.getInstance().getDatabase(tenant);
        MongoCollection<Document> collection = database.getCollection(TENANT_VARIABLES_COLLECTION_NAME);

        List<TenantVariable> tenantVariables = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                TenantVariable tenantVariable = TenantVariable.fromDocument(document);
                tenantVariables.add(tenantVariable);
            }
        }
        return tenantVariables;
    }

    static public String getTenantVariableValue(String tenantVarName, String tenant, String environment) {
        return getTenantVariableValue(tenantVarName, tenant, environment, TenantVariable.TenantVarType.TenantVariable);
    }

    public static String getTenantVariableValue(String tenantVarName, String tenant, String environment, TenantVariable.TenantVarType tenantVarType) {

        TenantVariable tenantVar = MongoDao.findTenantVariableByName(tenantVarName, tenant, tenantVarType);
        if(tenantVar==null) {
            LOG.info(String.format("tenantVar %s of type %s is NULL", tenantVarType.name(), tenantVarName));
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
        return interpolatePossibleTenantVariable(value, tenant, TenantVariable.TenantVarType.TenantVariable);
    }

    public static String interpolatePossibleTenantVariable(String value, String tenant, TenantVariable.TenantVarType tenantVarType) {
        StringBuffer valueBuf = new StringBuffer();
        String environment = TenantVariablesProcessor.getEnvironment();
        Pattern pattern = Pattern.compile(TENANT_VARIABLE_EXPRESSION);
        Matcher matcher = pattern.matcher(value);

        while(matcher.find()){
            String varName = matcher.group(1);
            TenantVariablesProcessor tenantVarProcessor = new TenantVariablesProcessor();
            String environmentVarValue = "";

            TenantVariable tenantVar = MongoDao.findTenantVariableByName(varName, tenant, tenantVarType);
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

    static public void saveTenantVariable(
            String tenantVarName, String tenantVarValue, String tenant, String environment
    ) {
        saveTenantVariable(tenantVarName, tenantVarValue, tenant, environment, TenantVariable.TenantVarType.TenantVariable);
    }

    public static void saveTenantVariable(
            String tenantVarName, String tenantVarValue, String tenant, String environment, TenantVariable.TenantVarType tenantVarType
    ) {
        TenantVariable tenantVariable = findTenantVariableByName(tenantVarName, tenant, tenantVarType);
        boolean tenantVariableExist = !Objects.isNull(tenantVariable);

        tenantVariable = initTenantVariable(tenantVariable, tenantVarType, tenantVarName, environment, tenantVariableExist);

        EnvironmentValue variable = tenantVariable.find(environment).get();

        variable.setEncrypted(false);
        variable.setValue(tenantVarValue);
        variable.setLastUpdate(new Date().getTime());
        variable.setUpdatedBy(UPDATED_BY_SYSTEM);

        updateTenantVariable(tenantVariable, tenant, tenantVariableExist);
    }

    private static TenantVariable initTenantVariable(TenantVariable tenantVariable, TenantVariable.TenantVarType tenantVarType, String tenantVarName, String environment, boolean tenantVariableExist) {
        if(!tenantVariableExist) {
            tenantVariable = new TenantVariable(tenantVarName);
            tenantVariable.set_type(tenantVarType.name());
        }
        if(StringUtils.isEmpty(tenantVariable.getCreatedBy())) {
            tenantVariable.setCreatedBy(CREATED_BY_SYSTEM);
        }
        if(tenantVariable.getCreatedAt() == 0) {
            tenantVariable.setCreatedAt(new Date().getTime());
        }
        if(!tenantVariable.find(environment).isPresent()) {
            tenantVariable.put(new EnvironmentValue(environment));
        }

        return tenantVariable;
    }

    public static void updateTenantVariable(TenantVariable tenantVariable, String tenant, boolean tenantVariableExist){
        MongoDatabase database = MongoClientProvider.getInstance().getDatabase(tenant);
        MongoCollection<Document> collection = database.getCollection(TENANT_VARIABLES_COLLECTION_NAME);
        if(tenantVariableExist) {
            collection.replaceOne(new Document(TenantVariable.ID_FIELD, tenantVariable.get_id()), tenantVariable.toDocument());
        } else {
            collection.insertOne(tenantVariable.toDocument());
        }
    }

    public static void deleteTenantVariable(TenantVariable tenantVariable, String tenant) {
        MongoDatabase database = MongoClientProvider.getInstance().getDatabase(tenant);
        MongoCollection<Document> collection = database.getCollection(TENANT_VARIABLES_COLLECTION_NAME);
        collection.deleteOne(new Document(TenantVariable.ID_FIELD, tenantVariable.get_id()));
    }

    public static void deleteTenantVariablesByName(String tenantVarName, String tenant) {
        MongoDatabase database = MongoClientProvider.getInstance().getDatabase(tenant);
        MongoCollection<Document> collection = database.getCollection(TENANT_VARIABLES_COLLECTION_NAME);
        collection.deleteMany(new Document(TenantVariable.NAME_FIELD, tenantVarName));
    }

}
