package org.assimbly.xmltojson;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.json.JSONObject;
import org.json.XML;
import org.json.XMLParserConfiguration;
import org.assimbly.util.exception.XmlRootException;
import org.assimbly.util.helper.ExchangeHelper;
import org.assimbly.xmltojson.domain.TypeValueMismatch;
import org.assimbly.xmltojson.processor.JsonToXmlJsonProcessor;
import org.assimbly.xmltojson.processor.JsonToXmlXmlProcessor;
import org.assimbly.xmltojson.processor.XmlToJsonJsonProcessor;
import org.assimbly.xmltojson.processor.XmlToJsonXmlProcessor;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class CustomXmlJsonDataFormat implements DataFormat {
    private static final String DEFAULT_ARRAY_ELEMENT_NAME = "element";
    private static final String DEFAULT_ROOT_TAG = "root";

    // XML to JSON options
    private boolean hasTypes, keepStrings, removeNamespaces, removeRoot;
    private TypeValueMismatch typeValueMismatch;
    private final String contentKey = "jsonContent";

    private final String xmlAttrPrefix = "ASSIMBLY_ATTR_PREFIX";
    private final String jsonXmlAttrPrefix = "@";

    private final String xmlTypeNodePrefix = "ASSIMBLY_TYPE_PREFIX";

    // JSON to XML options
    private boolean addRoot, checkJsonKeys, changeArrayElements;
    private String rootTag, arrayElementName;
    private final String validXmlRegex = "[^A-z0-9_.\\-]|^(xml|[\\-0-9\\.])+";

    // XML to JSON
    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        XmlToJsonXmlProcessor xmlToJsonXmlProcessor = new XmlToJsonXmlProcessor(exchange, this, graph);
        XMLParserConfiguration xmlParserConfig = new XMLParserConfiguration()
                .withKeepStrings(keepStrings)
                .withcDataTagName(contentKey);
        JSONObject xmlJSONObj;

        xmlToJsonXmlProcessor.processXml();

        ByteArrayOutputStream xmlOutputStream = xmlToJsonXmlProcessor.getOutputStreamFromXmlDoc();
        xmlJSONObj = XML.toJSONObject(IOUtils.toString(xmlOutputStream.toByteArray(), "UTF-8"), xmlParserConfig);

        XmlToJsonJsonProcessor xmlToJsonJsonProcessor = new XmlToJsonJsonProcessor(this, xmlJSONObj);
        String processedJsonString = xmlToJsonJsonProcessor.processJson();

        setContentTypeHeader(exchange, "application/json");
        stream.write(processedJsonString.getBytes());
        stream.flush();
    }

    // JSON to XML
    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
        Object json;
        String xml;

        JsonToXmlJsonProcessor jsonToXmlJsonProcessor = new JsonToXmlJsonProcessor(exchange, this, stream);
        json = jsonToXmlJsonProcessor.processJson();

        JsonToXmlXmlProcessor jsonToXmlXmlProcessor = new JsonToXmlXmlProcessor(exchange, this, json);
        xml = jsonToXmlXmlProcessor.getXmlFromJson();

        setContentTypeHeader(exchange, "application/xml");

        return xml;
    }

    private void setContentTypeHeader(Exchange exchange, String contentType) {
        if (exchange.hasOut()) {
            exchange.getOut().setHeader(Exchange.CONTENT_TYPE, contentType);
        } else {
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, contentType);
        }
    }

    public String getRootTag(Exchange exchange) {
        if (this.rootTag == null)
            return DEFAULT_ROOT_TAG;

        if (!ExchangeHelper.hasVariables(this.rootTag))
            return this.rootTag;

        String interpolatedRootTag = ExchangeHelper.interpolate(rootTag, exchange);

        if (interpolatedRootTag == null || "".equals(interpolatedRootTag.trim()))
            throw new XmlRootException("The header in the root tag has an empty value. A XML root tag can't be empty.");

        if (hasInvalidXMLCharacters(interpolatedRootTag))
            throw new XmlRootException("The value of the header in the root tag has invalid XML characters. It can't be used as an XML root tag.");

        return interpolatedRootTag;
    }

    private Boolean hasInvalidXMLCharacters(String value) {
        return Pattern.compile(validXmlRegex).matcher(value).find();
    }

    public String getArrayElementName(Exchange exchange) {
        if (this.arrayElementName == null)
            return DEFAULT_ARRAY_ELEMENT_NAME;

        if (!ExchangeHelper.hasVariables(arrayElementName))
            return this.arrayElementName;

        String interpolatedArrayElementName = ExchangeHelper.interpolate(this.arrayElementName, exchange);

        if (interpolatedArrayElementName == null || "".equals(interpolatedArrayElementName.trim()))
            throw new XmlRootException("The header in the array element name has an empty value. A XML tag can't be empty.");

        if (hasInvalidXMLCharacters(interpolatedArrayElementName))
            throw new XmlRootException("The value of the header in the array element name has invalid XML characters. It can't be used as an XML tag.");

        return interpolatedArrayElementName;
    }

    public void setHasTypes(boolean hasTypes) {
        this.hasTypes = hasTypes;
    }

    public void setKeepStrings(boolean keepStrings) {
        this.keepStrings = keepStrings;
    }

    public void setAddRoot(boolean addRoot) {
        this.addRoot = addRoot;
    }

    public void setCheckJsonKeys(boolean checkJsonKeys) {
        this.checkJsonKeys = checkJsonKeys;
    }

    public void setTypeValueMismatch(String typeValueMismatch) {
        this.typeValueMismatch = TypeValueMismatch.fromString(typeValueMismatch);
    }

    public void setRemoveNamespaces(boolean removeNamespaces) {
        this.removeNamespaces = removeNamespaces;
    }

    public void setRootTag(String rootTag) {
        this.rootTag = rootTag;
    }

    public void setChangeArrayElements(boolean changeArrayElements) {
        this.changeArrayElements = changeArrayElements;
    }

    public void setArrayElementName(String arrayElementName) {
        this.arrayElementName = arrayElementName;
    }

    public boolean getHasTypes() {
        return this.hasTypes;
    }

    public boolean getKeepStrings() {
        return this.keepStrings;
    }

    public boolean getCheckJsonKeys() {
        return this.checkJsonKeys;
    }

    public boolean getChangeArrayElements() {
        return this.changeArrayElements;
    }

    public boolean getRemoveNamespaces() {
        return this.removeNamespaces;
    }

    public String getXmlAttrPrefix() {
        return this.xmlAttrPrefix;
    }

    public String getJsonXmlAttrPrefix() {
        return this.jsonXmlAttrPrefix;
    }

    public String getContentKey() {
        return this.contentKey;
    }

    public TypeValueMismatch getTypeValueMismatch() {
        return this.typeValueMismatch;
    }

    public boolean getAddRoot() {
        return this.addRoot;
    }

    public String getDefaultArrayElementName() {
        return DEFAULT_ARRAY_ELEMENT_NAME;
    }

    public String getDefaultRootTag() {
        return DEFAULT_ROOT_TAG;
    }

    public String getXmlTypeNodePrefix() {
        return xmlTypeNodePrefix;
    }

    public boolean isRemoveRoot() {
        return removeRoot;
    }

    public void setRemoveRoot(boolean removeRoot) {
        this.removeRoot = removeRoot;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
