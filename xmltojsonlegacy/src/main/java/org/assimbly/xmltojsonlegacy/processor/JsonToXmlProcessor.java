package org.assimbly.xmltojsonlegacy.processor;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.log4j.Logger;
import org.assimbly.xmltojsonlegacy.CustomXmlJsonDataFormat;
import org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.NodeTransaction;
import org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.NodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.utils.JsonUtils;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;

public class JsonToXmlProcessor {

    static final Logger logger = Logger.getLogger(JsonToXmlProcessor.class);

    private static CustomXmlJsonDataFormat xmlJsonDataFormat;

    public JsonToXmlProcessor(CustomXmlJsonDataFormat xmlJsonDataFormat) {
        this.xmlJsonDataFormat = xmlJsonDataFormat;
    }

    // start the json to xml conversion
    public static Document convertJsonToXml(JsonNode jsonNode, int level) {

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element xmlStepEle = convertEachJsonStepIntoXmlDocument(jsonNode, document, null, null,
                    level, new HashMap<String, String>());

            document.appendChild(xmlStepEle);

            return document;

        } catch (Exception e) {
            logger.error("Error to convert json to xml", e);
            return null;
        }
    }

    // convert each json step into a xml document
    public static Element convertEachJsonStepIntoXmlDocument(
            JsonNode jsonNode, Document document, Element element, String elementName, int level, HashMap<String,
            String> xmlnsMap
    ) {

        try {
            element = createElement(jsonNode, document, elementName, level);

            NodeTransaction transactionProcessor = NodeTransactionFactory.getProcessorFor(jsonNode.isArray(),
                    jsonNode.isObject());
            element = transactionProcessor.process(jsonNode, document, element, xmlJsonDataFormat.isTypeHints(), level,
                    xmlnsMap);

            return element;

        } catch (Exception e) {
            return null;
        }
    }

    // create new element
    private static Element createElement(JsonNode jsonNode, Document document, String elementName, int level) {
        Element element;
        if(level ==0) {
            element = document.createElement(JsonUtils.getRootTagName(jsonNode.getNodeType(),
                    xmlJsonDataFormat.getRootNameTag(), xmlJsonDataFormat.getArrayNameTag()));
        } else {
            element = document.createElement(elementName !=null ? elementName : xmlJsonDataFormat.getElementNameTag());
        }
        return element;
    }

}
