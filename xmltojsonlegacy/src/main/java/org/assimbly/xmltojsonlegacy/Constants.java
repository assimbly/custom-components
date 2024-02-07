package org.assimbly.xmltojsonlegacy;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String JSON_XML_ATTR_PREFIX = "@";
    public static final String JSON_XML_TEXT_FIELD = "#text";

    public static final String JSON_XML_ATTR_CLASS = "class";
    public static final String JSON_XML_ATTR_CONTEXT = "context";
    public static final String JSON_XML_ATTR_TYPE = "type";

    public static final String JSON_XML_ATTR_TYPE_NUMBER = "number";
    public static final String JSON_XML_ATTR_TYPE_BOOLEAN = "boolean";
    public static final String JSON_XML_ATTR_TYPE_STRING = "string";
    public static final String JSON_XML_ATTR_TYPE_ARRAY = "array";
    public static final String JSON_XML_ATTR_TYPE_OBJECT = "object";

    public static final List<String> SPECIAL_JSON_XML_ATTR_TYPES = Arrays.asList(
            Constants.JSON_XML_ATTR_CLASS,
            Constants.JSON_XML_ATTR_CONTEXT,
            Constants.JSON_XML_ATTR_TYPE
    );

    public static final String INTERNAL_NULL_OBJECT_NODE_VALUE = "@NULL@";

}
