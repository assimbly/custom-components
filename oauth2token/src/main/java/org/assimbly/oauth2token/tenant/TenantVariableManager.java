package org.assimbly.oauth2token.tenant;

import org.assimbly.tenantvariables.TenantVariablesProcessor;
import org.assimbly.tenantvariables.domain.EnvironmentValue;
import org.assimbly.tenantvariables.domain.TenantVariable;
import org.assimbly.tenantvariables.mongo.MongoDao;

import java.util.Date;

public class TenantVariableManager {

    private static final String STATIC_TENANT_VARIABLE_SUFFIX = "_" + TenantVariable.TenantVarType.STATIC_TENANT_VARIABLE.name();
    private static final TenantVariablesProcessor PROCESSOR = new TenantVariablesProcessor();

    public static String getTenantVariableValue(String tokenName, String tenant, String environment) {
        return getDecryptedValue(tokenName, tenant, environment, TenantVariable.TenantVarType.TENANT_VARIABLE);
    }

    public static String discoverAndGetTenantVariableValue(String tokenName, String tenant, String environment) {
        TenantVariable.TenantVarType tenantVarType = TenantVariable.TenantVarType.TENANT_VARIABLE;

        if(isStaticTenantVariable(tokenName)) {
            tokenName = getStaticTenantVariableName(tokenName);
            tenantVarType = TenantVariable.TenantVarType.STATIC_TENANT_VARIABLE;
        }

        return getDecryptedValue(tokenName, tenant, environment, tenantVarType);
    }

    public static void saveTenantVariable(String tokenName, String accessToken, String tenant, String environment) {
        saveValue(tokenName, accessToken, tenant, environment, TenantVariable.TenantVarType.TENANT_VARIABLE, true);
    }

    public static void discoverAndSaveTenantVariable(String tokenName, String accessToken, String tenant, String environment) {
        TenantVariable.TenantVarType tenantVarType = TenantVariable.TenantVarType.TENANT_VARIABLE;

        if(isStaticTenantVariable(tokenName)) {
            tokenName = getStaticTenantVariableName(tokenName);
            tenantVarType = TenantVariable.TenantVarType.STATIC_TENANT_VARIABLE;
        }

        saveValue(tokenName, accessToken, tenant, environment, tenantVarType, true);
    }

    private static String getDecryptedValue(String tokenName, String tenant, String environment, TenantVariable.TenantVarType tenantVarType) {
        TenantVariable tenantVar = MongoDao.findTenantVariableByName(tokenName, tenant, tenantVarType);
        if (tenantVar == null) {
            return null;
        }

        return tenantVar.find(environment)
                .map(PROCESSOR::getValueByEnvironmentValue) // handles decryption when envValue.isEncrypted()
                .orElse(null);
    }

    private static void saveValue(String tokenName, String value, String tenant, String environment,
                                  TenantVariable.TenantVarType tenantVarType, boolean encrypt) {
        TenantVariable tenantVariable = MongoDao.findTenantVariableByName(tokenName, tenant, tenantVarType);
        boolean tenantVariableExists = tenantVariable != null;

        if (!tenantVariableExists) {
            tenantVariable = new TenantVariable(tokenName);
            tenantVariable.setType(tenantVarType.name());
        }

        if (!tenantVariable.find(environment).isPresent()) {
            tenantVariable.put(new EnvironmentValue(environment));
        }

        EnvironmentValue envValue = tenantVariable.find(environment).get();

        if (encrypt) {
            value = PROCESSOR.encrypt(value);
        }

        envValue.setEncrypted(encrypt);
        envValue.setValue(value);
        envValue.setLastUpdate(new Date().getTime());

        MongoDao.updateTenantVariable(tenantVariable, tenant, tenantVariableExists);
    }

    public static boolean isStaticTenantVariable(String tokenName) {
        return tokenName.endsWith(STATIC_TENANT_VARIABLE_SUFFIX);
    }

    private static String getStaticTenantVariableName(String tokenName) {
        int index = tokenName.indexOf(STATIC_TENANT_VARIABLE_SUFFIX);
        return tokenName.substring(0, index);
    }

}
