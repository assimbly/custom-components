package org.assimbly.sql;

import org.junit.jupiter.api.*;

import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.language.SimpleExpression;
import org.assimbly.sql.helpers.H2Database;
import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

class SqlComponentTest extends CamelTestSupport {

    // H2 in-memory — no real host/port needed; the component URI uses the JDBC URL directly.
    private final String url      = H2Database.DB_URL;
    private final String username = H2Database.USER;
    private final String password = H2Database.PASS;
    private final String database = "mysql_test";

    // Use "h2" so the sql-custom component selects the H2 driver/dialect.
    private final String connectionType = "h2";
    private final String escapeChars    = "true";

    private String query  = "";
    private String query2 = "";
    private DocumentBuilder builder;

    // ---------------------------------------------------------------------------
    // Lifecycle
    // ---------------------------------------------------------------------------
    private static Connection keepAliveConnection;
    private static final H2Database h2Helper = new H2Database();

    @BeforeAll
    static void setup() throws Exception {
        // This connection stays open, so the DB stays alive in memory
        keepAliveConnection = DriverManager.getConnection(H2Database.DB_URL, "sa", "");

    }

    @BeforeEach
    void initData() throws ParserConfigurationException {

        context  = new DefaultCamelContext();
        context.start();
        template = context.createProducerTemplate();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();

        h2Helper.create();
        h2Helper.clearData();
        h2Helper.insertMockData();
        h2Helper.createStoredProcedure();
    }

    @AfterAll
    static void tearDown() throws Exception {
        if (keepAliveConnection != null) {
            keepAliveConnection.close();
        }
    }

    // ---------------------------------------------------------------------------
    // Routes
    // ---------------------------------------------------------------------------

