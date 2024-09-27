package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.Constants;

import javax.xml.XMLConstants;
import java.util.Iterator;

public class JsonUtils {

    // checks if jsonNode have only one level and have declared namespaces
    public static boolean isJsonNodeInOneLevelAndWithNamespace(JsonNode jsonNode) {
        boolean isNamespacePresent = false;
        int numDataContent = 0;
        if (jsonNode.isObject()) {
            Iterator<String> fieldNames = jsonNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if(!fieldName.startsWith(Constants.JSON_XML_ATTR_PREFIX)) {
                    numDataContent++;
                }
                JsonNode fieldNode = jsonNode.get(fieldName);
                if (fieldNode.isObject() || fieldNode.isArray()) {
                    return false;
                }
                if(fieldName.startsWith(Constants.JSON_XML_ATTR_PREFIX + XMLConstants.XMLNS_ATTRIBUTE)){
                    isNamespacePresent = true;
                }
            }
        }
        return (numDataContent == 1 ? isNamespacePresent : false);
    }

}
