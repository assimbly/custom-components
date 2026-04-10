package org.assimbly.soap.util.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
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

    public static Document newDocument(){
        DocumentBuilderFactory icFactory;
        DocumentBuilder icBuilder;

        try {
            icFactory = DocumentBuilderFactory.newInstance();
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
        try {
            // 1. Create XPath to find all whitespace-only text nodes
            XPath xPath = XPathFactory.newInstance().newXPath();
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
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
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
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = db.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.error(e.getMessage(), e);
        }

        return prettyPrint(doc);
    }

    public static String prettyPrintWithPossibleException(String xml) throws Exception {
        Document doc;
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
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
