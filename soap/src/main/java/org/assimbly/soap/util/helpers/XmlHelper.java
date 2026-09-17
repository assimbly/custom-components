package org.assimbly.soap.util.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFactoryConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class XmlHelper {

    private static final Logger log = LoggerFactory.getLogger("org.assimbly.util.helper.XmlHelper");

    private static final String INVALID_CHAR_REGEX = "[^A-Za-z0-9_.-]";

    private static final String INVALID_START_REGEX = "^([0-9.-]|(?i)xml).*";

    /**
     * Creates a DocumentBuilderFactory hardened against XXE: DOCTYPE declarations,
     * external general/parameter entities and XInclude are all disabled.
     */
    private static DocumentBuilderFactory newSecureDocumentBuilderFactory() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);

        return factory;
    }

    /**
     * Creates a TransformerFactory hardened against XXE / external entity access.
     */
    private static TransformerFactory newSecureTransformerFactory() throws TransformerConfigurationException {
        TransformerFactory factory = TransformerFactory.newInstance();

        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

        return factory;
    }

    /**
     * Creates an XPathFactory hardened against XXE for use in XPath evaluation over
     * externally-sourced documents.
     */
    private static XPathFactory newSecureXPathFactory() throws XPathFactoryConfigurationException {
        XPathFactory factory = XPathFactory.newInstance();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        return factory;
    }

    public static Document newDocument(){
        DocumentBuilder icBuilder;

        try {
            DocumentBuilderFactory icFactory = newSecureDocumentBuilderFactory();
            icFactory.setNamespaceAware(true);
            icFactory.setIgnoringElementContentWhitespace(true);
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

        DocumentBuilder icBuilder;

        try {
            icBuilder = newSecureDocumentBuilderFactory().newDocumentBuilder();

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
        try {
            // 1. Create XPath to find all whitespace-only text nodes
            XPath xPath = newSecureXPathFactory().newXPath();
            NodeList nodeList = (NodeList) xPath.evaluate(
                    "//text()[normalize-space()='']",
                    doc,
                    XPathConstants.NODESET
            );

            // 2. Remove those nodes from the DOM
            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                node.getParentNode().removeChild(node);
            }

            // 3. Transform
            Transformer transformer = newSecureTransformerFactory().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(new DOMSource(doc), result);

            return result.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to pretty print XML", e);
        }
    }
    public static String prettyPrint(String xml){
        Document doc = null;

        try {
            DocumentBuilder db = newSecureDocumentBuilderFactory().newDocumentBuilder();
            doc = db.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.error(e.getMessage(), e);
        }

        return prettyPrint(doc);
    }

    public static String prettyPrintWithPossibleException(String xml) throws Exception {
        Document doc;
        DocumentBuilder db = newSecureDocumentBuilderFactory().newDocumentBuilder();
        doc = db.parse(new InputSource(new StringReader(xml)));

        return prettyPrint(doc);
    }

    public static boolean hasInvalidXml(String input) {
        // Check for invalid characters
        if (Pattern.compile(INVALID_CHAR_REGEX).matcher(input).find()) {
            return true;
        }
        // Check for invalid starting patterns
        return Pattern.compile(INVALID_START_REGEX).matcher(input).matches();
    }

}