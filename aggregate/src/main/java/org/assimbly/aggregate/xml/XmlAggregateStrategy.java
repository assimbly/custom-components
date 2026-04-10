package org.assimbly.aggregate.xml;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


public class XmlAggregateStrategy implements AggregationStrategy {

    private static final Logger log = LoggerFactory.getLogger(XmlAggregateStrategy.class);

    @Override
    public Exchange aggregate(Exchange newExchange, Exchange splitExchange) {

        try {
            String splitXml = getBody(splitExchange);
            String newXml = getBody(newExchange);

            boolean isSplitXmlNull = splitXml == null;
            boolean isNewXmlNull = newXml == null;

            if(isNewXmlNull && isSplitXmlNull) {
                throw new Exception("XML Aggregate: Inputs are empty.");
            }

            if(isNewXmlNull) {
                newXml = buildAggregateBody("", splitXml);
                splitExchange.getIn().setBody(newXml);
                return splitExchange;
            }

            newXml = buildAggregateBody(newXml, splitXml);

            newExchange.getIn().setBody(newXml);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return newExchange;
    }

    private String buildAggregateBody(String newXml, String splitXml) {

        String result;

        if(containsXmlDeclaration(splitXml)) {
            // removes xml declaration from splitXml
            int declarationEndPos = splitXml.indexOf("?>");
            splitXml = splitXml.substring(declarationEndPos + 2);
        }

        String aggregateEndTag = "</Aggregated>";
        if(newXml.endsWith(aggregateEndTag)) {
            result = StringUtils.substring(newXml, 0, newXml.length() - aggregateEndTag.length()) + splitXml + aggregateEndTag;
        } else {
            String xmlDeclaration = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
            String aggregateStartTag = "<Aggregated>";
            result = xmlDeclaration + aggregateStartTag + splitXml + aggregateEndTag;
        }
        return result;
    }

    private boolean containsXmlDeclaration(String xml) {
        return xml.trim().startsWith("<?xml");
    }

    private String getBody(Exchange exchange) {

        try {
            return exchange.getIn().getBody(String.class);
        } catch (Exception _) {
            if (log.isDebugEnabled()) {
                log.debug("Unable to get data from the route to the Aggregate component.");
            }
        }

        return null;
    }

    public static Document newDocument(){
        DocumentBuilderFactory icFactory;
        DocumentBuilder icBuilder;

        try {
            icFactory = DocumentBuilderFactory.newInstance();
            icBuilder = icFactory.newDocumentBuilder();

            return icBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public static Document newDocument(String xml){
        if(xml == null) {
            return null;
        }

        DocumentBuilderFactory icFactory;
        DocumentBuilder icBuilder;

        try {
            icFactory = DocumentBuilderFactory.newInstance();
            icBuilder = icFactory.newDocumentBuilder();

            return icBuilder.parse(
                    new InputSource(new StringReader(xml))
            );
        } catch (SAXException | IOException | ParserConfigurationException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public static List<Element> getChildrenByTagName(Element parent, String name) {
        List<Element> nodeList = new ArrayList<>();
        for (Node child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == Node.ELEMENT_NODE &&
                    name.equals(child.getNodeName())) {
                nodeList.add((Element) child);
            }
        }

        return nodeList;
    }


    public static Document mergeIn(Document original, Document addition) {

        Node copy = original.importNode(addition.getFirstChild(), true);

        original.getFirstChild().appendChild(copy);

        return original;
    }

    public static String prettyPrint(Node doc) {
        Transformer transformer;
        StreamResult result = new StreamResult(new StringWriter());

        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            transformer.transform(new DOMSource(doc), result);
        } catch (TransformerException e) {
            log.error(e.getMessage(), e);
        }

        return result.getWriter().toString();
    }

    public static String prettyPrint(String xml){
        Document doc = null;

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = db.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.error(e.getMessage(), e);
        }

        return prettyPrint(doc);
    }


}
