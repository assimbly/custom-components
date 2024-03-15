package org.assimbly.jsontoxmllegacy.utils;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

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

        if(!isRootNameSpecified && !isArrayNameSpecified) {
            return null;
        }

        if(isRootNameSpecified) {
            return rootName;
        }

        if(nodeType == JsonNodeType.OBJECT) {
            return "o"; //return "o" if type is an object
        }

        return arrayName;
    }

}
