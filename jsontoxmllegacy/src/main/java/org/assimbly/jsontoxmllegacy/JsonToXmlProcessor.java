package org.assimbly.jsontoxmllegacy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.assimbly.jsontoxmllegacy.transaction.NodeTransaction;
import org.assimbly.jsontoxmllegacy.transaction.NodeTransactionFactory;
import org.assimbly.jsontoxmllegacy.utils.JsonUtils;
import org.springframework.http.MediaType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;


public class JsonToXmlProcessor implements Processor {
    private final JsonToXmlEndpoint endpoint;

    public JsonToXmlProcessor(JsonToXmlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        ObjectMapper jsonMapper = new ObjectMapper();

        // Work on a private copy per exchange — never mutate the shared,
        // endpoint-scoped configuration instance directly.
        JsonToXmlConfiguration config = endpoint.getConfiguration().clone();
        config.init();

        String json = exchange.getMessage().getBody(String.class);
        config.setJsonNode(jsonMapper.readTree(json));

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        config.setDocument(document);

        Element element = convertJsonToXml(config);

        if (element != null) {
            // importNode (deep=true) copies the element AND all its descendants
            // into 'document', whereas adoptNode moves only the node itself.
            Node importedElement = document.importNode(element, true);
            document.appendChild(importedElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance(
                "net.sf.saxon.TransformerFactoryImpl",
                null
        );
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        String xmlContent = writer.toString();

        // post-processing to convert self-closing tags to <tag></tag>
        xmlContent = xmlContent.replaceAll("<([a-zA-Z_][\\w\\-.:]*)([^<>]*)/>", "<$1$2></$1>");

        exchange.getMessage().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
        exchange.getMessage().setBody(xmlContent);

    }

    public static Element convertJsonToXml(JsonToXmlConfiguration config) {
        try {
            config.setElement(createElement(config));
            NodeTransaction transactionProcessor = NodeTransactionFactory.getProcessorFor(
                    config.getJsonNode().isArray(), config.getJsonNode().isObject()
            );
            return transactionProcessor.process(config);
        } catch (Exception e) {
            return null;
        }
    }

    // create new element
    private static Element createElement(JsonToXmlConfiguration config) {
        Element element;
        String nameSpaceURI, nameSpace, name = "";

        if(config.getLevel()==0) {
            name = JsonUtils.getRootTagName(config.getJsonNode().getNodeType(), config.getRootName(), config.getArrayName());
        } else {
            name = (config.getName() !=null ? config.getName() : config.getElementName());
        }

        String[] nameInfo = name.split(":");
        if(nameInfo.length > 1) {
            nameSpace = String.format("%s:%s", XMLConstants.XMLNS_ATTRIBUTE, nameInfo[0]);
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
