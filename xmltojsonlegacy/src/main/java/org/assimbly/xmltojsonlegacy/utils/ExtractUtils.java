package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.processor.XmlToJsonProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ExtractUtils {

    // extract child as other type and add into the array node
    public static void extractChildAsOtherInArrayNode(
            int level, ArrayNode rootArrayNode, int numSiblings, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace
    ) {
        rootArrayNode.add(XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace));
    }

    // extract child as other type and add into the object node
    public static void extractChildAsOtherInObjectNode(
            int level, ObjectNode rootObjectNode, int numSiblings, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace, boolean skipNamespaces,
            boolean removeNamespacePrefixes
    ) {
        rootObjectNode.set(
                ElementUtils.getElementName(childNode, namespace, removeNamespacePrefixes, skipNamespaces),
                XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace)
        );
    }

    // extract child as array type
    public static void extractChildAsArray(
            int level, ArrayNode rootArrayNode, int numSiblings, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace
    ) {
        JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace);

        if(subNode.isArray() && ElementChecker.isLastElement(childElement)) {
            for (JsonNode subElement : subNode) {
                rootArrayNode.add(subElement.asText());
            }
        } else {
            rootArrayNode.add(subNode);
        }
    }

    // extract child as object type
    public static void extractChildAsObject(
            int level, ObjectNode rootObjectNode, int numSiblings, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints
    ) {
        if(typeHints) {
            JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace);
            for (JsonNode subElement : subNode) {
                subNode.fields().forEachRemaining(entry -> {
                    String label = entry.getKey();
                    String childTypeAttr = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
                    setValueUsingAttributeType(rootObjectNode, subElement, label, childTypeAttr, trimSpaces);
                });
            }
        } else {
            if(classAttr!=null && !classAttr.equals("")) {
                rootObjectNode.set(
                        ElementUtils.getElementName(childElement, namespace, removeNamespacePrefixes, skipNamespaces),
                        addNodeWithAttributeInfo(childElement, ElementUtils.getNodeValue(childElement, trimSpaces))
                );
            } else {
                rootObjectNode.put(ElementUtils.getElementName(childElement, namespace, removeNamespacePrefixes, skipNamespaces),
                        ElementUtils.getNodeValue(childElement, trimSpaces));
            }
        }
    }

    // add node with attribute information
    private static JsonNode addNodeWithAttributeInfo(Element element, String value) {
        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();

        if(element.hasAttributes()){
            NamedNodeMap attrMap = element.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                attrInfoObjectNode.put(Constants.JSON_XML_ATTR_PREFIX+node.getNodeName(), node.getNodeValue());
            }
        }
        attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, value);

        return attrInfoObjectNode;
    }


    // set value as specified in the attribute type
    private static void setValueUsingAttributeType(
            ObjectNode rootObjectNode, JsonNode subElement, String label, String childTypeAttr, boolean trimSpaces
    ) {
        switch (childTypeAttr) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                rootObjectNode.put(label, subElement.asInt());
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                rootObjectNode.put(label, subElement.asBoolean());
                break;
            default:
                if(trimSpaces){
                    rootObjectNode.put(label, subElement.asText().trim());
                } else {
                    rootObjectNode.put(label, subElement.asText());
                }
        }
    }

}
