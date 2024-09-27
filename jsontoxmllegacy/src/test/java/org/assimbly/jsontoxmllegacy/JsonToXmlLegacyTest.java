package org.assimbly.jsontoxmllegacy;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class JsonToXmlLegacyTest extends CamelTestSupport {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    /*****************************************
    ** Example 1
    *****************************************/

    @Test
    public void testJsonXml_1_EARFF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root",
                "json-to-xml/example_1.json",
                "json-to-xml/example_1_EARFF.xml"
        );
    }

    @Test
    public void testJsonXml_1_EARTF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient",
                "json-to-xml/example_1.json",
                "json-to-xml/example_1_EARTF.xml"
        );
    }

    @Test
    public void testJsonXml_1_EARFT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_TypeHints",
                "json-to-xml/example_1.json",
                "json-to-xml/example_1_EARFT.xml"
        );
    }

    @Test
    public void testJsonXml_1_EARTT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient_TypeHints",
                "json-to-xml/example_1.json",
                "json-to-xml/example_1_EARTT.xml"
        );
    }

    @Test
    public void testJsonXml_1_EATT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_NamespaceLenient_TypeHints",
                "json-to-xml/example_1.json",
                "json-to-xml/example_1_EATT.xml"
        );
    }

    /*****************************************
     ** Example 2
     *****************************************/

    @Test
    public void testJsonXml_2_EARFF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root",
                "json-to-xml/example_2.json",
                "json-to-xml/example_2_EARFF.xml"
        );
    }

    @Test
    public void testJsonXml_2_EARTF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient",
                "json-to-xml/example_2.json",
                "json-to-xml/example_2_EARTF.xml"
        );
    }

    @Test
    public void testJsonXml_2_EARFT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_TypeHints",
                "json-to-xml/example_2.json",
                "json-to-xml/example_2_EARFT.xml"
        );
    }

    @Test
    public void testJsonXml_2_EARTT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient_TypeHints",
                "json-to-xml/example_2.json",
                "json-to-xml/example_2_EARTT.xml"
        );
    }

    @Test
    public void testJsonXml_2_EATT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_NamespaceLenient_TypeHints",
                "json-to-xml/example_2.json",
                "json-to-xml/example_2_EATT.xml"
        );
    }

    /*****************************************
     ** Example 3
     *****************************************/

    @Test
    public void testJsonXml_3_EARFF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root",
                "json-to-xml/example_3.json",
                "json-to-xml/example_3_EARFF.xml"
        );
    }

    @Test
    public void testJsonXml_3_EARTF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient",
                "json-to-xml/example_3.json",
                "json-to-xml/example_3_EARTF.xml"
        );
    }

    @Test
    public void testJsonXml_3_EARFT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_TypeHints",
                "json-to-xml/example_3.json",
                "json-to-xml/example_3_EARFT.xml"
        );
    }

    @Test
    public void testJsonXml_3_EARTT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient_TypeHints",
                "json-to-xml/example_3.json",
                "json-to-xml/example_3_EARTT.xml"
        );
    }

    @Test
    public void testJsonXml_3_EATT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_NamespaceLenient_TypeHints",
                "json-to-xml/example_3.json",
                "json-to-xml/example_3_EATT.xml"
        );
    }

    /*****************************************
     ** Example 4
     *****************************************/

    @Test
    public void testJsonXml_4_EARFF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root",
                "json-to-xml/example_4.json",
                "json-to-xml/example_4_EARFF.xml"
        );
    }

    @Test
    public void testJsonXml_4_EARTF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient",
                "json-to-xml/example_4.json",
                "json-to-xml/example_4_EARTF.xml"
        );
    }

    @Test
    public void testJsonXml_4_EARFT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_TypeHints",
                "json-to-xml/example_4.json",
                "json-to-xml/example_4_EARFT.xml"
        );
    }

    @Test
    public void testJsonXml_4_EARTT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient_TypeHints",
                "json-to-xml/example_4.json",
                "json-to-xml/example_4_EARTT.xml"
        );
    }

    @Test
    public void testJsonXml_4_EATT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_NamespaceLenient_TypeHints",
                "json-to-xml/example_4.json",
                "json-to-xml/example_4_EATT.xml"
        );
    }

    /*****************************************
     ** Example 5
     *****************************************/

    @Test
    public void testJsonXml_5_EARFF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root",
                "json-to-xml/example_5.json",
                "json-to-xml/example_5_EARFF.xml"
        );
    }

    @Test
    public void testJsonXml_5_EARTF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient",
                "json-to-xml/example_5.json",
                "json-to-xml/example_5_EARTF.xml"
        );
    }

    @Test
    public void testJsonXml_5_EARFT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_TypeHints",
                "json-to-xml/example_5.json",
                "json-to-xml/example_5_EARFT.xml"
        );
    }

    @Test
    public void testJsonXml_5_EARTT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient_TypeHints",
                "json-to-xml/example_5.json",
                "json-to-xml/example_5_EARTT.xml"
        );
    }

    @Test
    public void testJsonXml_5_EATT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_NamespaceLenient_TypeHints",
                "json-to-xml/example_5.json",
                "json-to-xml/example_5_EATT.xml"
        );
    }

    /*****************************************
     ** Example 6
     *****************************************/

    @Test
    public void testJsonXml_6_EARFF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root",
                "json-to-xml/example_6.json",
                "json-to-xml/example_6_EARFF.xml"
        );
    }

    @Test
    public void testJsonXml_6_EARTF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient",
                "json-to-xml/example_6.json",
                "json-to-xml/example_6_EARTF.xml"
        );
    }

    @Test
    public void testJsonXml_6_EARFT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_TypeHints",
                "json-to-xml/example_6.json",
                "json-to-xml/example_6_EARFT.xml"
        );
    }

    @Test
    public void testJsonXml_6_EARTT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient_TypeHints",
                "json-to-xml/example_6.json",
                "json-to-xml/example_6_EARTT.xml"
        );
    }

    @Test
    public void testJsonXml_6_EATT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_NamespaceLenient_TypeHints",
                "json-to-xml/example_6.json",
                "json-to-xml/example_6_EATT.xml"
        );
    }

    /*****************************************
     ** Example 7
     *****************************************/

    @Test
    public void testJsonXml_7_EARFF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root",
                "json-to-xml/example_7.json",
                "json-to-xml/example_7_EARFF.xml"
        );
    }

    @Test
    public void testJsonXml_7_EARTF() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient",
                "json-to-xml/example_7.json",
                "json-to-xml/example_7_EARTF.xml"
        );
    }

    @Test
    public void testJsonXml_7_EARFT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_TypeHints",
                "json-to-xml/example_7.json",
                "json-to-xml/example_7_EARFT.xml"
        );
    }

    @Test
    public void testJsonXml_7_EARTT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_Root_NamespaceLenient_TypeHints",
                "json-to-xml/example_7.json",
                "json-to-xml/example_7_EARTT.xml"
        );
    }

    @Test
    public void testJsonXml_7_EATT() throws Exception {
        compareInputJsonFileWithOutputXmlFile(
                "jsontoxmllegacy_Element_Array_NamespaceLenient_TypeHints",
                "json-to-xml/example_7.json",
                "json-to-xml/example_7_EATT.xml"
        );
    }

    private void compareInputJsonFileWithOutputXmlFile(String routeName, String inputJsonFile, String outputXmlFile)
            throws IOException, InterruptedException {
        String defaultJson = IOUtils.toString(classLoader.getResourceAsStream(inputJsonFile), StandardCharsets.UTF_8);
        String defaultXml = IOUtils.toString(classLoader.getResourceAsStream(outputXmlFile), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);
        template.sendBody("direct:"+routeName, defaultJson);
        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document defaultXmlDoc = builder.parse(new InputSource(new StringReader(removeNewlines(defaultXml))));
            Document exchangeBodyDoc = builder.parse(new InputSource(new StringReader(removeNewlines(exchangeBody))));

            normalizeXML(defaultXmlDoc.getDocumentElement());
            normalizeXML(exchangeBodyDoc.getDocumentElement());

            Diff xmlDiff = DiffBuilder
                    .compare(defaultXmlDoc)
                    .withTest(exchangeBodyDoc)
                    .ignoreWhitespace()
                    .ignoreComments()
                    .ignoreElementContentWhitespace()
                    .build();

            assertFalse(xmlDiff.hasDifferences());

        } catch (Exception e) {
            assertFalse(true);
        }

        resultEndpoint.assertIsSatisfied();
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size -1);
    }

    private static void normalizeXML(Element element) {
        // Normalize attributes by sorting them
        NamedNodeMap attributes = element.getAttributes();
        List<Node> attributeList = new ArrayList<>();

        for (int i = 0; i < attributes.getLength(); i++) {
            attributeList.add(attributes.item(i));
        }

        attributeList.sort(Comparator.comparing(Node::getNodeName));

        for (Node attribute : attributeList) {
            element.removeAttribute(attribute.getNodeName());
        }

        for (Node attribute : attributeList) {
            element.setAttributeNode((Attr) attribute);
        }

        // Normalize child elements recursively
        NodeList children = element.getChildNodes();
        List<Node> childElements = new ArrayList<>();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                childElements.add(child);
            }
        }

        for (Node child : childElements) {
            element.removeChild(child);
        }

        childElements.sort(Comparator.comparing(Node::getNodeName));

        for (Node child : childElements) {
            element.appendChild(child);
            normalizeXML((Element) child);
        }
    }

    private static String removeNewlines(String xml) {
        return xml.replaceAll("\\n", "").replaceAll("\\r", "");
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        return new RouteBuilder[] {
                new RouteBuilder() {
                    public void configure() {
                        from("direct:jsontoxmllegacy_Element_Array_Root")
                                .to("jsontoxmllegacy://?elementName=element&arrayName=array&rootName=root&namespaceLenient=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:jsontoxmllegacy_Element_Array_Root_NamespaceLenient")
                                .to("jsontoxmllegacy://?elementName=element&arrayName=array&rootName=root&namespaceLenient=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:jsontoxmllegacy_Element_Array_Root_TypeHints")
                                .to("jsontoxmllegacy://?elementName=element&arrayName=array&rootName=root&namespaceLenient=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:jsontoxmllegacy_Element_Array_Root_NamespaceLenient_TypeHints")
                                .to("jsontoxmllegacy://?elementName=element&arrayName=array&rootName=root&namespaceLenient=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:jsontoxmllegacy_Element_Array_NamespaceLenient_TypeHints")
                                .to("jsontoxmllegacy://?elementName=element&arrayName=array&namespaceLenient=true&typeHints=true")
                                .to("mock:result");
                    }
                },
        };
    }

}
