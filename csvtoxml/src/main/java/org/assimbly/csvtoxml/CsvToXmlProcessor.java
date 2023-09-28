package org.assimbly.csvtoxml;

import com.thoughtworks.xstream.XStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.assimbly.csvtoxml.converter.XstreamMapEntryConverter;
import org.assimbly.csvtoxml.domain.AnonymousObject;
import org.assimbly.csvtoxml.domain.Items;
import org.springframework.http.MediaType;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CsvToXmlProcessor implements Processor {

    private CsvToXmlEndpoint endpoint;

    public CsvToXmlProcessor(CsvToXmlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {

        List<?> input = exchange.getIn().getBody(List.class);
        Items items;

        XStream xStream = new XStream();
        xStream.processAnnotations(Items.class);
        xStream.registerConverter(new XstreamMapEntryConverter());

        CsvToXmlConfiguration configuration = endpoint.getConfiguration();

        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, configuration.getEncoding())) {

            if (input.get(0).getClass() == ArrayList.class){
                List<ArrayList<String>> csv = (List<ArrayList<String>>) input;
                items = createAnonymousItems(csv);
            }else{
                List<HashMap<String, Object>> csv = (List<HashMap<String, Object>>) input;
                items = createItems(csv);
            }

            String xmlProlog = String.format("<?xml version=\"1.0\" encoding=\"%s\"?>\n", configuration.getEncoding());
            writer.write(xmlProlog);

            xStream.aliasSystemAttribute(null, "class");
            xStream.toXML(items, writer);

            String xml = outputStream.toString(configuration.getEncoding());

            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
            exchange.getIn().setBody(xml);
        }

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