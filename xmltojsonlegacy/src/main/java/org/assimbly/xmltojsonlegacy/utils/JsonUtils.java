package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.xmltojsonlegacy.Constants;

import javax.xml.XMLConstants;
import java.util.HashMap;
import java.util.Iterator;

public class JsonUtils {

    // get and set namespace from/to HashMap xmlnsMap
    public static String getAndSetNamespace(HashMap<String, String> xmlnsMap, String key, String value) {
        if(xmlnsMap.containsKey(key)) {
            return null;
        }
        xmlnsMap.put(key, value);
        return value;
    }

    // get root tag name
    public static String getRootTagName(JsonNodeType nodeType, String rootName, String arrayName) {
        boolean isRootNameSpecified = !StringUtils.isEmpty(rootName);
        boolean isArrayNameSpecified = !StringUtils.isEmpty(arrayName);

        if(isRootNameSpecified || isArrayNameSpecified) {
            if(isRootNameSpecified) {
                return rootName;
            } else {
                if(nodeType == JsonNodeType.OBJECT) return "o"; //return "o" if type is an object
                return arrayName;
            }
        }
        return null;
    }

    // checks if jsonNode have only one level and have declared namespaces
    public static boolean isJsonNodeInOneLevelAndWithNamespace(JsonNode jsonNode) {
        boolean isNamespacePresent = false;
        if (jsonNode.isObject()) {
            Iterator<String> fieldNames = jsonNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode fieldNode = jsonNode.get(fieldName);
                if (fieldNode.isObject() || fieldNode.isArray()) {
                    return false;
                }
                if(fieldName.startsWith(Constants.JSON_XML_ATTR_PREFIX + XMLConstants.XMLNS_ATTRIBUTE)){
                    isNamespacePresent = true;
                }
            }
        }
        return isNamespacePresent;
    }

}
