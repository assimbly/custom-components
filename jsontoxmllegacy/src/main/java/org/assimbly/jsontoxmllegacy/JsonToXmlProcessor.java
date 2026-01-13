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

        JsonToXmlConfiguration config = endpoint.getConfiguration();
        config.init();

        String json = exchange.getIn().getBody(String.class);
        config.setJsonNode(jsonMapper.readTree(json));

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        config.setDocument(document);

        Element element = convertJsonToXml(config);

        if (element != null) {
            // Ensure the element is owned by 'document' before appending.
            // This prevents WRONG_DOCUMENT_ERR if 'element' was created by a different Document instance.
            document.adoptNode(element);
            document.appendChild(element);
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

        setContent(exchange, xmlContent);
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
        nameSpaceURI = (config.getXmlnsMap().get(nameSpace)!=null ? config.getXmlnsMap().get(nameSpace) : "");

        element = config.getDocument().createElementNS(nameSpaceURI, name);

        return element;
    }

    private void setContent(Exchange exchange, String body) {
        setContentTypeHeader(exchange);
        exchange.getIn().setBody(body);
    }

    private void setContentTypeHeader(Exchange exchange) {
        if (exchange.hasOut()) {
            exchange.getOut().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
        } else {
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
        }
    }
}
