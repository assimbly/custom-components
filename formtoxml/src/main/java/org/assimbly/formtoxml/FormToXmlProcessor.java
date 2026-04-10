package org.assimbly.formtoxml;

import com.thoughtworks.xstream.XStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.assimbly.formtoxml.converter.XstreamMapEntryConverter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;


public class FormToXmlProcessor implements Processor {

    private final FormToXmlEndpoint endpoint;

    public static final String APPLICATION_XML_VALUE = "application/xml";

    public FormToXmlProcessor(FormToXmlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        FormToXmlConfiguration configuration = endpoint.getConfiguration();

        String input = exchange.getIn().getBody(String.class);
        String result = java.net.URLDecoder.decode(input, configuration.getEncoding());
        String[] pairs = result.split("&");

        Map<String, String> items = new LinkedHashMap<>();

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if(keyValue.length > 0) {
                items.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : "");
            }
        }

        XStream xStream = new XStream();
        xStream.alias("items", java.util.LinkedHashMap.class);
        xStream.registerConverter(new XstreamMapEntryConverter());

        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, configuration.getEncoding())) {

            String xmlProlog = "<?xml version=\"1.0\" encoding=\"%s\"?>\n".formatted(configuration.getEncoding());
            writer.write(xmlProlog);
            xStream.toXML(items, writer);

            String xml = outputStream.toString(configuration.getEncoding());

            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, APPLICATION_XML_VALUE);
            exchange.getIn().setBody(xml);
        }
    }
}