package world.dovetail.xmltojson.processor;

import org.apache.camel.Exchange;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import org.assimbly.util.helper.XmlHelper;
import world.dovetail.xmltojson.CustomXmlJsonDataFormat;

/*
    Some more procesing before and more processing after converting to XML
        - Add a root object around the JSON if needed
            - JSON with array as root: array will be wrapped in object before so
              resulting XML is always correct
        - Parse XML and pretty print it
            - Can throw exception when JSON keys were not checked
                - When the user doesn't expect the JSON keys to have strange characters
                  and wants to be warned when they do have it.
*/
public class JsonToXmlXmlProcessor {
    private final Exchange exchange;
    private final CustomXmlJsonDataFormat xmlJsonDataFormat;
    private final boolean addRoot, checkJsonKeys, changeArrayElements;
    private final String rootTag, arrayElementName, defaultArrayElementName;
    private final Object json;

    public JsonToXmlXmlProcessor(Exchange exchange, CustomXmlJsonDataFormat xmlJsonDataFormat,
        Object json) {
            this.exchange = exchange;
            this.xmlJsonDataFormat = xmlJsonDataFormat;
            this.addRoot = this.xmlJsonDataFormat.getAddRoot();
            this.checkJsonKeys = this.xmlJsonDataFormat.getCheckJsonKeys();
            this.changeArrayElements = this.xmlJsonDataFormat.getChangeArrayElements();
            this.rootTag = this.xmlJsonDataFormat.getRootTag(this.exchange);
            this.arrayElementName = this.xmlJsonDataFormat.getArrayElementName(this.exchange);
            this.defaultArrayElementName = this.xmlJsonDataFormat.getDefaultArrayElementName();
            this.json = json;
    }

    public String getXmlFromJson() throws Exception {
        String xml;

        if (this.addRoot) {
            xml = getXmlWithRootFromJson();
        } else {
            xml = XML.toString(json);
        }

        if (this.checkJsonKeys) {
            return XmlHelper.prettyPrint(xml);
        } else {
            return XmlHelper.prettyPrintWithPossibleException(xml);
        }
    }

    private String getXmlWithRootFromJson() {
        if (json instanceof JSONObject) {
            return XML.toString(json, this.rootTag);
        } else {
            JSONObject wrappedJsonObject = wrapJsonArray(json);
            return XML.toString(wrappedJsonObject, this.rootTag);
        }
    }

    private JSONObject wrapJsonArray(Object json) {
        JSONArray jsonArray = (JSONArray) json;
        JSONObject arrayObject = new JSONObject();
        String wrapperKey = this.defaultArrayElementName;

        if (this.changeArrayElements)
            wrapperKey = arrayElementName;

        arrayObject.put(wrapperKey, jsonArray);
        return arrayObject;
    }
}
