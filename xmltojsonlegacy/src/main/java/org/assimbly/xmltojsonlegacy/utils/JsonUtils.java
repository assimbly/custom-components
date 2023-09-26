package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class JsonUtils {

    public static String getAndSetNamespace(HashMap<String, String> xmlnsMap, String key, String value) {
        if(xmlnsMap.containsKey(key))
            return xmlnsMap.get(key);
        xmlnsMap.put(key, value);
        return value;
    }

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

}
