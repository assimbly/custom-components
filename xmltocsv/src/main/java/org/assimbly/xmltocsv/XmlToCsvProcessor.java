package org.assimbly.xmltocsv;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.assimbly.xmltocsv.domain.OrderHeaders;
import org.assimbly.xmltocsv.domain.QuoteFields;
import org.assimbly.xmltocsv.exception.Xml2CsvException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class XmlToCsvProcessor implements Processor {
    private final XmlToCsvEndpoint endpoint;
    private static final char HEADER_SEPARATOR_CHAR = '&';

    public XmlToCsvProcessor(XmlToCsvEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String input = exchange.getIn().getBody(String.class);
        Document document = parseXmlToDocument(input);
        String output = transform(document);
        exchange.getIn().setBody(output);
    }

    public String transform(Document document) {
        XmlToCsvConfiguration config = endpoint.getConfiguration();
        XPath xPath = XPathFactory.newInstance().newXPath();
        Node root = document.getDocumentElement();
        String xPathExpression = config.getXPathExpression();
        NodeList nodes;

        if (xPathExpression != null && !xPathExpression.isEmpty()) {
            try {
                nodes = (NodeList) xPath.evaluate(xPathExpression, root, XPathConstants.NODESET);
            } catch (XPathExpressionException e) {
                throw new Xml2CsvException("Error evaluating the XPath expression: " + e.getMessage());
            }
        }
        else {
            String nodeName = root.getFirstChild().getNextSibling().getNodeName();
            nodes = document.getElementsByTagName(nodeName);
        }

        Set<String> headers = scanHeaders(nodes);
        headers = orderHeaders(headers, config.getOrderHeaders());

        return convertXmlToCsv(headers, nodes, config);
    }

    private Set<String> scanHeaders(NodeList nodes) {
        Set<String> headers = new LinkedHashSet<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            NodeList elementChildren = nodes.item(i).getChildNodes();
            for (int j = 0; j < elementChildren.getLength(); j++) {
                Node node = elementChildren.item(j);
                NodeList childNodes = node.getChildNodes();
                int childNodesLength = childNodes.getLength();

                if (childNodesLength == 1 && node.getNodeType() == Node.ELEMENT_NODE) {
                    headers.add(node.getNodeName());
                }
                for (int k = 0; k < childNodesLength; k++) {
                    Node currentNode = childNodes.item(k);
                    if (currentNode.getNodeType() == Node.ELEMENT_NODE
                            && currentNode.getChildNodes().getLength() == 1) {
                        String currentNodeName = currentNode.getNodeName();
                        String parentNodeName = currentNode.getParentNode().getNodeName();
                        headers.add(parentNodeName + HEADER_SEPARATOR_CHAR + currentNodeName);
                    }
                }
            }
        }

        return headers;
    }

    private String convertXmlToCsv(Set<String> headers, NodeList nodes, XmlToCsvConfiguration config) {
        StringBuilder builder = new StringBuilder();

        if (config.hasHeader()) {
            addHeaderLine(headers, config, builder);
        }

        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);

            if (config.hasIndexColumn()) {
                builder.append(i + 1).append(config.getDelimiter());
            }

            addLine(headers, element, config, builder);
        }

        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    private void addLine(Set<String> headers, Element element, XmlToCsvConfiguration config, StringBuilder builder) {
        for (String header : headers) {
            String text = "";
            String headerSeparator = String.valueOf(HEADER_SEPARATOR_CHAR);

            if (header.contains(headerSeparator)) {
                String[] headerSplit = header.split(headerSeparator);

                NodeList nodes = element.getElementsByTagName(headerSplit[0]);
                Element childElement = (Element) nodes.item(0);
                if (childElement != null) {
                    NodeList childNodes = childElement.getElementsByTagName(headerSplit[1]);
                    if (childNodes.getLength() > 0) {
                        text = childNodes.item(0).getTextContent();
                    }
                }
            }
            else {
                NodeList nodes = element.getElementsByTagName(header);
                if (nodes.getLength() > 0) {
                    text = nodes.item(0).getTextContent();
                }
            }

            text = applyQuotationOption(text, config.getQuoteFields());
            builder.append(text).append(config.getDelimiter());
        }

        builder.setLength(builder.length() - 1);
        builder.append(config.getLineSeparator());
    }

    private void addHeaderLine(Set<String> headers, XmlToCsvConfiguration config, StringBuilder builder) {
        if (config.hasIndexColumn()) {
            String headerText = applyQuotationOption(config.getIndexColumnName(), config.getQuoteFields());
            builder.append(headerText).append(config.getDelimiter());
        }

        for (String header : headers) {
            String headerText = applyQuotationOption(header, config.getQuoteFields());
            headerText = headerText.replace(HEADER_SEPARATOR_CHAR, '_');
            builder.append(headerText).append(config.getDelimiter());
        }

        builder.setLength(builder.length() - 1);
        builder.append(config.getLineSeparator());
    }

    private Set<String> orderHeaders(Set<String> headers, OrderHeaders orderHeaders) {
        Set<String> result = headers;
        if (orderHeaders != OrderHeaders.UNORDERED) {
            if (orderHeaders == OrderHeaders.ASCENDING) {
                result = new TreeSet<>(headers);
            }
            else if (orderHeaders == OrderHeaders.DESCENDING) {
                result = new TreeSet<>(headers).descendingSet();
            }
        }
        return result;
    }

    private String applyQuotationOption(String content, QuoteFields quoteFields) {
        String result;
        switch(quoteFields) {
            case ALL_FIELDS:
                result = '"' + content + '"';
                break;
            case NON_INTEGER_FIELDS:
                result = (content.matches("-?\\d+")) ? content : '"' + content + '"';
                break;
            case NO_FIELDS:
                result = content;
                break;
            default:
                result = '"' + content + '"';
        }
        return result;
    }

    private Document parseXmlToDocument(String xml) throws Exception {
        DocumentBuilder builder = createSecureDocumentBuilder();
        InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(xml));
        return builder.parse(inputSource);
    }

    private DocumentBuilder createSecureDocumentBuilder() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Disable DTDs, prevents almost all XXE attacks
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        // Per Timothy Morgan's 2014 paper: "XML Schema, DTD, and Entity Attacks"
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);

        return factory.newDocumentBuilder();
    }
}
