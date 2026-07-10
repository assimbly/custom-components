package org.assimbly.tenantvariables;

import org.junit.jupiter.api.*;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.engine.ExplicitCamelContextNameStrategy;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.support.DefaultExchange;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.assimbly.tenantvariables.exception.TenantVariableNotFoundException;
import org.assimbly.tenantvariables.domain.EnvironmentValue;
import org.assimbly.tenantvariables.domain.TenantVariable;
import org.assimbly.tenantvariables.mongo.MongoDao;

import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TenantVariablesTest extends CamelTestSupport {

    private static final String VARIABLE_VALUE = "Test value";
    private static final String VARIABLE_WITH_DOLLAR = "Thi$ body has dollar";
    private static final String VARIABLE_NAME = "Variable 1";
    private static final String ENCRYPTED_VARIABLE_NAME = "Encrypted Variable 1";
    private static final String VARIABLE_NAME_HEADER = "Variable ${headers.count}";

    private static final String NULL_VARIABLE = "Variable Null";

    private static final String HEADER_NAME = "HeaderName";
    private static final String HEADER_NAME_WITH_SPACE = "Test header";
    private static final String HEADER_VALUE = "HeaderValue";

    private static final String BODY_VALUE = "BodyValue";
    private static final String BODY_XML_VALUE = "<root xmlns:foo=\"http://www.foo.org/\" xmlns:bar=\"http://www.bar.org\">" +
            "<actors><actor id=\"1\">Christian Bale</actor>" +
            "<actor id=\"2\">Liam Neeson</actor>" +
            "<actor id=\"3\">Michael Caine</actor>" +
            "</actors>" +
            "<foo:singers>" +
            "<foo:singer id=\"4\">Tom Waits</foo:singer>" +
            "<foo:singer id=\"5\">B.B. King</foo:singer>" +
            "<foo:singer id=\"6\">Ray Charles</foo:singer>" +
            "</foo:singers>" +
            "</root>";
    private static final String BODY_JSON_VALUE = "{" +
            "\"actors\": [" +
            "{ \"id\": \"1\", \"name\": \"Christian Bale\" }," +
            "{ \"id\": \"2\", \"name\": \"Liam Neeson\" }," +
            "{ \"id\": \"3\", \"name\": \"Michael Caine\" }" +
            "]," +
            "\"singers\": [" +
            "{ \"id\": \"4\", \"name\": \"Tom Waits\" }," +
            "{ \"id\": \"5\", \"name\": \"B.B. King\" }," +
            "{ \"id\": \"6\", \"name\": \"Ray Charles\" }" +
            "]" +
            "}";

    private static final String BODY_MULTILINE_VALUE = """
            Multiline
            Body
            Test""";

    private static final String BASE64_HEADER_ONLY = "JHtoZWFkZXIuSGVhZGVyTmFtZX0=";
    private static final String BASE64_BODY_ONLY = "JHtib2R5fQ==";
    private static final String BASE64_BODY_AS_ONLY = "JHtib2R5QXMoU3RyaW5nKX0=";
    private static final String BASE64_BODY_XML_1ST_ACTOR = Base64.getEncoder().encodeToString("//actor[1]/text()".getBytes());
    private static final String BASE64_BODY_JSON_1ST_ACTOR = Base64.getEncoder().encodeToString("$.actors[:1].name".getBytes());
    private static final String BASE64_BODY_GROOVY = Base64.getEncoder().encodeToString(("int x = 100; int y = 11; result = x + y;").getBytes());
    private static final String BASE64_HEADER_BETWEEN = "VmFyaWFibGU6ICR7aGVhZGVyLkhlYWRlck5hbWV9Ow==";
    private static final String BASE64_BODY_BETWEEN = "Qm9keTogJHtib2R5fTs=";
    private static final String BASE64_VARIABLE_VALUE = "VGVzdCB2YWx1ZQ==";
    private static final String BASE64_BODY_STRING = Base64.getEncoder().encodeToString("${bodyAs(String)}".getBytes());

    private static final String BASE64_MULTIPLE_HEADER = "VmFyaWFibGU6ICR7aGVhZGVyLkhlYWRlck5hbWV9OyBWYXJpYWJsZTogJHtoZWFkZXIuSGVhZGVyTmFtZX07";

    private static final TenantVariablesProcessor PROCESSOR = new TenantVariablesProcessor();

    private static final String TENANT = "default";

    /*
    @AfterEach
    void after(){
        List<TenantVariable> variables = MongoDao.findAll(TENANT);

        for(TenantVariable g : variables){
            MongoDao.deleteTenantVariable(g, TENANT);
        }
    }

    @BeforeEach
    void setMongoDao() {

        MongoDao.updateTenantVariable(createVariable(), TENANT, false);
        MongoDao.updateTenantVariable(createEncryptedVariable(), TENANT, false);

        context.setNameStrategy(new ExplicitCamelContextNameStrategy("ID_12345"));
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:getWithSpace")
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=get&header=" + HEADER_NAME_WITH_SPACE + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:getWithHeader")
                        .setHeader("count", new ConstantExpression("1"))
                        .to("tenantvariables://"+ VARIABLE_NAME_HEADER +"?operation=get&header=" + HEADER_NAME_WITH_SPACE + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:getNull")
                        .to("tenantvariables://"+ NULL_VARIABLE +"?operation=get&header=" + HEADER_NAME_WITH_SPACE + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithSpace")
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=constant&value=RAW(" + BASE64_VARIABLE_VALUE + ")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithDollarSign")
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_STRING + ")&encrypt=false"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithHeader")
                        .setHeader(HEADER_NAME, new ConstantExpression(HEADER_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_HEADER_ONLY +")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithXPathExpression")
                        .setBody(new ConstantExpression(BODY_XML_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=xpath&value=RAW("+BASE64_BODY_XML_1ST_ACTOR+")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithJsonPathExpression")
                        .setBody(new ConstantExpression(BODY_JSON_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=jsonpath&value=RAW("+BASE64_BODY_JSON_1ST_ACTOR+")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithGroovyExpression")
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=groovy&value=RAW("+BASE64_BODY_GROOVY+")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setNameHeader")
                        .setHeader("count", new ConstantExpression("1"))
                        .to("tenantvariables://"+ VARIABLE_NAME_HEADER +"?operation=set&expressionType=constant&value=RAW(" + BASE64_VARIABLE_VALUE + ")" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithHeaderInbetween")
                        .setHeader(HEADER_NAME, new ConstantExpression(HEADER_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_HEADER_BETWEEN + ")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithMultipleHeader")
                        .setHeader(HEADER_NAME, new ConstantExpression(HEADER_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_MULTIPLE_HEADER + ")" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithBody")
                        .setBody(new ConstantExpression(BODY_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_ONLY + ")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithBodyAsString")
                        .setBody(new ConstantExpression(BODY_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_AS_ONLY + ")" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithMultilineBody")
                        .setBody(new ConstantExpression(BODY_MULTILINE_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_ONLY + ")" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithBodyInBetween")
                        .setBody(new ConstantExpression(BODY_VALUE))
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_BETWEEN + ")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from( "direct:remove")
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=constant&value=RAW(" + BASE64_VARIABLE_VALUE + ")" + "&environment=test&tenant=default")
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=delete")
                        .to("mock:out");

                from("direct:setEncrypted")
                        .to("tenantvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=constant&value=RAW(" + BASE64_VARIABLE_VALUE + ")&encrypt=true" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:getEncrypted")
                        .to("tenantvariables://"+ ENCRYPTED_VARIABLE_NAME +"?operation=get&header=" + HEADER_NAME_WITH_SPACE + "&environment=test&tenant=default")
                        .to("mock:out");
            }
        };
    }

    @Test
    void testGetUnassigedVariable() {
        Assertions.assertThrows(CamelExecutionException.class, () -> {
            // Trigger flow
            template.sendBody("direct:getWithSpace", "");

            getMockEndpoint("mock:out").expectedMessageCount(1);
        });
    }

    @Test
    void testGetVariableWithHeader() throws Exception {
        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        boolean variableExist = !Objects.isNull(variable);

        variable.put(new EnvironmentValue("test"));

        MongoDao.updateTenantVariable(variable, TENANT, variableExist);

        template.sendBody("direct:getWithHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        assertNotNull(result.getIn().getHeader(HEADER_NAME_WITH_SPACE));

        assertEquals("Unassigned", result.getIn().getHeader(HEADER_NAME_WITH_SPACE));
    }

    @Test
    void testGetNullVariable() {
        // Trigger flow
        Exchange out = template.send("direct:getNull", new DefaultExchange(context));

        assertTrue(out.isFailed());
        assertInstanceOf(TenantVariableNotFoundException.class, out.getException());
    }

    @Test
    void testSetUnassigedVariable() {
        // Trigger flow
        template.sendBody("direct:setWithSpace", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(VARIABLE_VALUE, variableValue.get().getValue());
    }

    @Test
    void testSetVariableValueWithDollarSign() {
        // Trigger flow
        template.sendBody("direct:setWithDollarSign", "Thi$ body has dollar");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(VARIABLE_WITH_DOLLAR, variableValue.get().getValue());
    }

    @Test
    void testSetWithNameHeader() throws Exception {
        // Trigger flow
        template.sendBody("direct:setNameHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(VARIABLE_VALUE, variableValue.get().getValue());
    }

    @Test
    void testSetWithHeaderVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(HEADER_VALUE, variableValue.get().getValue());
    }

    @Test
    void testSetWithXPathExpression() {
        // Trigger flow
        template.sendBody("direct:setWithXPathExpression", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("Christian Bale", variableValue.get().getValue());
    }

    @Test
    void testSetWithJsonPathExpression() {
        // Trigger flow
        template.sendBody("direct:setWithJsonPathExpression", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("[\"Christian Bale\"]", variableValue.get().getValue());
    }

    @Test
    void testSetWithGroovyExpression() {
        // Trigger flow
        template.sendBody("direct:setWithGroovyExpression", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("111", variableValue.get().getValue());
    }

    @Test
    void testSetWithMultilineBodyVariable() {
        // Trigger flow
        template.sendBody("direct:setWithMultilineBody", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(BODY_MULTILINE_VALUE, variableValue.get().getValue());
    }

    @Test
    void testSetWithBodyVariable() {
        // Trigger flow
        template.sendBody("direct:setWithBody", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(BODY_VALUE, variableValue.get().getValue());
    }

    @Test
    void testSetWithBodyAsStringVariable() {
        // Trigger flow
        template.sendBody("direct:setWithBodyAsString", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(BODY_VALUE, variableValue.get().getValue());
    }

    @Test
    void testSetWithBodyInBetweenVariable() {
        // Trigger flow
        template.sendBody("direct:setWithBodyInBetween", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("Body: " + BODY_VALUE + ";", variableValue.get().getValue());
    }

    @Test
    void testSetWithHeaderInbetweenVariable() {
        // Trigger flow
        template.sendBody("direct:setWithHeaderInbetween", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("Variable: " + HEADER_VALUE + ";", variableValue.get().getValue());
    }

    @Test
    void testSetWithMultipleHeaderVariable() {
        // Trigger flow
        template.sendBody("direct:setWithMultipleHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("Variable: " + HEADER_VALUE + "; " + "Variable: " + HEADER_VALUE + ";", variableValue.get().getValue());
    }

    @Test
    void testRemoveVariable() {
        template.sendBody("direct:remove", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        TenantVariable variable = MongoDao.findTenantVariableByName(VARIABLE_NAME, TENANT);

        assertNull(variable);
    }

    @Test
    void testDecryptedVariable() {
        template.sendBody("direct:getEncrypted", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        assertEquals(VARIABLE_VALUE, result.getIn().getHeader(HEADER_NAME_WITH_SPACE));
    }

    private TenantVariable createVariable() {
        return new TenantVariable(VARIABLE_NAME);
    }

    private TenantVariable createEncryptedVariable() {
        TenantVariable variable = new TenantVariable(ENCRYPTED_VARIABLE_NAME);

        String encryptedVariableValue = PROCESSOR.encrypt(VARIABLE_VALUE);

        EnvironmentValue environmentValue = new EnvironmentValue("test");

        environmentValue.setValue(encryptedVariableValue);
        environmentValue.setEncrypted(true);

        variable.put(environmentValue);

        return variable;
    }

     */
}