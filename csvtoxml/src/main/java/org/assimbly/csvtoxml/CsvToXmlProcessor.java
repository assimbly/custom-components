package org.assimbly.csvtoxml;

import com.thoughtworks.xstream.XStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.assimbly.csvtoxml.converter.XstreamMapEntryConverter;
import org.assimbly.csvtoxml.domain.AnonymousObject;
import org.assimbly.csvtoxml.domain.Items;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CsvToXmlProcessor implements Processor {

    public static final String APPLICATION_XML_VALUE = "application/xml";

    public static final String HEADER_RECORD_HEADER = "CamelCsvHeaderRecord";

    private final CsvToXmlEndpoint endpoint;

    public CsvToXmlProcessor(CsvToXmlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {

        List<?> input = exchange.getIn().getBody(List.class);
        CsvToXmlConfiguration configuration = endpoint.getConfiguration();

        Items items;

        if (input == null || input.isEmpty()) {
            items = createEmptyOrHeaderOnlyItems(exchange, configuration);
        } else if (input.getFirst().getClass() == ArrayList.class) {
            List<ArrayList<String>> csv = (List<ArrayList<String>>) input;
            items = createAnonymousItems(csv);
        } else {
            List<HashMap<String, Object>> csv = (List<HashMap<String, Object>>) input;
            items = createItems(csv);
        }

        XStream xStream = new XStream();
        xStream.processAnnotations(Items.class);
        xStream.registerConverter(new XstreamMapEntryConverter());
        xStream.aliasSystemAttribute(null, "class");

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             Writer writer = new OutputStreamWriter(outputStream, configuration.getEncoding())) {

            String xmlProlog = "<?xml version=\"1.0\" encoding=\"%s\"?>\n".formatted(configuration.getEncoding());
            writer.write(xmlProlog);

            xStream.toXML(items, writer);

            String xml = outputStream.toString(configuration.getEncoding());

            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, APPLICATION_XML_VALUE);
            exchange.getIn().setBody(xml);
        }
    }

    @SuppressWarnings("unchecked")
    private Items createEmptyOrHeaderOnlyItems(Exchange exchange, CsvToXmlConfiguration configuration) {
        if (configuration.isUseHeaders()) {
            List<String> headers = exchange.getIn().getHeader(HEADER_RECORD_HEADER, List.class);

            if (headers != null && !headers.isEmpty()) {
                // LinkedHashMap to preserve header column order in the output
                HashMap<String, Object> emptyRow = new LinkedHashMap<>();
                headers.forEach(header -> emptyRow.put(header, ""));

                List<HashMap<String, Object>> csv = new ArrayList<>();
                csv.add(emptyRow);

                return createItems(csv);
            }
        }

        return new Items();
    }

    private Items createAnonymousItems(List<ArrayList<String>> list){
        Items items = new Items();
        list.forEach(array -> {
            AnonymousObject object = new AnonymousObject();
            object.setStrings(array);
            items.addAObject(object);
        });

        return items;
    }

    private Items createItems(List<HashMap<String, Object>> list){
        Items items = new Items();
        items.setObjects(list);

        return items;
    }

}