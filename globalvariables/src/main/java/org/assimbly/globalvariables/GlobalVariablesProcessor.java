package org.assimbly.globalvariables;

import com.jayway.jsonpath.JsonPath;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.language.groovy.GroovyExpression;
import org.apache.camel.language.xpath.XPathBuilder;
import org.apache.camel.language.simple.SimpleLanguage;
import org.assimbly.util.EncryptionUtil;
import org.assimbly.util.exception.EnvironmentException;
import org.assimbly.util.exception.GlobalVariableNotFoundException;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.util.helper.ExchangeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assimbly.globalvariables.domain.EnvironmentValue;
import org.assimbly.globalvariables.domain.GlobalEnvironmentVariable;
import org.assimbly.globalvariables.mongo.MongoDao;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class GlobalVariablesProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalVariablesProcessor.class);

    private static final String ASSIMBLY_ENCRYPTION_SECRET = "ASSIMBLY_ENCRYPTION_SECRET";

    private EncryptionUtil encryptionUtil = new EncryptionUtil(ASSIMBLY_ENCRYPTION_SECRET, "PBEWithHMACSHA512AndAES_256");

    private final String TENANT_DEFAULT = "default";
    private static final String ASSIMBLY_ENV = "ASSIMBLY_ENV";
    private final String BODY_VARIABLE_REGEX = "\\$\\{body(?:As\\(.*\\))?}";

    private GlobalVariablesEndpoint endpoint;

    /*
     *  For testing purposes only
     */
    public GlobalVariablesProcessor() {}

    public GlobalVariablesProcessor(GlobalVariablesEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) {
        switch (endpoint.getConfiguration().getOperation()) {
            case GET:
                getGlobalVariable(exchange);
                break;
            case SET:
                setGlobalVariable(exchange);
                break;
            case DELETE:
                deleteGlobalVariable(exchange);
        }
    }

    public String decrypt(String encryptedValue) {
        String value = encryptionUtil.getTextEncryptor().decrypt(encryptedValue);
        return value;
    }

    public String encrypt(String value) {
        String encryptedValue = encryptionUtil.getTextEncryptor().encrypt(value);
        return encryptedValue;
    }

    private void getGlobalVariable(Exchange exchange) {
        String name = endpoint.getConfiguration().getName();
        String tenant = (endpoint.getConfiguration().getTenant()!=null ? endpoint.getConfiguration().getTenant() : TENANT_DEFAULT);
        String environment = (endpoint.getConfiguration().getEnvironment()!=null ? endpoint.getConfiguration().getEnvironment() : getEnvironment());

        name = interpolateVar(name, exchange, false);

        GlobalEnvironmentVariable gVariable = MongoDao.findVariableByName(name, tenant);

        if(gVariable == null)
            throw new GlobalVariableNotFoundException("The Global Variable \"" + name + "\" was not found in the database.");

        if(!gVariable.find(environment).isPresent())
            throw new GlobalVariableNotFoundException("The Global Variable \"" + name + "\" has no values for the "+ environment +" environment.");

        EnvironmentValue variable = gVariable.find(environment).get();

        String value = (variable.isEncrypted() ? decrypt(variable.getValue()) : variable.getValue());

        String header = interpolateVar(endpoint.getConfiguration().getHeader(), exchange, false);

        exchange.getIn().setHeader(header, value);
    }

    private void setGlobalVariable(Exchange exchange) {
        String expressionType = endpoint.getConfiguration().getExpressionType();
        String value = endpoint.getConfiguration().getValue();
        String name = endpoint.getConfiguration().getName();
        String modifier = endpoint.getConfiguration().getModifier();
        String tenant = (endpoint.getConfiguration().getTenant()!=null ? endpoint.getConfiguration().getTenant() : TENANT_DEFAULT);
        String environment = (endpoint.getConfiguration().getEnvironment()!=null ? endpoint.getConfiguration().getEnvironment() : getEnvironment());
        long modifyDate = System.currentTimeMillis();

        name = interpolateVar(name, exchange, false);

        value = interpolateVar(Base64Helper.unmarshal(value, UTF_8), exchange, expressionType);

        GlobalEnvironmentVariable gVariable = MongoDao.findVariableByName(name, tenant);

        if(Objects.isNull(gVariable)) {
            gVariable = new GlobalEnvironmentVariable(name);
            gVariable.setCreatedAt(modifyDate);
            gVariable.setCreatedBy(modifier);
        }

        if(environment != null && !gVariable.find(environment).isPresent()){
            gVariable.put(new EnvironmentValue(environment));
        }else if(environment==null){
            throw new GlobalVariableNotFoundException("The Global Variable environment is not set.");
        }

        Optional<EnvironmentValue> optional = gVariable.find(environment);

        EnvironmentValue variable = optional.get();

        boolean encrypt = endpoint.getConfiguration().isEncrypt();

        if(encrypt) {
            value = encrypt(variable.getValue());
        } else {
            variable.setNonce(null);
        }

        variable.setEncrypted(encrypt);
        variable.setValue(value);
        variable.setUpdatedAt(modifyDate);
        variable.setUpdatedBy(modifier);

        MongoDao.updateVariable(gVariable, tenant);
    }

    private void deleteGlobalVariable(Exchange exchange) {
        String name = endpoint.getConfiguration().getName();
        String tenant = (endpoint.getConfiguration().getTenant()!=null ? endpoint.getConfiguration().getTenant() : TENANT_DEFAULT);

        if(ExchangeHelper.hasVariables(name))
            name = ExchangeHelper.interpolate(name, exchange);

        GlobalEnvironmentVariable variable = MongoDao.findVariableByName(name, tenant);

        if(variable == null)
            throw new GlobalVariableNotFoundException("The Global Variable \"" + name + "\" was not found in the database.");

        MongoDao.deleteVariable(variable, tenant);
    }

    private String interpolateVar(String varValue, Exchange exchange, boolean bodyFlag) {
        if(ExchangeHelper.hasVariables(varValue))
            varValue = ExchangeHelper.interpolate(varValue, exchange);

        if(bodyFlag)
            if (isBodyVariable(varValue))
                varValue = interpolateBody(varValue, exchange);

        if(SimpleLanguage.hasSimpleFunction(varValue))
            varValue = SimpleLanguage.expression(varValue).evaluate(exchange, String.class);

        return varValue;
    }

    private String interpolateVar(String varValue, Exchange exchange, String expressionType) {

        String bodyContent = exchange.getIn().getBody(String.class);

        try {
            switch (expressionType){
                case "simple":
                    varValue = SimpleLanguage.expression(varValue).evaluate(exchange, String.class);
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