package org.assimbly.globalvariables;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.engine.ExplicitCamelContextNameStrategy;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.assimbly.util.exception.GlobalVariableNotFoundException;

import org.junit.jupiter.api.*;
import org.assimbly.globalvariables.domain.EnvironmentValue;
import org.assimbly.globalvariables.domain.GlobalEnvironmentVariable;
import org.assimbly.globalvariables.mongo.MongoDao;
import org.assimbly.globalvariables.mongo.MongoDaoImpl;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class GlobalVariablesTest extends CamelTestSupport {

    private final String VARIABLE_DEFAULT_VALUE = "Unassigned";
    private final String VARIABLE_VALUE = "Test value";
    private final String VARIABLE_WITH_DOLLAR = "Thi$ body has dollar";
    private final String VARIABLE_NAME = "Variable 1";
    private final String ENCRYPTED_VARIABLE_NAME = "Encrypted Variable 1";
    private final String VARIABLE_NAME_HEADER = "Variable ${headers.count}";

    private final String NULL_VARIABLE = "Variable Null";

    private final String HEADER_NAME = "HeaderName";
    private final String HEADER_NAME_WITH_SPACE = "Test header";
    private final String HEADER_VALUE = "HeaderValue";

    private final String BODY_VALUE = "BodyValue";
    private final String BODY_XML_VALUE = "<root xmlns:foo=\"http://www.foo.org/\" xmlns:bar=\"http://www.bar.org\">" +
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
    private final String BODY_JSON_VALUE = "{" +
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

    private final String BODY_MULTILINE_VALUE = "Multiline\n" +
                                                "Body\n" +
                                                "Test";

    private final String BASE64_HEADER_ONLY = "JHtoZWFkZXIuSGVhZGVyTmFtZX0=";
    private final String BASE64_BODY_ONLY = "JHtib2R5fQ==";
    private final String BASE64_BODY_AS_ONLY = "JHtib2R5QXMoU3RyaW5nKX0=";
    private final String BASE64_BODY_XML_1ST_ACTOR = Base64.getEncoder().encodeToString("//actor[1]/text()".getBytes());
    private final String BASE64_BODY_JSON_1ST_ACTOR = Base64.getEncoder().encodeToString("$.actors[:1].name".getBytes());
    private final String BASE64_BODY_GROOVY = Base64.getEncoder().encodeToString(("int x = 100; int y = 11; result = x + y;").getBytes());
    private final String BASE64_HEADER_BETWEEN = "VmFyaWFibGU6ICR7aGVhZGVyLkhlYWRlck5hbWV9Ow==";
    private final String BASE64_BODY_BETWEEN = "Qm9keTogJHtib2R5fTs=";
    private final String BASE64_VARIABLE_VALUE = "VGVzdCB2YWx1ZQ==";
    private final String BASE64_BODY_STRING = Base64.getEncoder().encodeToString("${bodyAs(String)}".getBytes());

    private final String BASE64_MULTIPLE_HEADER = "VmFyaWFibGU6ICR7aGVhZGVyLkhlYWRlck5hbWV9OyBWYXJpYWJsZTogJHtoZWFkZXIuSGVhZGVyTmFtZX07";

    private final GlobalVariablesProcessor PROCESSOR = new GlobalVariablesProcessor();

    private static final String TENANT = "default";

    @AfterEach
    @Override
    public void tearDown() throws Exception {
        try {
            super.tearDown();
        } catch (Exception e) {
            // TODO: follow up reported issue with this method after upgrading Camel
        }
    }

    @AfterEach
    public void after(){
        MongoDao mongoDao = new MongoDaoImpl();

        List<GlobalEnvironmentVariable> variables = mongoDao.findAll(TENANT);

        for(GlobalEnvironmentVariable g : variables){
            mongoDao.deleteVariable(g, TENANT);
        }
    }

    @AfterAll
    public static void afterAll(){
        MongoDao mongoDao = new MongoDaoImpl();

        List<GlobalEnvironmentVariable> variables = mongoDao.findAll(TENANT);

        for(GlobalEnvironmentVariable g : variables){
            mongoDao.deleteVariable(g, TENANT);
        }
    }

    @Override
    @BeforeEach
    public void setUp() throws Exception {
        // Starts the CamelContext
        super.setUp();

        // Start Camel
        context = new DefaultCamelContext();
        context.addRoutes(createRouteBuilder());
        context.start();

        template = context.createProducerTemplate();

        MongoDao mongoDao = new MongoDaoImpl();

        mongoDao.updateVariable(createVariable(), TENANT);
        mongoDao.updateVariable(createEncryptedVariable(), TENANT);

        context.setNameStrategy(new ExplicitCamelContextNameStrategy("ID_12345"));
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:getWithSpace")
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=get&header=" + HEADER_NAME_WITH_SPACE + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:getWithHeader")
                        .setHeader("count", new ConstantExpression("1"))
                        .to("globalvariables://"+ VARIABLE_NAME_HEADER +"?operation=get&header=" + HEADER_NAME_WITH_SPACE + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:getNull")
                        .to("globalvariables://"+ NULL_VARIABLE +"?operation=get&header=" + HEADER_NAME_WITH_SPACE + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithSpace")
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=constant&value=RAW(" + BASE64_VARIABLE_VALUE + ")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithDollarSign")
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_STRING + ")&encrypt=false"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithHeader")
                        .setHeader(HEADER_NAME, new ConstantExpression(HEADER_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_HEADER_ONLY +")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithXPathExpression")
                        .setBody(new ConstantExpression(BODY_XML_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=xpath&value=RAW("+BASE64_BODY_XML_1ST_ACTOR+")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithJsonPathExpression")
                        .setBody(new ConstantExpression(BODY_JSON_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=jsonpath&value=RAW("+BASE64_BODY_JSON_1ST_ACTOR+")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithGroovyExpression")
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=groovy&value=RAW("+BASE64_BODY_GROOVY+")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setNameHeader")
                        .setHeader("count", new ConstantExpression("1"))
                        .to("globalvariables://"+ VARIABLE_NAME_HEADER +"?operation=set&expressionType=constant&value=RAW(" + BASE64_VARIABLE_VALUE + ")" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithHeaderInbetween")
                        .setHeader(HEADER_NAME, new ConstantExpression(HEADER_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_HEADER_BETWEEN + ")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithMultipleHeader")
                        .setHeader(HEADER_NAME, new ConstantExpression(HEADER_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_MULTIPLE_HEADER + ")" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithBody")
                        .setBody(new ConstantExpression(BODY_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_ONLY + ")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithBodyAsString")
                        .setBody(new ConstantExpression(BODY_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_AS_ONLY + ")" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithMultilineBody")
                        .setBody(new ConstantExpression(BODY_MULTILINE_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_ONLY + ")" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:setWithBodyInBetween")
                        .setBody(new ConstantExpression(BODY_VALUE))
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=simple&value=RAW(" + BASE64_BODY_BETWEEN + ")"  + "&environment=test&tenant=default")
                        .to("mock:out");

                from( "direct:remove")
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=constant&value=RAW(" + BASE64_VARIABLE_VALUE + ")" + "&environment=test&tenant=default")
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=delete")
                        .to("mock:out");

                from("direct:setEncrypted")
                        .to("globalvariables://"+ VARIABLE_NAME +"?operation=set&expressionType=constant&value=RAW(" + BASE64_VARIABLE_VALUE + ")&encrypt=true" + "&environment=test&tenant=default")
                        .to("mock:out");

                from("direct:getEncrypted")
                        .to("globalvariables://"+ ENCRYPTED_VARIABLE_NAME +"?operation=get&header=" + HEADER_NAME_WITH_SPACE + "&environment=test&tenant=default")
                        .to("mock:out");
            }
        };
    }

    @Test
    public void testGetUnassigedVariable() throws Exception {
        Assertions.assertThrows(CamelExecutionException.class, () -> {
            // Trigger flow
            template.sendBody("direct:getWithSpace", "");

            getMockEndpoint("mock:out").expectedMessageCount(1);
        });
    }

    @Test
    public void testGetVariableWithHeader() throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        variable.put(new EnvironmentValue("test"));

        mongoDao.updateVariable(variable, TENANT);

        template.sendBody("direct:getWithHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        assertNotNull(result.getIn().getHeader(HEADER_NAME_WITH_SPACE));
        assertEquals(VARIABLE_DEFAULT_VALUE, result.getIn().getHeader(HEADER_NAME_WITH_SPACE));
    }

    @Test
    public void testGetNullVariable() throws Exception {
        // Trigger flow
        Exchange out = template.send("direct:getNull", new DefaultExchange(context));

        assertTrue(out.isFailed());
        assertTrue(out.getException() instanceof GlobalVariableNotFoundException);
    }

    @Test
    public void testSetUnassigedVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithSpace", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(VARIABLE_VALUE, variableValue.get().getValue());
    }

    @Test
    public void testSetVariableValueWithDollarSign() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithDollarSign", "Thi$ body has dollar");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(VARIABLE_WITH_DOLLAR, variableValue.get().getValue());
    }

    @Test
    public void testSetWithNameHeader() throws Exception {
        // Trigger flow
        template.sendBody("direct:setNameHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(VARIABLE_VALUE, variableValue.get().getValue());
    }

    @Test
    public void testSetWithHeaderVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(HEADER_VALUE, variableValue.get().getValue());
    }

    @Test
    public void testSetWithXPathExpression() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithXPathExpression", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("Christian Bale", variableValue.get().getValue());
    }

    @Test
    public void testSetWithJsonPathExpression() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithJsonPathExpression", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("[\"Christian Bale\"]", variableValue.get().getValue());
    }

    @Test
    public void testSetWithGroovyExpression() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithGroovyExpression", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("111", variableValue.get().getValue());
    }

    @Test
    public void testSetWithMultilineBodyVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithMultilineBody", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(BODY_MULTILINE_VALUE, variableValue.get().getValue());
    }

    @Test
    public void testSetWithBodyVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithBody", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(BODY_VALUE, variableValue.get().getValue());
    }

    @Test
    public void testSetWithBodyAsStringVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithBodyAsString", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals(BODY_VALUE, variableValue.get().getValue());
    }

    @Test
    public void testSetWithBodyInBetweenVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithBodyInBetween", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("Body: " + BODY_VALUE + ";", variableValue.get().getValue());
    }

    @Test
    public void testSetWithHeaderInbetweenVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithHeaderInbetween", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("Variable: " + HEADER_VALUE + ";", variableValue.get().getValue());
    }

    @Test
    public void testSetWithMultipleHeaderVariable() throws Exception {
        // Trigger flow
        template.sendBody("direct:setWithMultipleHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());
        assertEquals("Variable: " + HEADER_VALUE + "; " + "Variable: " + HEADER_VALUE + ";", variableValue.get().getValue());
    }

    @Test
    public void testRemoveVariable() throws Exception {
        template.sendBody("direct:remove", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        MongoDao mongoDao = new MongoDaoImpl();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);

        assertEquals(null, variable);
    }

    /*
    @Test
    public void testEncryptedVariable() throws Exception {
        template.sendBody("direct:setEncrypted", "");

        MongoDao mongoDao = new MongoDaoImpl();
        GlobalVariablesProcessor processor = new GlobalVariablesProcessor();

        GlobalEnvironmentVariable variable = mongoDao.findVariableByName(VARIABLE_NAME, TENANT);
        Optional<EnvironmentValue> variableValue = variable.find("test");

        assertTrue(variableValue.isPresent());

        String actual = processor.decrypt(variableValue.get().getValue());

        assertEquals(VARIABLE_VALUE, actual);
    }

     */

    @Test
    public void testDecryptedVariable() throws Exception {
        template.sendBody("direct:getEncrypted", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        assertEquals(VARIABLE_VALUE, result.getIn().getHeader(HEADER_NAME_WITH_SPACE));
    }

    private GlobalEnvironmentVariable createVariable() {
        return new GlobalEnvironmentVariable(VARIABLE_NAME);
    }

    private GlobalEnvironmentVariable createEncryptedVariable() {
        GlobalEnvironmentVariable variable = new GlobalEnvironmentVariable(ENCRYPTED_VARIABLE_NAME);

        String encryptedVariableValue = PROCESSOR.encrypt(VARIABLE_VALUE);

        EnvironmentValue environmentValue = new EnvironmentValue("test");

        environmentValue.setValue(encryptedVariableValue);
        environmentValue.setNonce(null);
        environmentValue.setEncrypted(true);

        variable.put(environmentValue);

        return variable;
    }
}
