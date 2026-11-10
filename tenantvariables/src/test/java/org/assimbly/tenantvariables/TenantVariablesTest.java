package org.assimbly.tenantvariables;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.assimbly.tenantvariables.domain.EnvironmentValue;
import org.assimbly.tenantvariables.domain.TenantVariable;
import org.assimbly.tenantvariables.exception.TenantVariableNotFoundException;
import org.assimbly.tenantvariables.mongo.MongoDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

/**
 * Unit tests for the tenantvariables component. MongoDao is replaced by an in-memory store,
 * so no database is needed. The ASSIMBLY_ENCRYPTION_SECRET variable is provided by the surefire configuration.
 */
class TenantVariablesTest extends CamelTestSupport {

    private static final String ENVIRONMENT = "test";
    private static final String HEADER = "MyHeader";
    private static final String OPTIONS = "&environment=" + ENVIRONMENT + "&groupName=groupless&flowName=flow1";

    private static final String JSON_BODY = "{\"actors\": [{\"id\": \"1\", \"name\": \"Christian Bale\"}, {\"id\": \"2\", \"name\": \"Liam Neeson\"}]}";

    private final Map<String, TenantVariable> store = new HashMap<>();
    private MockedStatic<MongoDao> mongoDao;

    @BeforeEach
    void mockMongoDao() {
        mongoDao = mockStatic(MongoDao.class);
        mongoDao.when(() -> MongoDao.findTenantVariableByName(anyString(), anyString()))
                .thenAnswer(invocation -> store.get(invocation.<String>getArgument(0)));
        mongoDao.when(() -> MongoDao.updateTenantVariable(any(), anyString(), anyBoolean()))
                .thenAnswer(invocation -> {
                    TenantVariable variable = invocation.getArgument(0);
                    store.put(variable.getName(), variable);
                    return null;
                });
        mongoDao.when(() -> MongoDao.deleteTenantVariable(any(), anyString()))
                .thenAnswer(invocation -> {
                    TenantVariable variable = invocation.getArgument(0);
                    store.remove(variable.getName());
                    return null;
                });
    }

    @AfterEach
    void closeMongoDao() {
        mongoDao.close();
    }

    // ---- set ----

    @Test
    void setConstantStoresValueInDefaultTenant() {
        Exchange result = set("Var1", "constant", "Test value", "", exchange -> {});

        assertFalse(result.isFailed());
        assertEquals("Test value", storedValue("Var1"));
        mongoDao.verify(() -> MongoDao.updateTenantVariable(any(TenantVariable.class), eq("default"), eq(false)));
    }

    @Test
    void setUsesTenantDbNameWhenGiven() {
        set("Var1", "constant", "Test value", "&tenantDbName=customer", exchange -> {});

        mongoDao.verify(() -> MongoDao.updateTenantVariable(any(TenantVariable.class), eq("customer"), eq(false)));
    }

    @Test
    void setUpdatesExistingVariableInsteadOfAddingEnvironmentValue() {
        TenantVariable existing = variable("Var1", "old value", false);
        store.put("Var1", existing);

        set("Var1", "constant", "new value", "", exchange -> {});

        assertEquals(1, existing.getValues().size());
        assertEquals("new value", storedValue("Var1"));
        mongoDao.verify(() -> MongoDao.updateTenantVariable(eq(existing), eq("default"), eq(true)));
    }

    @Test
    void setAddsValueForNewEnvironmentToExistingVariable() {
        TenantVariable existing = variable("Var1", "prod value", false);
        existing.find(ENVIRONMENT).orElseThrow().setEnvironment("prod");
        store.put("Var1", existing);

        set("Var1", "constant", "test value", "", exchange -> {});

        assertEquals(2, existing.getValues().size());
        assertEquals("prod value", existing.find("prod").orElseThrow().getValue());
        assertEquals("test value", existing.find(ENVIRONMENT).orElseThrow().getValue());
    }

