package org.assimbly.sql;

import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.language.SimpleExpression;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.sql.helpers.MySQLDatabase;
import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class SqlComponentTest extends CamelTestSupport {

    private final String url = "assimbly-mariadb:3306";
    private final String username = "root";
    private final String password = Base64Helper.marshal("root".getBytes(), StandardCharsets.UTF_8);
    private final String database = "mysql_test";
    private final String connectionType = "mysql";
    private final String escapeChars = "true";
    private String query = "";
    private String query2 = "";
    private DocumentBuilder builder;
    private MySQLDatabase mysqlDatabase;

    @AfterEach
    public void after(){
        MySQLDatabase mysqlDatabase = new MySQLDatabase();

        mysqlDatabase.drop();
    }

    @BeforeEach
    public void before() throws ParserConfigurationException {

        // Start Camel
        context = new DefaultCamelContext();
        context.start();

        template = context.createProducerTemplate();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();

        mysqlDatabase = new MySQLDatabase();

        mysqlDatabase.create();
        mysqlDatabase.insertMockData();
        mysqlDatabase.createStoredProcedure();

    }

    protected RouteBuilder createCustomRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:execute")
                        .to("sql-custom://" + username + "@" + url + "?password=" + password + "&database=" + database + "&connectionType=" + connectionType + "&query=RAW(" + query + ")")
                        .to("mock:out");


                from("direct:executeWithHeaders")
                        .setHeader("product_id", new ConstantExpression("id"))
                        .setHeader("product_name", new ConstantExpression("name"))
                        .to("sql-custom://" + username + "@" + url + "?password=" + password + "&database=" + database + "&connectionType=" + connectionType + "&query=RAW(" + query + ")")
                        .to("mock:out");

                from("direct:executeWithJsonHeader")
                        .setHeader("product_desc_json", new SimpleExpression("{\"name\":\"John\", \"age\":30, \"car\":null}"))
                        .to("sql-custom://" + username + "@" + url + "?password=" + password + "&database=" + database + "&connectionType=" + connectionType + "&escapeChars=" + escapeChars + "&query=RAW(" + query + ")")
                        .to("direct:executeAfterInsert");

                from("direct:executeAfterInsert")
                        .to("sql-custom://" + username + "@" + url + "?password=" + password + "&database=" + database + "&connectionType=" + connectionType + "&query=RAW(" + query2 + ")")
                        .to("mock:out");
            }
        };
    }

    @Test
    public void testExecuteSelect() throws Exception {
        query = Base64Helper.marshal("select * from products;");

        refreshRoutes();

        // Trigger flow
        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        Node resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results = resultSet.getElementsByTagName("Result");

        Node firstResult = results.item(0);

        assertEquals("3", resultSize.getTextContent());
        assertEquals(3, results.getLength());

        int index = 0;

        for (int i = 0;i < firstResult.getChildNodes().getLength(); i++) {
            Node node = firstResult.getChildNodes().item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                index++;
                switch(index){
                    case 1:
                        assertEquals("id", node.getNodeName());
                        break;
                    case 2:
                        assertEquals("name", node.getNodeName());
                        break;
                    case 3:
                        assertEquals("description", node.getNodeName());
                        break;
                    case 4:
                        assertEquals("price", node.getNodeName());
                        break;
                    case 5:
                        assertEquals("created_at", node.getNodeName());
                        break;
                }
            }
        }

        assertEquals(5, index);
    }

    @Test
    public void testSelectWithHeaders() throws Exception {
        query = Base64Helper.marshal("select ${headers.product_id} from products;");

        refreshRoutes();

        template.sendBody("direct:executeWithHeaders", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        Node resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results = resultSet.getElementsByTagName("Result");

        Node firstResult = results.item(0);

        assertEquals("3", resultSize.getTextContent());
        assertEquals(3, results.getLength());

        int index = 0;

        for (int i = 0;i < firstResult.getChildNodes().getLength(); i++) {
            Node node = firstResult.getChildNodes().item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                index++;
                switch(index){
                    case 1:
                        assertEquals("id", node.getNodeName());
                        break;
                }
            }
        }

        assertEquals(1, index);
    }

    @Test
    public void testSelectWithoutAppropriatedHeaderNames() throws Exception {
        query = Base64Helper.marshal("select version();");

        refreshRoutes();

        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        Node resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results = resultSet.getElementsByTagName("Result");

        assertEquals("1", resultSize.getTextContent());
        assertEquals(1, results.getLength());
    }

    @Test
    public void testExistingEscapedChars() throws Exception {

        query = Base64Helper.marshal("insert into products (name, description, price) values ('Product Name 4', '${header.product_desc_json}', 49.99)");
        query2 = Base64Helper.marshal("select description from products where id = 4;");

        refreshRoutes();

        template.sendBody("direct:executeWithJsonHeader", "");
        getMockEndpoint("mock:out").expectedMessageCount(1);
        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        Node resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results = resultSet.getElementsByTagName("Result");

        assertEquals("1", resultSize.getTextContent());
        assertEquals(1, results.getLength());

        Node descriptionNode = results.item(0).getChildNodes().item(1);

        assertTrue(descriptionNode.getTextContent().contains("\\\""));
    }

    @Test
    public void testShowStatusOperation() throws Exception {
        query = Base64Helper.marshal("show status;");

        refreshRoutes();

        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        Node resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        int resultSizeInt = Integer.parseInt(resultSize.getTextContent());

        assertTrue(resultSizeInt>0);
    }

    @Test
    public void testCallStoredProcedure() throws Exception {
        query = Base64Helper.marshal("call GetAllProducts();");

        refreshRoutes();

        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        Node resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        NodeList results = resultSet.getElementsByTagName("Result");

        assertEquals("3", resultSize.getTextContent());
        assertEquals(3, results.getLength());
    }

    @Test
    public void testErrorExecuteSelect() throws Exception {
        query = Base64Helper.marshal("select id from product;");

        refreshRoutes();

        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String resultBody = result.getIn().getBody(String.class);

        assertTrue(resultBody.contains("<HasErrors>true</HasErrors>"));
        assertTrue(resultBody.contains(String.format("<ErrorMessage>Table '%s.product' doesn't exist</ErrorMessage>", database)));
    }

    @Test
    public void testExecuteInsert() throws Exception {
        query = Base64Helper.marshal("insert into products (name, description, price) values ('Product Name 4', 'Description 4', 49.99)");

        refreshRoutes();

        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        Node resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        Node generatedKey = resultSet.getElementsByTagName("generatedKey").item(0);
        NodeList results = resultSet.getElementsByTagName("Result");

        assertEquals("1", resultSize.getTextContent());
        assertEquals(1, results.getLength());

        assertEquals("4", generatedKey.getTextContent());
    }

    @Test
    public void testExecuteUpdate() throws Exception {
        query = Base64Helper.marshal("update products set name = 'Product Name 1.1' where id=1");

        refreshRoutes();

        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        assertEquals(1, resultSet.getChildNodes().getLength());

        Node hasErrors = resultSet.getChildNodes().item(0);

        assertTrue(hasErrors.getTextContent().contains("false"));
    }

    @Test
    public void testExecuteInsertWithId() throws Exception {
        query = Base64Helper.marshal("delete from products where id=1");

        refreshRoutes();

        template.sendBody("direct:execute", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        assertEquals(1, resultSet.getChildNodes().getLength());

        Node hasErrors = resultSet.getChildNodes().item(0);

        assertTrue(hasErrors.getTextContent().contains("false"));
    }

    @Test
    public void testExecuteInsertWithHeaders() throws Exception {
        query = Base64Helper.marshal("insert into products (${headers.product_name}, description, price) values ('Product Name 4', 'Description 4', 49.99)");

        refreshRoutes();

        template.sendBody("direct:executeWithHeaders", "");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        Document resultSet = builder.parse(
                new InputSource(new StringReader(result.getIn().getBody(String.class)))
        );

        Node resultSize = resultSet.getElementsByTagName("ResultSize").item(0);
        Node generatedKey = resultSet.getElementsByTagName("generatedKey").item(0);
        NodeList results = resultSet.getElementsByTagName("Result");

        assertEquals("1", resultSize.getTextContent());
        assertEquals(1, results.getLength());

        assertEquals("4", generatedKey.getTextContent());
    }

    private void refreshRoutes() throws Exception {

        for(Route r: context.getRoutes()){
            context.removeRoute(r.getId());
        }

        context.addRoutes(createCustomRouteBuilder());
    }
}
