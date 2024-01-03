package org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OtherType implements TextNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, String grandParentClass, String parentClass, boolean isRootArray, boolean isRootNode,
            boolean isObject, boolean isOneValue, String namespace, boolean forceTopLevelObject, boolean trimSpaces,
            boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints, boolean areSiblingsNamesEqual
    ) {
        //process text node identified as other
        Print.data(" 2. OTHER", level);
        if(typeHints){
            if(!areSiblingsNamesEqual ||
                    ((grandParentClass==null || !grandParentClass.equals(Constants.JSON_XML_ATTR_TYPE_ARRAY)) &&
                            (parentClass==null || !parentClass.equals(Constants.JSON_XML_ATTR_TYPE_ARRAY)))
            ) {
                String value = ElementUtils.getNodeValue(childNode, trimSpaces);
                if(StringUtils.isNotBlank(value)) {
                    ExtractUtils.setValueUsingAttributeType(rootObjectNode, null,
                            ElementUtils.getElementName(element, namespace, removeNamespacePrefixes, skipNamespaces),
                            value,
                            ExtractUtils.getAttributeTypeFromElement(element), trimSpaces);
                }
            }
        } else {
            if(ElementChecker.isLastElement(element)) {
                String name = ElementUtils.getElementName(element, namespace, removeNamespacePrefixes, skipNamespaces);
                if(!ElementChecker.isElementAttributeNull(element, Constants.JSON_XML_ATTR_TYPE)) {
                    name = Constants.JSON_XML_TEXT_FIELD;
                }
                rootObjectNode.put(name, ElementUtils.getNodeValue(childNode, trimSpaces));
            }
        }
        return null;
    }
}