    @Test
    void setRecordsModifierAsFlowNameWhenGroupless() {
        set("Var1", "constant", "value", "", exchange -> {});

        assertEquals("flow1", store.get("Var1").getCreatedBy());
        assertEquals("flow1", store.get("Var1").find(ENVIRONMENT).orElseThrow().getUpdatedBy());
    }

    @Test
    void setRecordsModifierWithGroupNameWhenInGroup() {
        Exchange exchange = new DefaultExchange(context);
        String uri = "tenantvariables:Var1?operation=set&language=constant&value=RAW(" + base64("value") + ")"
                + "&environment=" + ENVIRONMENT + "&groupName=myGroup&flowName=flow1";
        template.send(uri, exchange);

        assertEquals("myGroup/flow1", store.get("Var1").getCreatedBy());
    }

    @Test
    void setSimpleResolvesHeaderAndBody() {
        set("Var1", "simple", "Header: ${header.MyHeader}; Body: ${body}", "", exchange -> {
            exchange.getIn().setHeader(HEADER, "HeaderValue");
            exchange.getIn().setBody("BodyValue");
        });

        assertEquals("Header: HeaderValue; Body: BodyValue", storedValue("Var1"));
    }

    @Test
    void setSimpleKeepsDollarSignFromBody() {
        set("Var1", "simple", "${bodyAs(String)}", "", exchange -> exchange.getIn().setBody("Thi$ body has dollar"));

        assertEquals("Thi$ body has dollar", storedValue("Var1"));
    }

    @Test
    void setSimpleKeepsMultilineBody() {
        String multiline = "Multiline\nBody\nTest";

        set("Var1", "simple", "${body}", "", exchange -> exchange.getIn().setBody(multiline));

        assertEquals(multiline, storedValue("Var1"));
    }

    @Test
    void setJsonPathReadsFromBody() {
        set("Var1", "jsonpath", "$.actors[:1].name", "", exchange -> exchange.getIn().setBody(JSON_BODY));

        assertEquals("[\"Christian Bale\"]", storedValue("Var1"));
    }

    @Test
    void setGroovyEvaluatesScript() {
        set("Var1", "groovy", "int x = 100; int y = 11; result = x + y;", "", exchange -> {});

        assertEquals("111", storedValue("Var1"));
    }

    @Test
    void setResolvesHeaderInVariableName() {
        set("Var${headers.count}", "constant", "value", "", exchange -> exchange.getIn().setHeader("count", "1"));

        assertEquals("value", storedValue("Var1"));
    }

    @Test
    void setWithInvalidExpressionFailsExchange() {
        Exchange result = set("Var1", "jsonpath", "$.actors", "", exchange -> exchange.getIn().setBody("not json"));

        assertTrue(result.isFailed());
        assertNull(store.get("Var1"));
    }

    @Test
    void setEncryptedStoresEncryptedValueAndGetDecryptsIt() {
        set("Var1", "constant", "secret value", "&encrypt=true", exchange -> {});

        EnvironmentValue stored = store.get("Var1").find(ENVIRONMENT).orElseThrow();
        assertTrue(stored.isEncrypted());
        assertTrue(stored.getValue().startsWith("ENC(GCM|"));
        assertNotEquals("secret value", stored.getValue());

        Exchange result = get("Var1", exchange -> {});

        assertEquals("secret value", result.getIn().getHeader(HEADER));
    }

    // ---- get ----

    @Test
    void getPutsValueInHeader() {
        store.put("Var1", variable("Var1", "Test value", false));

        Exchange result = get("Var1", exchange -> {});

        assertFalse(result.isFailed());
        assertEquals("Test value", result.getIn().getHeader(HEADER));
    }

    @Test
    void getResolvesHeaderInVariableName() {
        store.put("Var1", variable("Var1", "Test value", false));

        Exchange result = get("Var${headers.count}", exchange -> exchange.getIn().setHeader("count", "1"));

        assertEquals("Test value", result.getIn().getHeader(HEADER));
    }

