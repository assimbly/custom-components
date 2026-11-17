package org.assimbly.xmltojsonlegacy.utils;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import javax.xml.XMLConstants;

public class JsonUtils {

    private JsonUtils() {}

    // checks if jsonNode have only one level and have declared namespaces
    public static boolean isJsonNodeInOneLevelAndWithNamespace(JsonNode jsonNode) {
        boolean isNamespacePresent = false;
        int numDataContent = 0;
        if (jsonNode.isObject()) {
            for (String fieldName : jsonNode.propertyNames()) {
                if (!fieldName.startsWith(Constants.JSON_XML_ATTR_PREFIX)) {
                    numDataContent++;
                }
                JsonNode fieldNode = jsonNode.get(fieldName);
                if (fieldNode.isObject() || fieldNode.isArray()) {
                    return false;
                }
                if (fieldName.startsWith(Constants.JSON_XML_ATTR_PREFIX + XMLConstants.XMLNS_ATTRIBUTE)) {
                    isNamespacePresent = true;
                }
            }
        }
        return numDataContent == 1 && isNamespacePresent;
    }

    // get JsonNode from value
    // returns null if json object is not valid
    public static JsonNode getValidJson(String value) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(value);
            if (jsonNode.isObject() || jsonNode.isArray()) {
                return jsonNode;
            } else {
                return null; // Not a valid JSON object or array
            }
        } catch (Exception _) {
            return null;
        }
    }

}
