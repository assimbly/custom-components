package org.assimbly.xmltojsonlegacy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.apache.log4j.Logger;
import org.assimbly.xmltojsonlegacy.processor.JsonToXmlProcessor;
import org.assimbly.xmltojsonlegacy.processor.XmlToJsonProcessor;
import org.springframework.http.MediaType;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;

public class CustomXmlJsonDataFormat implements DataFormat {

    static final Logger logger = Logger.getLogger(CustomXmlJsonDataFormat.class);

    // XML to JSON options
    private boolean forceTopLevelObject, skipWhitespace, trimSpaces, skipNamespaces, removeNamespacePrefixes, typeHints;

    // JSON to XML options
    private String elementName, arrayName, rootName;
    private boolean namespaceLenient, typeHintsJson;

    // XML to JSON
    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        String xml = exchange.getIn().getBody(String.class);
        Document document = convertStringToXMLDocument(xml);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeResp = null;

        if(skipWhitespace && trimSpaces && skipNamespaces &&
                (!forceTopLevelObject && (!removeNamespacePrefixes || removeNamespacePrefixes && typeHints) ||
                        forceTopLevelObject && (!removeNamespacePrefixes || removeNamespacePrefixes && !typeHints))
        ) {
            // no transformation available
            jsonNodeResp = objectMapper.createObjectNode().put("noTransformation", "Available");
        } else {
            XmlToJsonProcessor xmlToJsonJsonProcessor = new XmlToJsonProcessor(this);
            jsonNodeResp = xmlToJsonJsonProcessor.convertXmlToJson(
                    document.getDocumentElement(), 0,
                    null, null, 0,
                    true, true,
                    false, false,
                    true, null, new HashMap<String, Namespace>()
            );
        }

        setContentTypeHeader(exchange, MediaType.APPLICATION_JSON_VALUE);
        stream.write(objectMapper.writeValueAsString(jsonNodeResp).getBytes());
        stream.flush();
    }

    // JSON to XML
    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
        String json = exchange.getIn().getBody(String.class);
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(json);

        JsonToXmlProcessor jsonToXmlProcessor = new JsonToXmlProcessor(this);
        Document xmlResp = jsonToXmlProcessor.convertJsonToXml(jsonNode, 0);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(xmlResp);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);

        setContentTypeHeader(exchange, MediaType.APPLICATION_XML_VALUE);
        return writer.toString();
    }

    private static Document convertStringToXMLDocument(String xmlString) {
        DocumentBuilder builder = null;
        Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return doc;
        }
    }

    private void setContentTypeHeader(Exchange exchange, String contentType) {
        if (exchange.hasOut()) {
            exchange.getOut().setHeader(Exchange.CONTENT_TYPE, contentType);
        } else {
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, contentType);
        }
    }


    public boolean isForceTopLevelObject() {
        return forceTopLevelObject;
    }

    public void setForceTopLevelObject(boolean forceTopLevelObject) {
        this.forceTopLevelObject = forceTopLevelObject;
    }

    public boolean isSkipWhitespace() {
        return skipWhitespace;
    }

    public void setSkipWhitespace(boolean skipWhitespace) {
        this.skipWhitespace = skipWhitespace;
    }

    public boolean isTrimSpaces() {
        return trimSpaces;
    }

    public void setTrimSpaces(boolean trimSpaces) {
        this.trimSpaces = trimSpaces;
    }

    public boolean isSkipNamespaces() {
        return skipNamespaces;
    }

    public void setSkipNamespaces(boolean skipNamespaces) {
        this.skipNamespaces = skipNamespaces;
    }

    public boolean isRemoveNamespacePrefixes() {
        return removeNamespacePrefixes;
    }

    public void setRemoveNamespacePrefixes(boolean removeNamespacePrefixes) {
        this.removeNamespacePrefixes = removeNamespacePrefixes;
    }

    public boolean isTypeHints() {
        return typeHints;
    }

    public void setTypeHints(boolean typeHints) {
        this.typeHints = typeHints;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public boolean isNamespaceLenient() {
        return namespaceLenient;
    }

    public void setNamespaceLenient(boolean namespaceLenient) {
        this.namespaceLenient = namespaceLenient;
    }

    public boolean isTypeHintsJson() {
        return typeHintsJson;
    }

    public void setTypeHintsJson(boolean typeHintsJson) {
        this.typeHintsJson = typeHintsJson;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
