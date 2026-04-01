package org.assimbly.xmltojson.processor;

import org.json.JSONArray;
import org.json.JSONObject;
import org.assimbly.util.exception.JsonTypeException;
import org.assimbly.xmltojson.domain.JsonType;
import org.assimbly.xmltojson.CustomXmlJsonDataFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
    Process the JSON that is generated from the previously processed XML.
    The JSON library we use sets XML attributes an its values in the JSON
    object of the XML node they were attached to.

    We do further processing  of the JSON:
        - Remove the root object from the JSON if remove root option is enabled.
          This takes the input JSON and replaces it with the contents of its root
          object.
        - JSON key-values that were XML attributes get the proper prefix
            - They were
            - The prefix from the XML processing is replaced with "@".
        - JSON object that have keys "type" and "jsonContent" were XML nodes that
          the user wants to change the type of. These objects will be converted to
          a key-value pair in the JSON.
*/
public class XmlToJsonJsonProcessor {
    private final CustomXmlJsonDataFormat xmlJsonDataFormat;
    private final JSONObject json;
    private final String contentKey;
    private final String xmlAttrPrefix;
    private final String xmlTypeNodePrefix;
    private final String jsonXmlAttrPrefix;
    private final Boolean removeRoot;

    public XmlToJsonJsonProcessor(CustomXmlJsonDataFormat xmlJsonDataFormat, JSONObject json) {
        this.xmlJsonDataFormat = xmlJsonDataFormat;
        this.json = json;
        this.contentKey = xmlJsonDataFormat.getContentKey();
        this.xmlAttrPrefix = xmlJsonDataFormat.getXmlAttrPrefix();
        this.xmlTypeNodePrefix = xmlJsonDataFormat.getXmlTypeNodePrefix();
        this.jsonXmlAttrPrefix = xmlJsonDataFormat.getJsonXmlAttrPrefix();
        this.removeRoot = xmlJsonDataFormat.isRemoveRoot();
    }

    public String processJson() {
        processJsonObject(null, null, this.json);

        if (Boolean.FALSE.equals(this.removeRoot))
            return this.json.toString(2);

        Object jsonWithoutRoot = removeRootFromJson();

        if (jsonWithoutRoot == null)
            return "{}";

        return stringifyJsonWithoutRoot(jsonWithoutRoot);
    }

    private Object removeRootFromJson() {
        Iterator<String> jsonIterator = this.json.keys();

        if (!jsonIterator.hasNext())
            return null;

        return this.json.get(jsonIterator.next());
    }

    private String stringifyJsonWithoutRoot(Object jsonWithoutRoot) {
        return switch (jsonWithoutRoot) {
            case JSONObject object -> object.toString(2);
            case JSONArray array -> array.toString(2);
            default -> jsonWithoutRoot.toString();
        };
    }

    private void processJsonObject(Object parentOfCurrentJsonObject, Object keyOrIndexOfParent,
            JSONObject currentJsonObject) {
        Iterator<String> jsonObjectIterator = currentJsonObject.keys();
        ArrayList<String> prefixedXmlAttrJsonKeys = new ArrayList<>();
        ArrayList<String> prefixedXmlTypeNodeJsonKeys = new ArrayList<>();
        HashMap<Object, JSONObject> typedJsonObjects = new HashMap<>();

        while (jsonObjectIterator.hasNext()) {
            String jsonKey = jsonObjectIterator.next();
            JSONObject nextJsonObject = currentJsonObject.optJSONObject(jsonKey);
            JSONArray nextJsonArray = currentJsonObject.optJSONArray(jsonKey);
            storeXmlAttrJsonKey(prefixedXmlAttrJsonKeys, jsonKey);
            storeXmlTypeNodeJsonKey(prefixedXmlTypeNodeJsonKeys, jsonKey);
            checkIfCurrentJsonObjectHasTypes(keyOrIndexOfParent, currentJsonObject, typedJsonObjects);

            if (nextJsonObject != null) {
                processJsonObject(currentJsonObject, jsonKey, nextJsonObject);
            } else if (nextJsonArray != null) {
                processJsonArray(nextJsonArray);
            }
        }

        processStoredJsonKeysThatWereXmlAttrs(prefixedXmlAttrJsonKeys, currentJsonObject);
        processStoredTypedJsonObjects(typedJsonObjects, parentOfCurrentJsonObject);
        processStoredJsonKeysThatWereXmlTypeNodes(prefixedXmlTypeNodeJsonKeys, currentJsonObject);
    }

    private void storeXmlAttrJsonKey(ArrayList<String> prefixedXmlAttrJsonKeys, String jsonKey) {
        boolean keyWasXmlAttribute = jsonKey.startsWith(this.xmlAttrPrefix);

        if (keyWasXmlAttribute)
            prefixedXmlAttrJsonKeys.add(jsonKey);
    }

    private void storeXmlTypeNodeJsonKey(ArrayList<String> prefixedXmlTypeNodeJsonKeys, String jsonKey) {
        boolean keyWasXmlTypeNode = jsonKey.startsWith(this.xmlTypeNodePrefix);

        if (keyWasXmlTypeNode)
            prefixedXmlTypeNodeJsonKeys.add(jsonKey);
    }

