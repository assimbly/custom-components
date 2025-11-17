package org.assimbly.tenantvariables;

import com.jayway.jsonpath.JsonPath;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.language.groovy.GroovyExpression;
import org.apache.camel.language.xpath.XPathBuilder;
import org.apache.camel.language.simple.SimpleLanguage;
import org.apache.camel.model.language.SimpleExpression;
import org.assimbly.util.EncryptionUtil;
import org.assimbly.util.exception.EnvironmentException;
import org.assimbly.util.exception.TenantVariableNotFoundException;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.util.helper.ExchangeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assimbly.tenantvariables.domain.EnvironmentValue;
import org.assimbly.tenantvariables.domain.TenantVariable;
import org.assimbly.tenantvariables.mongo.MongoDao;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TenantVariablesProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(TenantVariablesProcessor.class);

    private static final String ALGORITHM = "PBEWithHMACSHA512AndAES_256";
    private static final String ASSIMBLY_ENCRYPTION_SECRET = System.getenv("ASSIMBLY_ENCRYPTION_SECRET");

    private EncryptionUtil encryptionUtil = new EncryptionUtil(ASSIMBLY_ENCRYPTION_SECRET, ALGORITHM);

    private final String DEFAULT_TENANT_NAME = "default";
    private static final String ASSIMBLY_ENV = "ASSIMBLY_ENV";
    private final String BODY_VARIABLE_REGEX = "\\$\\{body(?:As\\(.*\\))?}";

    private TenantVariablesEndpoint endpoint;

    /*
     *  For testing purposes only
     */
    public TenantVariablesProcessor() {}

    public TenantVariablesProcessor(TenantVariablesEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) {
        switch (endpoint.getConfiguration().getOperation()) {
            case GET:
                getTenantVariable(exchange);
                break;
            case SET:
                setTenantVariable(exchange);
                break;
            case DELETE:
                deleteTenantVariable(exchange);
        }
    }

    public String decrypt(String encryptedValue) {
        String value = encryptionUtil.decrypt(encryptedValue);
        return value;
    }

    public String encrypt(String value) {
        String encryptedValue = encryptionUtil.encrypt(value);
        return encryptedValue;
    }

    public String getValueByEnvironmentValue(EnvironmentValue environmentVar) {
        return (environmentVar.isEncrypted() ? decrypt(environmentVar.getValue()) : environmentVar.getValue());
    }

    private void getTenantVariable(Exchange exchange) {
        String name = endpoint.getConfiguration().getName();
        String tenantDbName = (endpoint.getConfiguration().getTenantDbName()!=null ? endpoint.getConfiguration().getTenantDbName() : DEFAULT_TENANT_NAME);
        String environment = (endpoint.getConfiguration().getEnvironment()!=null ? endpoint.getConfiguration().getEnvironment() : getEnvironment());

        name = interpolateVar(name, exchange, false);

        TenantVariable gVariable = MongoDao.findTenantVariableByName(name, tenantDbName);

        if(gVariable == null) {
            throw new TenantVariableNotFoundException(
                    String.format("The Tenant Variable \"%1$s\" for tenant \"%2$s\" was not found in the database.", name, tenantDbName)
            );
        }

        if(!gVariable.find(environment).isPresent())
            throw new TenantVariableNotFoundException("The Tenant Variable \"" + name + "\" has no values for the "+ environment +" environment.");

        EnvironmentValue variable = gVariable.find(environment).get();

        String value = (variable.isEncrypted() ? decrypt(variable.getValue()) : variable.getValue());

        String header = interpolateVar(endpoint.getConfiguration().getHeaderName(), exchange, false);

        exchange.getIn().setHeader(header, value);
    }

    private void setTenantVariable(Exchange exchange) {
        String expressionType = endpoint.getConfiguration().getLanguage();
        String value = endpoint.getConfiguration().getValue();
        String name = endpoint.getConfiguration().getName();
        String groupName = endpoint.getConfiguration().getGroupName();
        String flowName = endpoint.getConfiguration().getFlowName();
        String tenantDbName = (endpoint.getConfiguration().getTenantDbName()!=null ? endpoint.getConfiguration().getTenantDbName() : DEFAULT_TENANT_NAME);
        String environment = (endpoint.getConfiguration().getEnvironment()!=null ? endpoint.getConfiguration().getEnvironment() : getEnvironment());
        long modifyDate = System.currentTimeMillis();

        name = interpolateVar(name, exchange, false);

        value = interpolateVar(Base64Helper.unmarshal(value, UTF_8), exchange, expressionType);

        TenantVariable gVariable = MongoDao.findTenantVariableByName(name, tenantDbName);
        boolean gVariableExist = !Objects.isNull(gVariable);

        String modifier = groupName.equalsIgnoreCase("groupless") ? flowName : groupName + "/" + flowName;

        if(!gVariableExist) {
            gVariable = new TenantVariable(name);
            gVariable.setCreatedAt(modifyDate);
            gVariable.setCreatedBy(modifier);
        }

        if(environment != null && !gVariable.find(environment).isPresent()){
            gVariable.put(new EnvironmentValue(environment));
        }else if(environment==null){
            throw new TenantVariableNotFoundException("The Tenant Variable environment is not set.");
        }

        Optional<EnvironmentValue> optional = gVariable.find(environment);

        EnvironmentValue variable = optional.get();

        boolean encrypt = endpoint.getConfiguration().isEncrypt();

        if(encrypt) {
            value = encrypt(value);
        } else {
            variable.setNonce(null);
        }

        variable.setEncrypted(encrypt);
        variable.setValue(value);
        variable.setLastUpdate(modifyDate);
        variable.setUpdatedBy(modifier);

        MongoDao.updateTenantVariable(gVariable, tenantDbName, gVariableExist);
    }

    private void deleteTenantVariable(Exchange exchange) {
        String name = endpoint.getConfiguration().getName();
        String tenantDbName = (endpoint.getConfiguration().getTenantDbName()!=null ? endpoint.getConfiguration().getTenantDbName() : DEFAULT_TENANT_NAME);

        if(ExchangeHelper.hasVariables(name))
            name = ExchangeHelper.interpolate(name, exchange);

        TenantVariable variable = MongoDao.findTenantVariableByName(name, tenantDbName);

        if(variable == null)
            throw new TenantVariableNotFoundException("The Tenant Variable \"" + name + "\" was not found in the database.");

        MongoDao.deleteTenantVariable(variable, tenantDbName);
    }

    private String interpolateVar(String varValue, Exchange exchange, boolean bodyFlag) {
        if(ExchangeHelper.hasVariables(varValue))
            varValue = ExchangeHelper.interpolate(varValue, exchange);

        if(bodyFlag)
            if (isBodyVariable(varValue))
                varValue = interpolateBody(varValue, exchange);

        if(SimpleLanguage.hasSimpleFunction(varValue)) {
            SimpleExpression simpleExpression = new SimpleExpression(varValue);
            varValue = simpleExpression.evaluate(exchange, String.class);
        }

        return varValue;
    }

    private String interpolateVar(String varValue, Exchange exchange, String expressionType) {

        String bodyContent = exchange.getIn().getBody(String.class);

        try {
            switch (expressionType){
                case "simple":
                    SimpleExpression simpleExpression = new SimpleExpression(varValue);
                    varValue = simpleExpression.evaluate(exchange, String.class);
                    break;
                case "constant":
                    // do nothing
                    break;
                case "xpath":
                    XPathBuilder builder = XPathBuilder.xpath(varValue).saxon();
                    varValue = builder.evaluate(exchange.getContext(), bodyContent);
                    break;
                case "jsonpath":
                    varValue = JsonPath.parse(bodyContent).read(varValue).toString();
                    break;
                case "groovy":
                    GroovyExpression groovyExpression = new GroovyExpression(varValue);
                    varValue = groovyExpression.evaluate(exchange, String.class);
                    break;
                default:
                    // do nothing
            }
        } catch (Exception e){
            throw new EnvironmentException("Error to interpolate variable.");
        }

        return varValue;
    }

    private boolean isBodyVariable(String string) {
        return Pattern.compile(BODY_VARIABLE_REGEX).matcher(string).find();
    }

    private String interpolateBody(String string, Exchange exchange) {
        Matcher m = Pattern.compile(BODY_VARIABLE_REGEX).matcher(string);
        StringBuffer stringBuffer = new StringBuffer();

        while (m.find()) {
            String bValue = exchange.getIn().getBody(String.class);

            if (bValue != null)
                m.appendReplacement(stringBuffer, escapeDollarSign(bValue));
        }

        m.appendTail(stringBuffer);

        return stringBuffer.toString();
    }

    private String escapeDollarSign(String str) {
        return str.replace("$", "\\$");
    }

    public static String getEnvironment() {
        return System.getenv(ASSIMBLY_ENV);
    }
}