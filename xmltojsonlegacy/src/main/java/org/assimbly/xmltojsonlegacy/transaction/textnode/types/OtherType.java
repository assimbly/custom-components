package org.assimbly.xmltojsonlegacy.transaction.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.checker.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Node;

public class OtherType implements TextNodeTransaction {

    @Override
    public JsonNode process(XmlToJsonConfiguration config, Node childNode, int index, int nodeListSize) {
        //process text node identified as other
        Print.data(" 2. OTHER", config.getLevel());
        if(config.isTypeHints()){
            if(!config.isAreSiblingsNamesEqual() ||
                    ((config.getGrandParentClass()==null || !config.getGrandParentClass().equals(Constants.JSON_XML_ATTR_TYPE_ARRAY)) &&
                            (config.getParentClass()==null || !config.getParentClass().equals(Constants.JSON_XML_ATTR_TYPE_ARRAY)))
            ) {
                String value = ElementUtils.getNodeValue(childNode, config.isTrimSpaces());
                if(StringUtils.isNotBlank(value)) {
                    ExtractUtils.setValueUsingAttributeType(config, config.getRootObjectNode(), null,
                            ElementUtils.getElementName(config.getElement(), config.isRemoveNamespacePrefixes()),
                            value,
                            ExtractUtils.getAttributeTypeFromElement(config.getElement()));
                }
            }
        } else {
            if(ElementChecker.isLastElement(config.getElement())) {
                String name = ElementUtils.getElementName(config.getElement(), config.isRemoveNamespacePrefixes());
                if(!ElementChecker.isElementAttributeNull(config.getElement(), Constants.JSON_XML_ATTR_TYPE)) {
                    name = Constants.JSON_XML_TEXT_FIELD;
                }
                if(config.getRootObjectNode().size()>0) {
                    config.getRootObjectNode().put(Constants.JSON_XML_TEXT_FIELD, ElementUtils.getNodeValue(childNode, config.isTrimSpaces()));
                } else {
                    config.getRootObjectNode().put(name, ElementUtils.getNodeValue(childNode, config.isTrimSpaces()));
                }
            }
        }
        return null;
    }
}