    protected RouteBuilder createCustomRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {

                from("direct:execute")
                        .to("sql-custom://" + username + "@" + url
                                + "?password=" + password
                                + "&database=" + database
                                + "&connectionType=" + connectionType
                                + "&query=RAW(" + query + ")")
                        .to("mock:out");

                from("direct:executeWithHeaders")
                        .setHeader("product_id",   new ConstantExpression("id"))
                        .setHeader("product_name", new ConstantExpression("name"))
                        .to("sql-custom://" + username + "@" + url
                                + "?password=" + password
                                + "&database=" + database
                                + "&connectionType=" + connectionType
                                + "&query=RAW(" + query + ")")
                        .to("mock:out");

                from("direct:executeWithJsonHeader")
                        .setHeader("product_desc_json",
                                new SimpleExpression("{\"name\":\"John\", \"age\":30, \"car\":null}"))
                        .to("sql-custom://" + username + "@" + url
                                + "?password=" + password
                                + "&database=" + database
                                + "&connectionType=" + connectionType
                                + "&escapeChars=" + escapeChars
                                + "&query=RAW(" + query + ")")
                        .to("direct:executeAfterInsert");

                from("direct:executeAfterInsert")
                        .to("sql-custom://" + username + "@" + url
                                + "?password=" + password
                                + "&database=" + database
                                + "&connectionType=" + connectionType
                                + "&query=RAW(" + query2 + ")")
                        .to("mock:out");
            }
        };
    }

    // ---------------------------------------------------------------------------
    // Tests
    // ---------------------------------------------------------------------------

    @Test
    void testExecuteSelect() throws Exception {

        query = "select * from products;";

        refreshRoutes();
        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        Document resultSet = parse(result);

        Node     resultSize   = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results      = resultSet.getElementsByTagName("Result");
        Node     firstResult  = results.item(0);

        assertEquals("3", resultSize.getTextContent());
        assertEquals(3,   results.getLength());

        int index = 0;
        for (int i = 0; i < firstResult.getChildNodes().getLength(); i++) {
            Node node = firstResult.getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                index++;
                switch (index) {
                    case 1 -> assertEquals("ID",          node.getNodeName());
                    case 2 -> assertEquals("NAME",        node.getNodeName());
                    case 3 -> assertEquals("DESCRIPTION", node.getNodeName());
                    case 4 -> assertEquals("PRICE",       node.getNodeName());
                    case 5 -> assertEquals("CREATED_AT",  node.getNodeName());
                    default ->throw new IllegalStateException("Unexpected index value: " + index + ". A value between 1 and 5 is expected");
                }
            }
        }
        assertEquals(5, index);
    }

    @Test
    void testSelectWithHeaders() throws Exception {

        query = "select ${headers.product_id} from products;";

        refreshRoutes();
        template.sendBody("direct:executeWithHeaders", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        Document resultSet  = parse(result);
        Node     resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results    = resultSet.getElementsByTagName("Result");
        Node     firstResult = results.item(0);

        assertEquals("3", resultSize.getTextContent());
        assertEquals(3,   results.getLength());

        int index = 0;
        for (int i = 0; i < firstResult.getChildNodes().getLength(); i++) {
            Node node = firstResult.getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                index++;
                if (index == 1) assertEquals("ID", node.getNodeName());
            }
        }
        assertEquals(1, index);
    }

    @Test
    void testSelectWithoutAppropriatedHeaderNames() throws Exception {

        query = "SELECT H2VERSION() AS version_info;";

        refreshRoutes();
        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        Document resultSet  = parse(result);
        Node     resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results    = resultSet.getElementsByTagName("Result");

        assertEquals("1", resultSize.getTextContent());
        assertEquals(1,   results.getLength());
    }

    @Test
    void testExistingEscapedChars() throws Exception {

        query  = "insert into products (name, description, price) values ('Product Name 4', '${header.product_desc_json}', 49.99)";
        query2 = "select description from products where id = 4;";

        refreshRoutes();
        template.sendBody("direct:executeWithJsonHeader", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        Document resultSet  = parse(result);
        Node     resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results    = resultSet.getElementsByTagName("Result");

        assertEquals("1", resultSize.getTextContent());
        assertEquals(1,   results.getLength());

        Node descriptionNode = results.item(0).getChildNodes().item(1);
        assertTrue(descriptionNode.getTextContent().contains("\\\""));
    }

    @Test
    void testCallStoredProcedure() throws Exception {

        query = "call GetAllProducts();";

        refreshRoutes();
        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        Document resultSet  = parse(result);
        Node     resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results    = resultSet.getElementsByTagName("Result");

        assertEquals("3", resultSize.getTextContent());
        assertEquals(3,   results.getLength());
    }

    @Test
    void testErrorExecuteSelect() throws Exception {

        query = "select id from product;";

        refreshRoutes();
        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result     = getMockEndpoint("mock:out").getExchanges().getFirst();
        String   resultBody = result.getIn().getBody(String.class);

        assertTrue(resultBody.contains("<HasErrors>true</HasErrors>"));
        // H2 error message differs from MySQL, but always names the missing table.
        assertTrue(resultBody.contains("<ErrorMessage>") && resultBody.contains("PRODUCT"));
    }

    @Test
    void testExecuteInsert() throws Exception {

        query = "insert into products (name, description, price) values ('Product Name 4', 'Description 4', 49.99)";

        refreshRoutes();
        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        Document resultSet   = parse(result);
        Node     resultSize  = resultSet.getElementsByTagName("ResultSize").item(0);
        Node     generatedKey = resultSet.getElementsByTagName("generatedKey").item(0);
        NodeList results     = resultSet.getElementsByTagName("Result");

        assertEquals("1", resultSize.getTextContent());
        assertEquals(1,   results.getLength());
        assertEquals("4", generatedKey.getTextContent());
    }

    @Test
    void testExecuteUpdate() throws Exception {

        query = "update products set name = 'Product Name 1.1' where id=1";

        refreshRoutes();
        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result    = getMockEndpoint("mock:out").getExchanges().getFirst();
        Document resultSet = parse(result);

        assertEquals(1, resultSet.getChildNodes().getLength());
        assertTrue(resultSet.getChildNodes().item(0).getTextContent().contains("false"));
    }

    @Test
    void testExecuteInsertWithHeaders() throws Exception {

        query = "insert into products (${headers.product_name}, description, price) values ('Product Name 4', 'Description 4', 49.99)";

        refreshRoutes();
        template.sendBody("direct:executeWithHeaders", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        Document resultSet    = parse(result);
        Node     resultSize   = resultSet.getElementsByTagName("ResultSize").item(0);
        Node     generatedKey = resultSet.getElementsByTagName("generatedKey").item(0);
        NodeList results      = resultSet.getElementsByTagName("Result");

        assertEquals("1", resultSize.getTextContent());
        assertEquals(1,   results.getLength());
        assertEquals("4", generatedKey.getTextContent());
    }

    @Test
    void testExecuteDelete() throws Exception {

        query = "delete from products where id=1";

        refreshRoutes();
        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result    = getMockEndpoint("mock:out").getExchanges().getFirst();
        Document resultSet = parse(result);

        assertEquals(1, resultSet.getChildNodes().getLength());
        assertTrue(resultSet.getChildNodes().item(0).getTextContent().contains("false"));
    }

    // ---------------------------------------------------------------------------
    // Helpers
    // ---------------------------------------------------------------------------

    private Document parse(Exchange exchange) throws Exception {
        return builder.parse(
                new InputSource(new StringReader(
                        exchange.getIn().getBody(String.class))));
    }

    private void refreshRoutes() throws Exception {
        for (Route r : context.getRoutes()) {
            context.removeRoute(r.getId());
        }
        context.addRoutes(createCustomRouteBuilder());
    }
}