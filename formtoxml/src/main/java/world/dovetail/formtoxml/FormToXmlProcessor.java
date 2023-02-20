package world.dovetail.formtoxml;

import com.thoughtworks.xstream.XStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import world.dovetail.formtoxml.converter.XstreamMapEntryConverter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FormToXmlProcessor implements Processor {

    private FormToXmlEndpoint endpoint;

    public FormToXmlProcessor(FormToXmlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        FormToXmlConfiguration configuration = endpoint.getConfiguration();

        String input = exchange.getIn().getBody(String.class);
        String result = java.net.URLDecoder.decode(input, configuration.getEncoding());
        String[] pairs = result.split("&");

        Map<String, String> items = new HashMap<>();

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if(keyValue.length > 0) {
                items.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : "");
            }
        }

        XStream xStream = new XStream();
        xStream.alias("items", java.util.Map.class);
        xStream.registerConverter(new XstreamMapEntryConverter());

        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, configuration.getEncoding())) {

            String xmlProlog = String.format("<?xml version=\"1.0\" encoding=\"%s\"?>\n", configuration.getEncoding());
            writer.write(xmlProlog);
            xStream.toXML(items, writer);

            String xml = outputStream.toString(configuration.getEncoding());
            exchange.getIn().setBody(xml);
        }
    }
}
