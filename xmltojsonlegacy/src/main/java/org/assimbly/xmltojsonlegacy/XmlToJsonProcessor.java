package org.assimbly.xmltojsonlegacy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.checker.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.springframework.http.MediaType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XmlToJsonProcessor implements Processor {
    private final XmlToJsonEndpoint endpoint;

    public XmlToJsonProcessor(XmlToJsonEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        XmlToJsonConfiguration config = endpoint.getConfiguration();

        String xml = exchange.getIn().getBody(String.class);
        Document document = convertStringToXMLDocument(xml);
        config.setElement(document.getDocumentElement());

        if(config.isToDiscard()) {
            // no transformation available
            JsonNode jsonNodeResp = objectMapper.createObjectNode().put("noTransformation", "Available");
            setContent(exchange, objectMapper.writeValueAsString(jsonNodeResp));
            return;
        }

        JsonNode jsonNodeResp = convertXmlToJson(config);
        setContent(exchange, objectMapper.writeValueAsString(jsonNodeResp));
    }

    public static JsonNode convertXmlToJson(XmlToJsonConfiguration config) {

        config.initVariables();

        // add attributes in the object node
        ExtractUtils.addAttributesInObjectNode(config);

        // add namespace attribute
        ExtractUtils.addNamespaceAttributeInObjectNode(config, config.getRootObjectNode(), config.getElement(), config.getParentNamespace());

        if (!config.getElement().hasChildNodes()) {
            getObjectResponse(config);
        }

        NodeList nodeList = config.getElement().getChildNodes();
        int nodeListSize = nodeList.getLength();
        int nodeCount = 0;
        for (int index = 0; index < nodeListSize; index++) {
            Node childNode = nodeList.item(index);
            config.setElementMustBeNull(ElementChecker.isElementMustBeNull(config, childNode));

            switch (childNode.getNodeType()) {
                case Node.ELEMENT_NODE:
                    // process element as node
                    nodeCount++;
                    config.setNodeCount(nodeCount);
                    JsonNode processNodeResp = processElementNode(config, childNode);
                    if (processNodeResp != null)
                        return processNodeResp;
                    break;

                case Node.TEXT_NODE:
                    // process element as text
                    if (config.isObject() && config.isRootArray()) {
                        Print.data(" 2. OBJECT && ARRAY", config.getLevel());
                        if (config.getRootObjectNode().size() > 0)
                            config.setRootArray(false);
                    } else {
                        JsonNode processTextResp = processTextNode(config, childNode, index, nodeListSize);
                        if(ExtractUtils.rootObjectNodeContainsTextAttribute(config.getRootObjectNode())) {
                            config.setRootArray(false);
                        }
                        if (processTextResp != null)
                            return processTextResp;
                    }
                    break;

                default:
                    // do nothing
            }
        }

        return getObjectResponse(config);
    }

    // process an element node of type Node
    private static JsonNode processElementNode(XmlToJsonConfiguration config, Node childNode) {
        config.setFirstSibling(ElementChecker.isFirstSiblingByNumCounts(config.getNodeCount()));

        ElementNodeTransaction transactionProcessor = ElementNodeTransactionFactory.getProcessorFor(config);
        return transactionProcessor.process(config, childNode);
    }

    // process an element node of type Text
    private static JsonNode processTextNode(XmlToJsonConfiguration config, Node childNode, int index, int nodeListSize) {
        TextNodeTransaction transactionProcessor = TextNodeTransactionFactory.getProcessorFor(config);
        return transactionProcessor.process(config, childNode, index, nodeListSize);
    }

    private static JsonNode getObjectResponse(XmlToJsonConfiguration config) {
        if(config.isRootNode() && config.isForceTopLevelObject()) {
            ObjectNode parentNode =  JsonNodeFactory.instance.objectNode();
            parentNode.set(
                    ElementUtils.getElementName(config.getElement(), config.isRemoveNamespacePrefixes()),
                    config.isRootArray() ? config.getRootArrayNode() : config.getRootObjectNode()
            );
            return parentNode;
        } else {
            return config.isRootArray() ? config.getRootArrayNode() : config.getRootObjectNode();
        }
    }

    private static Document convertStringToXMLDocument(String xmlString) {
        DocumentBuilder builder = null;
        Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return doc;
        }
    }

    private void setContent(Exchange exchange, String body) {
        setContentTypeHeader(exchange);
        exchange.getIn().setBody(body);
    }

    private void setContentTypeHeader(Exchange exchange) {
        if (exchange.hasOut()) {
            exchange.getOut().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        } else {
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        }
    }
}