    private void checkIfCurrentJsonObjectHasTypes(Object keyOrIndexOfParent, JSONObject currentJsonObject,
            HashMap<Object, JSONObject> typedJsonObjects) {
        if (!xmlJsonDataFormat.getHasTypes())
            return;

        if (currentJsonObject.has("type"))
            typedJsonObjects.put(keyOrIndexOfParent, currentJsonObject);
    }

    private void processStoredTypedJsonObjects(HashMap<Object, JSONObject> typedJsonObjects,
            Object parentOfCurrentJsonObject) {
        typedJsonObjects.forEach((keyOrIndexOfParent, typedJsonObject) -> {
            Object content = "";
            boolean isTypedJsonObjectWithArrayType = "array".equals(typedJsonObject.get("type"));
            boolean isEmptyTypedObject = typedJsonObject.length() == 1;

            if (!isEmptyTypedObject)
                content = getContentOfTypedJsonObject(typedJsonObject);

            if (isTypedJsonObjectWithArrayType && content instanceof JSONArray array)
                processJsonArray(array);

            if (typedJsonObjectHasOtherPrefixedKeys(typedJsonObject) && !(content instanceof JSONArray)) {
                typedJsonObject.remove("type");
                typedJsonObject.put(this.contentKey, content);
            } else {
                replaceTypedJsonObjectWithContentInJson(parentOfCurrentJsonObject, keyOrIndexOfParent,
                        content);
            }
        });
    }

    private boolean typedJsonObjectHasOtherPrefixedKeys(JSONObject typedJsonObject) {
        return typedJsonObject.length() > 2;
    }

    private Object getContentOfTypedJsonObject(JSONObject typedJsonObject) {
        String specifiedType = typedJsonObject.getString("type");
        JsonType type = getTypeFromTypedObject(specifiedType);
        Object content = switch (type) {
        case STRING -> typedJsonObject.optString(this.contentKey);
        case NUMBER -> typedJsonObject.optNumber(this.contentKey);
        case BOOLEAN -> typedJsonObject.optBoolean(this.contentKey);
        case ARRAY -> convertObjectWithArrayTypeToArray(typedJsonObject);
        };

        if (content == null) {
            content = switch (xmlJsonDataFormat.getTypeValueMismatch()) {
                case ORIGINAL -> typedJsonObject.opt(this.contentKey);
                case NULL -> JSONObject.NULL;
                case ERROR -> {
                    Object value = typedJsonObject.opt(this.contentKey);
                    throw new JsonTypeException("There was a mismatch between a specified type and the value. Type is '%s' and the value is '%s'.".formatted(
                            specifiedType, value));
                }
            };
        }

        return content;
    }

    private JsonType getTypeFromTypedObject(String type) {
        try {
            return Enum.valueOf(JsonType.class, type.toUpperCase());
        } catch (Exception _) {
            return JsonType.STRING;
        }
    }

    private JSONArray convertObjectWithArrayTypeToArray(JSONObject typedJsonObject) {
        JSONArray jsonKeyNamesOfTypedObject = typedJsonObject.names();
        int indexOfTypeKey = findIndexOfTypeInJsonArray(jsonKeyNamesOfTypedObject);
        jsonKeyNamesOfTypedObject.remove(indexOfTypeKey);
        return typedJsonObject.toJSONArray(jsonKeyNamesOfTypedObject);
    }

    private int findIndexOfTypeInJsonArray(JSONArray jsonKeyNamesOfTypedObject) {
        int index = 0;

        for (int i = 0; i < jsonKeyNamesOfTypedObject.length(); i++) {
            String jsonKey = jsonKeyNamesOfTypedObject.optString(i);
            if ("type".equals(jsonKey)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private void replaceTypedJsonObjectWithContentInJson(Object parent, Object keyOrIndexOfParent, Object content) {
        if (parent instanceof JSONObject object) {
            object.put((String) keyOrIndexOfParent, content);
        } else {
            ((JSONArray) parent).put((int) keyOrIndexOfParent, content);
        }
    }

    private void processJsonArray(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            JSONArray nextJsonArray = jsonArray.optJSONArray(i);

            if (jsonObject != null) {
                processJsonObject(jsonArray, i, jsonObject);
            } else if (nextJsonArray != null) {
                processJsonArray(nextJsonArray);
            }
        }
    }

    private void processStoredJsonKeysThatWereXmlAttrs(ArrayList<String> prefixedXmlAttrJsonKeys,
            JSONObject currentJsonObject) {

        for (String key : prefixedXmlAttrJsonKeys) {
            String unprefixedKey = key.replace(this.xmlAttrPrefix, this.jsonXmlAttrPrefix);
            Object keyContents = currentJsonObject.remove(key);
            currentJsonObject.put(unprefixedKey, keyContents);
        }
    }

    private void processStoredJsonKeysThatWereXmlTypeNodes(ArrayList<String> prefixedXmlTypeNodeJsonKeys,
            JSONObject currentJsonObject) {
        for (String key : prefixedXmlTypeNodeJsonKeys) {
            String unprefixedKey = key.replace(this.xmlTypeNodePrefix, "");
            Object keyContents = currentJsonObject.remove(key);
            currentJsonObject.put(unprefixedKey, keyContents);
        }
    }
}
