package org.assimbly.xmltojson.processor;

import org.apache.camel.Exchange;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.assimbly.xmltojson.CustomXmlJsonDataFormat;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import static org.assimbly.util.helper.XmlHelper.fixInvalidXml;
import static org.assimbly.util.helper.XmlHelper.hasInvalidXml;

/*
    Process the incoming JSON before converting it to XML. The JSON is processed
    using the JSON library.
    What we do with the JSON:
        - All JSON keys are checked for invalid XML characters if the user
          requests this.
        - Rename the keys that have arrays as their value and wrap arrays in a
          JSON object if they are the child of another array.
            - When the user wants to rename array elements in resulting XML
            - The JSON library uses the the keys to name the XML nodes of array
              elements.
*/
public class JsonToXmlJsonProcessor {
    private final Exchange exchange;
    private final CustomXmlJsonDataFormat xmlJsonDataFormat;
    private JSONObject mainJsonObject;
    private JSONArray mainJsonArray;
    private final boolean checkJsonKeys, changeArrayElements;
    private final String arrayElementName;

    public JsonToXmlJsonProcessor(Exchange exchange, CustomXmlJsonDataFormat xmlJsonDataFormat,
        InputStream dataStream) throws IOException {
        this.exchange = exchange;
        this.xmlJsonDataFormat = xmlJsonDataFormat;
        this.checkJsonKeys = this.xmlJsonDataFormat.getCheckJsonKeys();
        this.changeArrayElements = this.xmlJsonDataFormat.getChangeArrayElements();
        this.arrayElementName = this.xmlJsonDataFormat.getArrayElementName(this.exchange);
        parseDataStreamToJson(dataStream);
    }

    private void parseDataStreamToJson(InputStream dataStream) throws IOException {
        String dataString = IOUtils.toString(dataStream, StandardCharsets.UTF_8);

        try {
            tryParseDataStringToJsonObject(dataString);
        } catch (Exception e) {
            tryParseDataStringToJsonArray(dataString);
        }
    }

    private void tryParseDataStringToJsonObject(String dataString) throws JSONException {
        this.mainJsonObject = new JSONObject(dataString);
    }

    private void tryParseDataStringToJsonArray(String dataString) throws JSONException {
        try {
            this.mainJsonArray = new JSONArray(dataString);
        } catch (JSONException noJSONArrayException) {
            throw new JSONException(
                "The provided JSON could not be parsed to either a JSON object or a JSON array."
            );
        }
    }

    public Object processJson() {
        if (!this.checkJsonKeys && !this.changeArrayElements )
            return getProcessedJson();

        if (this.mainJsonObject != null) {
            processJsonObject(this.mainJsonObject);
        } else if (changeArrayElements && this.mainJsonArray != null) {
            this.mainJsonObject = wrapJsonArray(this.mainJsonArray, this.arrayElementName);
            this.mainJsonArray = null;
            processJsonObject(this.mainJsonObject);
        } else if (this.mainJsonArray != null) {
            processJsonArray(this.mainJsonArray);
        }

        return getProcessedJson();
    }

    private void processJsonObject(JSONObject currentJsonObject) {
        Iterator<String> jsonObjectIterator = currentJsonObject.keys();
        ArrayList<String> jsonKeysWithInvalidXmlChars = new ArrayList<>();
        ArrayList<String> jsonKeysWithArrayAsValue = new ArrayList<>();

        while (jsonObjectIterator.hasNext()) {
            String jsonKey = jsonObjectIterator.next();
            JSONObject nextJsonObject = currentJsonObject.optJSONObject(jsonKey);
            JSONArray nextJsonArray = currentJsonObject.optJSONArray(jsonKey);
            storeJsonKeyIfItHasInvalidXmlChars(jsonKeysWithInvalidXmlChars, jsonKey);

            if (nextJsonObject != null) {
                processJsonObject(nextJsonObject);
            } else if (nextJsonArray != null) {
                storeJsonKeyIfArrayElementsAreCustom(jsonKeysWithArrayAsValue, jsonKey);
                processJsonArray(nextJsonArray);
            }
        }

        processStoredJsonKeysForCustomArrayElements(jsonKeysWithArrayAsValue, currentJsonObject);
        processStoredJsonKeysThatHaveInvalidXmlChars(jsonKeysWithInvalidXmlChars, currentJsonObject);
    }

    private void storeJsonKeyIfItHasInvalidXmlChars(ArrayList<String> keysWithInvalidXmlChars,
        String jsonKey) {
        if (!this.checkJsonKeys)
            return;

        if (hasInvalidXml(jsonKey))
            keysWithInvalidXmlChars.add(jsonKey);
    }

    private void storeJsonKeyIfArrayElementsAreCustom(ArrayList<String> jsonKeysWithArrayAsValue,
        String jsonKey) {
        if (this.changeArrayElements)
            jsonKeysWithArrayAsValue.add(jsonKey);
    }

    private JSONObject wrapJsonArray(JSONArray jsonArray, String wrapperKey) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(wrapperKey, jsonArray);
        return jsonObject;
    }

    private void processJsonArray(JSONArray currentJsonArray) {
        for (int i = 0; i < currentJsonArray.length(); i++) {
            JSONObject nextJsonObject = currentJsonArray.optJSONObject(i);
            JSONArray nextJsonArray = currentJsonArray.optJSONArray(i);

            if (nextJsonObject != null) {
                processJsonObject(nextJsonObject);
            } else if (nextJsonArray != null) {
                wrapJsonArrayIfArrayElementsAreCustom(currentJsonArray, i, nextJsonArray);
                processJsonArray(nextJsonArray);
            }
        }
    }

    private void wrapJsonArrayIfArrayElementsAreCustom(JSONArray currentJsonArray, int indexOfCurrentJsonArray, JSONArray nextJsonArray) {
        if (!changeArrayElements)
            return;

        JSONObject wrappedJsonArray = wrapJsonArray(nextJsonArray, this.arrayElementName);
        currentJsonArray.put(indexOfCurrentJsonArray, wrappedJsonArray);
    }

    private void processStoredJsonKeysForCustomArrayElements(ArrayList<String> jsonKeysWithArrayAsValue, JSONObject currentJsonObject) {
        if (jsonKeysWithArrayAsValue.isEmpty())
            return;

        JSONArray arrayForCustomKey = new JSONArray();

        for (String jsonKey : jsonKeysWithArrayAsValue) {
            JSONArray arrayThatNeedsCustomKey = (JSONArray) currentJsonObject.remove(jsonKey);
            arrayForCustomKey.putAll(arrayThatNeedsCustomKey);
        }

        currentJsonObject.put(this.arrayElementName, arrayForCustomKey);
    }

    private void processStoredJsonKeysThatHaveInvalidXmlChars(ArrayList<String> jsonKeysWithInvalidXmlChars,
        JSONObject currentJsonObject) {
        for (String jsonKey : jsonKeysWithInvalidXmlChars) {
            String validatedJsonKey = fixInvalidXml(jsonKey);
            Object keyContents = currentJsonObject.remove(jsonKey);
            currentJsonObject.put(validatedJsonKey, keyContents);
        }
    }

    private Object getProcessedJson() {
        return
            this.mainJsonObject != null ?
                this.mainJsonObject :
                this.mainJsonArray;
    }
}
