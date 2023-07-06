package org.assimbly.xmltojsonlegacy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.apache.log4j.Logger;
import org.assimbly.xmltojsonlegacy.processor.XmlToJsonProcessor;
import org.springframework.http.MediaType;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

public class CustomXmlJsonDataFormat implements DataFormat {

    static final Logger logger = Logger.getLogger(CustomXmlJsonDataFormat.class);

    // XML to JSON options
    private static boolean forceTopLevelObject, skipWhitespace, trimSpaces, skipNamespaces, removeNamespacePrefixes,
            typeHints;

    // XML to JSON
    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        String xml = exchange.getIn().getBody(String.class);
        Document document = convertStringToXMLDocument(xml);
        ObjectMapper objectMapper = new ObjectMapper();

        XmlToJsonProcessor xmlToJsonJsonProcessor = new XmlToJsonProcessor(this);
        JsonNode jsonNodeResp = xmlToJsonJsonProcessor.convertXmlToJson(
                document.getDocumentElement(), 0, null, 0, true
        );

        setContentTypeHeader(exchange, MediaType.APPLICATION_JSON_VALUE);
        stream.write(objectMapper.writeValueAsString(jsonNodeResp).getBytes());
        stream.flush();
    }

    // JSON to XML
    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
        String xml = "";

        // TODO

        setContentTypeHeader(exchange, MediaType.APPLICATION_XML_VALUE);

        return xml;
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

    public static boolean isForceTopLevelObject() {
        return forceTopLevelObject;
    }

    public void setForceTopLevelObject(boolean forceTopLevelObject) {
        this.forceTopLevelObject = forceTopLevelObject;
    }

    public static boolean isSkipWhitespace() {
        return skipWhitespace;
    }

    public void setSkipWhitespace(boolean skipWhitespace) {
        this.skipWhitespace = skipWhitespace;
    }

    public static boolean isTrimSpaces() {
        return trimSpaces;
    }

    public void setTrimSpaces(boolean trimSpaces) {
        this.trimSpaces = trimSpaces;
    }

    public static boolean isSkipNamespaces() {
        return skipNamespaces;
    }

    public void setSkipNamespaces(boolean skipNamespaces) {
        this.skipNamespaces = skipNamespaces;
    }

    public static boolean isRemoveNamespacePrefixes() {
        return removeNamespacePrefixes;
    }

    public void setRemoveNamespacePrefixes(boolean removeNamespacePrefixes) {
        this.removeNamespacePrefixes = removeNamespacePrefixes;
    }

    public static boolean isTypeHints() {
        return typeHints;
    }

    public void setTypeHints(boolean typeHints) {
        this.typeHints = typeHints;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