    @Test
    void getDecryptsEncryptedValue() {
        store.put("Var1", variable("Var1", new TenantVariablesProcessor().encrypt("Test value"), true));

        Exchange result = get("Var1", exchange -> {});

        assertEquals("Test value", result.getIn().getHeader(HEADER));
    }

    @Test
    void getUnknownVariableFails() {
        Exchange result = get("Unknown", exchange -> {});

        assertTrue(result.isFailed());
        assertInstanceOf(TenantVariableNotFoundException.class, result.getException());
    }

    @Test
    void getVariableWithoutValueForEnvironmentFails() {
        TenantVariable otherEnvironment = variable("Var1", "value", false);
        otherEnvironment.find(ENVIRONMENT).orElseThrow().setEnvironment("prod");
        store.put("Var1", otherEnvironment);

        Exchange result = get("Var1", exchange -> {});

        assertTrue(result.isFailed());
        assertInstanceOf(TenantVariableNotFoundException.class, result.getException());
    }

    @Test
    void getWithoutHeaderNameFails() {
        store.put("Var1", variable("Var1", "Test value", false));

        Exchange result = template.send("tenantvariables:Var1?operation=get&environment=" + ENVIRONMENT, new DefaultExchange(context));

        assertTrue(result.isFailed());
        assertInstanceOf(IllegalArgumentException.class, result.getException());
    }

    // ---- delete ----

    @Test
    void deleteRemovesVariable() {
        store.put("Var1", variable("Var1", "Test value", false));

        Exchange result = template.send("tenantvariables:Var1?operation=delete", new DefaultExchange(context));

        assertFalse(result.isFailed());
        assertNull(store.get("Var1"));
    }

    @Test
    void deleteUnknownVariableFails() {
        Exchange result = template.send("tenantvariables:Unknown?operation=delete", new DefaultExchange(context));

        assertTrue(result.isFailed());
        assertInstanceOf(TenantVariableNotFoundException.class, result.getException());
    }

    // ---- encrypt / decrypt ----

    @Test
    void encryptAndDecryptRoundTrip() {
        TenantVariablesProcessor processor = new TenantVariablesProcessor();

        String encrypted = processor.encrypt("Value 1");

        assertNotEquals("Value 1", encrypted);
        assertEquals("Value 1", processor.decrypt(encrypted));
    }

    @Test
    void encryptAndDecryptReturnEmptyStringForEmptyInput() {
        TenantVariablesProcessor processor = new TenantVariablesProcessor();

        assertEquals("", processor.encrypt(null));
        assertEquals("", processor.encrypt(""));
        assertEquals("", processor.decrypt(null));
        assertEquals("", processor.decrypt(""));
    }

    // ---- helpers ----

    private Exchange set(String name, String language, String value, String extraOptions, Consumer<Exchange> prepare) {
        Exchange exchange = new DefaultExchange(context);
        prepare.accept(exchange);
        String uri = "tenantvariables:" + name + "?operation=set&language=" + language
                + "&value=RAW(" + base64(value) + ")" + OPTIONS + extraOptions;
        return template.send(uri, exchange);
    }

    private Exchange get(String name, Consumer<Exchange> prepare) {
        Exchange exchange = new DefaultExchange(context);
        prepare.accept(exchange);
        return template.send("tenantvariables:" + name + "?operation=get&headerName=" + HEADER + "&environment=" + ENVIRONMENT, exchange);
    }

    private String storedValue(String name) {
        TenantVariable variable = store.get(name);
        assertNotNull(variable, "Variable " + name + " was not stored");
        return variable.find(ENVIRONMENT).orElseThrow().getValue();
    }

    private static TenantVariable variable(String name, String value, boolean encrypted) {
        EnvironmentValue environmentValue = new EnvironmentValue(ENVIRONMENT);
        environmentValue.setValue(value);
        environmentValue.setEncrypted(encrypted);

        TenantVariable variable = new TenantVariable(name);
        variable.put(environmentValue);
        return variable;
    }

    private static String base64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }
}
