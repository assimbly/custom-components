package org.assimbly.xmltoexcel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.assimbly.xmltoexcel.domain.ExcelWriter;
import org.assimbly.xmltoexcel.domain.OrderHeaders;
import org.assimbly.xmltoexcel.domain.CustomWorksheet;
import org.assimbly.xmltoexcel.exception.XmlToExcelException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.*;


public class XmlToExcelProcessor implements Processor {
    private final XmlToExcelConfiguration config;
    private ExcelWriter excelWriter;
    private static final char HEADER_SEPARATOR_CHAR = '&';

    public XmlToExcelProcessor(XmlToExcelEndpoint endpoint) {
        this.config = endpoint.getConfiguration();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        excelWriter = new ExcelWriter(config.getExcelFormat());
        String input = exchange.getIn().getBody(String.class);
        Document document = parseXmlToDocument(input);
        byte[] output = convertXmlToExcel(document);
        exchange.getIn().setBody(output);
        exchange.getIn().setHeader(Exchange.FILE_NAME, getDocumentName(document));
        exchange.getIn().setHeader("Content-Disposition", "attachment; filename=" + getDocumentName(document));
    }

    private String getDocumentName(Document document){

        String rootName = document.getDocumentElement().getNodeName();
        String fileExtension = config.getExcelFormat().toString().toLowerCase();

        if(rootName!=null || !rootName.isEmpty()){
            return rootName + "." + fileExtension ;
        }else{
            return "Workbook1." + fileExtension;
        }

    }

    private byte[] convertXmlToExcel(Document document) throws Exception {

        Node root = document.getDocumentElement();
        boolean useCustomWorksheets = config.getUseCustomWorksheets();

        if (useCustomWorksheets) {
            List<CustomWorksheet> worksheets = config.getWorksheets();
            runCustomSheetProcessing(root, worksheets);
        }else {
            runStandardProcessing(root);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            excelWriter.write(outputStream);
        } finally {
            outputStream.close();
        }
        return outputStream.toByteArray();
    }

    private void runStandardProcessing(Node root) {
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                String nodeName = node.getFirstChild().getNextSibling().getNodeName();
                NodeList nodes = root.getOwnerDocument().getElementsByTagName(nodeName);

                createSheet(node.getNodeName(), nodes);
            }
        }
    }

    private void runCustomSheetProcessing(Node root, List<CustomWorksheet> worksheets) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodes;

        for (CustomWorksheet worksheet : worksheets) {
            try {
                nodes = (NodeList) xPath.evaluate(worksheet.getXPathExpression(), root, XPathConstants.NODESET);
            } catch (XPathExpressionException e) {
                throw new XmlToExcelException("Error evaluating the XPath expression: " + e.getMessage());
            }

            Node firstNode = nodes.item(0);
            Node secondNode = nodes.item(1);
            if (secondNode == null) {
                Node firstChildNode = firstNode.getFirstChild().getNextSibling();
                String elementName = firstChildNode.getNodeName();
                nodes = root.getOwnerDocument().getElementsByTagName(elementName);
            }

            createSheet(worksheet.getName(), nodes);
        }
    }

    private void createSheet(String sheetName, NodeList nodes) {

        excelWriter.addSheet(sheetName);

        Set<String> headers = scanHeaders(nodes);
        headers = orderHeaders(headers, config.getOrderHeaders());

        writeElementsToSheet(headers, nodes);
    }

    private void writeElementsToSheet(Set<String> headers, NodeList nodes) {

        if (config.hasHeader()) {
            addHeaderLine(headers);
        }

        for (int i = 0; i < nodes.getLength(); i++) {
            excelWriter.addRow();
            Element element = (Element) nodes.item(i);

            if (config.hasIndexColumn()) {
                excelWriter.addCell(i + 1);
            }

            writeElementsToRow(headers, element);
        }

    }

    private void writeElementsToRow(Set<String> headers, Element element) {
        for (String header : headers) {
            String content = "";
            String headerSeparator = String.valueOf(HEADER_SEPARATOR_CHAR);
            if (header.contains(headerSeparator)) {
                String[] headerSplit = header.split(headerSeparator, 2);

                NodeList nodes = element.getElementsByTagName(headerSplit[0]);
                Element childElement = (Element) nodes.item(0);
                if (childElement != null) {
                    NodeList childNodes = childElement.getElementsByTagName(headerSplit[1]);
                    if (childNodes.getLength() > 0) {
                        content = childNodes.item(0).getTextContent();
                    }
                }
            }
            else {
                NodeList nodes = element.getElementsByTagName(header);
                if (nodes.getLength() > 0) {
                    content = nodes.item(0).getTextContent();
                }
            }
            excelWriter.addCell(content);
        }
    }

    private void addHeaderLine(Set<String> headers) {
        excelWriter.addRow();

        if (config.hasIndexColumn()) {
            excelWriter.addCell(config.getIndexColumnName());
        }

        for (String header : headers) {
            header = header.replace(HEADER_SEPARATOR_CHAR,'_');
            excelWriter.addCell(header);
        }
    }

    private Set<String> scanHeaders(NodeList nodes) {
        Set<String> headers = new LinkedHashSet<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            NodeList elementChildren = nodes.item(i).getChildNodes();
            for (int j = 0; j < elementChildren.getLength(); j++) {
                Node node = elementChildren.item(j);
                NodeList childNodes = node.getChildNodes();
                int childNodesLength = childNodes.getLength();

                if (childNodesLength <= 1 && node.getNodeType() == Node.ELEMENT_NODE) {
                    headers.add(node.getNodeName());
                }

                for (int x = 0; x < childNodesLength; x++) {
                    Node currentNode = childNodes.item(x);
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
        // Disable external DTDs
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        // Per Timothy Morgan's 2014 paper: "XML Schema, DTD, and Entity Attacks"
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);

        return factory.newDocumentBuilder();
    }
}
