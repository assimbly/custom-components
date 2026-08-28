package org.assimbly.jsontoxmllegacy;

import org.w3c.dom.Node;
import tools.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.assimbly.jsontoxmllegacy.transaction.NodeTransaction;
import org.assimbly.jsontoxmllegacy.transaction.NodeTransactionFactory;
import org.assimbly.jsontoxmllegacy.utils.JsonUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;


public class JsonToXmlProcessor implements Processor {

    // ObjectMapper is thread-safe for concurrent use once built.
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static final String APPLICATION_XML_VALUE = "application/xml";

    private static final DocumentBuilderFactory DOC_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
    private static final TransformerFactory TRANSFORMER_FACTORY =
            TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);

    private final JsonToXmlEndpoint endpoint;

    public JsonToXmlProcessor(JsonToXmlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        JsonToXmlConfiguration config = new JsonToXmlConfiguration(endpoint.getConfiguration());
        config.init();

        String json = exchange.getMessage().getBody(String.class);
        config.setJsonNode(JSON_MAPPER.readTree(json));

        DocumentBuilder documentBuilder = DOC_BUILDER_FACTORY.newDocumentBuilder(); // cheap, not thread-safe itself
        Document document = documentBuilder.newDocument();
        config.setDocument(document);

        Element element = convertJsonToXml(config);
        if (element != null) {
            Node importedElement = document.importNode(element, true);
            document.appendChild(importedElement);
        }

        Transformer transformer = TRANSFORMER_FACTORY.newTransformer(); // also cheap relative to factory creation
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        String xmlContent = writer.toString();

        xmlContent = xmlContent.replaceAll("<([a-zA-Z_][\\w\\-.:]*+)([^<>]*)/>", "<$1$2></$1>");

        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, APPLICATION_XML_VALUE);
        exchange.getIn().setBody(xmlContent);

    }

    public static Element convertJsonToXml(JsonToXmlConfiguration config) {
        try {
            config.setElement(createElement(config));
            NodeTransaction transactionProcessor = NodeTransactionFactory.getProcessorFor(
                    config.getJsonNode().isArray(), config.getJsonNode().isObject()
            );
            return transactionProcessor.process(config);
        } catch (Exception _) {
            return null;
        }
    }

    // create new element
    private static Element createElement(JsonToXmlConfiguration config) {
        Element element;
        String nameSpaceURI;
        String nameSpace;
        String name;

        if(config.getLevel()==0) {
            name = JsonUtils.getRootTagName(config.getJsonNode().getNodeType(), config.getRootName(), config.getArrayName());
        } else {
            name = (config.getName() !=null ? config.getName() : config.getElementName());
        }

        assert name != null;
        String[] nameInfo = name.split(":");
        if(nameInfo.length > 1) {
            nameSpace = "%s:%s".formatted(XMLConstants.XMLNS_ATTRIBUTE, nameInfo[0]);
        } else {
            nameSpace = XMLConstants.XMLNS_ATTRIBUTE;
        }
        nameSpaceURI = config.getXmlnsMap().get(nameSpace);

        if (nameSpaceURI != null && !nameSpaceURI.isEmpty()) {
            element = config.getDocument().createElementNS(nameSpaceURI, name);
        } else {
            element = config.getDocument().createElement(name);
        }

        return element;
    }

}