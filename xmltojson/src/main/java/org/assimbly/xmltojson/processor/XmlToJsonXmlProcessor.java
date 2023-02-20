package org.assimbly.xmltojson.processor;

import org.apache.camel.Exchange;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.assimbly.xmltojson.CustomXmlJsonDataFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

/*
    Process the incoming XML before it is converted to JSON.
    Basically it loops through all XML nodes and its attributes to processes them:
        - Remove namespaces when this option is set to true by user.
        - Prefix XML nodes that have the name "type"
            - Prefix is `ASSIMBLY_TYPE_PREFIX`
            - Prefix is removed in JSON processor after processing of type attributes
        - Prefix XML attributes with our own prefix
            - Prefix is 'ASSIMBLY_ATTR_PREFIX', because symbols are not allowed at
              beginning of XML attributes
                - In the JSON processor the prefix is replaced with "@"
            - Type attributes will not be prefixed when user has specified that
              the XML has types.
*/
public class XmlToJsonXmlProcessor {
    private final CustomXmlJsonDataFormat xmlJsonDataFormat;
    private final Document xmlDoc;
    private final Exchange exchange;
    private final boolean hasTypes, removeNamespaces;
    private final String xmlAttrPrefix, xmlTypeNodePrefix;

    public XmlToJsonXmlProcessor(Exchange exchange, CustomXmlJsonDataFormat xmlJsonDataFormat,
        Object xmlData) throws Exception {
        this.xmlJsonDataFormat = xmlJsonDataFormat;
        this.exchange = exchange;
        this.hasTypes = xmlJsonDataFormat.getHasTypes();
        this.removeNamespaces = xmlJsonDataFormat.getRemoveNamespaces();
        this.xmlAttrPrefix = xmlJsonDataFormat.getXmlAttrPrefix();
        this.xmlTypeNodePrefix = xmlJsonDataFormat.getXmlTypeNodePrefix();
        this.xmlDoc = getDocumentFromRawData(xmlData);
    }

    public void processXml() {
        Node rootNode = xmlDoc.getDocumentElement();
        processXmlNodeAndAttributes(rootNode);
    }

    private void processXmlNodeAndAttributes(Node node) {
        if (node.getNodeType() != Node.ELEMENT_NODE)
            return;

        processChildNodesAndAttributes(node);
        checkNodeNameForNamespaces(node);
        checkNodeAttributesForNamespaces(node.getAttributes());
        prefixTypeNodeName(node);
        prefixNodeAttributes(node.getAttributes());
    }

    private void processChildNodesAndAttributes(Node parentNode) {
        NodeList childNodes = parentNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            processXmlNodeAndAttributes(childNodes.item(i));
        }
    }

    private void checkNodeNameForNamespaces(Node node) {
        if (!removeNamespaces)
            return;

        String originalName = node.getNodeName();
        int indexOfColon = originalName.indexOf(":");
        boolean isNodeNamespaced = indexOfColon != -1;

        if (!isNodeNamespaced)
            return;

        String cleanedName = originalName.substring(indexOfColon + 1);
        xmlDoc.renameNode(node, null, cleanedName);
    }

    private void checkNodeAttributesForNamespaces(NamedNodeMap nodeAttributes) {
        if (!removeNamespaces)
            return;

        ArrayList<String> namespaceAttrsInNode = new ArrayList<>();

        for (int i = 0; i < nodeAttributes.getLength(); i++) {
            Node nodeAttribute = nodeAttributes.item(i);
            String attributeName =  nodeAttribute.getNodeName();
            boolean isNamespaceAttribute =  attributeName.startsWith("xmlns");

            if (isNamespaceAttribute)
                namespaceAttrsInNode.add(attributeName);
        }

        namespaceAttrsInNode.forEach(namespaceAttr -> nodeAttributes.removeNamedItem(namespaceAttr));

        if (nodeAttributes.getLength() == 0)
            return;

        ArrayList<String> prefixedAttrsInNode = new ArrayList<>();

        for (int i = 0; i < nodeAttributes.getLength(); i++) {
            Node nodeAttribute = nodeAttributes.item(i);
            String attributeName =  nodeAttribute.getNodeName();
            boolean isAttributeWithNamespacePrefix =  attributeName.contains(":");

            if (isAttributeWithNamespacePrefix)
                prefixedAttrsInNode.add(attributeName);
        }

        prefixedAttrsInNode.forEach(nodeAttributes::removeNamedItem);
    }

    private void prefixTypeNodeName(Node node) {
        String originalName = node.getNodeName();
        boolean isNameEqualToTypeAttrName = "type".equals(originalName);

        if (!isNameEqualToTypeAttrName)
            return;

        String prefixedName = xmlTypeNodePrefix + originalName;
        xmlDoc.renameNode(node, null, prefixedName);
    }

    private void prefixNodeAttributes(NamedNodeMap nodeAttributes) {
        for (int i = 0; i < nodeAttributes.getLength(); i++) {
            Node nodeAttribute = nodeAttributes.item(i);
            String attributeName =  nodeAttribute.getNodeName();
            boolean isTypeAttribute = "type".equals(attributeName);

            if (hasTypes && isTypeAttribute)
                continue;

            String prefixedAttributeName = this.xmlAttrPrefix + attributeName;
            xmlDoc.renameNode(nodeAttribute, null, prefixedAttributeName);
        }
    }

    private Document getDocumentFromRawData(Object xmlData) throws Exception {
        byte[] bytes = this.exchange
                            .getContext()
                            .getTypeConverter()
                            .mandatoryConvertTo(byte[].class, xmlData);
        ByteArrayInputStream xml = new ByteArrayInputStream(bytes);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(false);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(xml);
    }

    public ByteArrayOutputStream getOutputStreamFromXmlDoc() throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(xmlDoc);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(outputStream);
        transformer.transform(source, result);
        return outputStream;
    }
}
