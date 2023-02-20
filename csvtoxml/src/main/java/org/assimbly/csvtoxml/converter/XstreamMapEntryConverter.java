package org.assimbly.csvtoxml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class XstreamMapEntryConverter implements Converter {

    @SuppressWarnings("rawtypes") // required via com.thoughtworks.xstream.converters.ConverterMatcher.canConvert()
    public boolean canConvert(Class clazz) {
        return AbstractMap.class.isAssignableFrom(clazz);
    }

    @SuppressWarnings("unchecked")
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        AbstractMap<String, String> map = (AbstractMap<String, String>) value;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String xmlNode = entry.getKey().replaceAll("[^A-z0-9_.\\-]|^(xml|[\\-0-9\\.])+", "");

            System.out.println("----------------------");
            System.out.println("xmlNode=" + xmlNode);
            System.out.println("value=" + entry.getValue());

            writer.startNode(xmlNode);
            writer.setValue(entry.getValue());
            writer.endNode();
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Map<String, String> map = new HashMap<>();

        while (reader.hasMoreChildren()) {
            reader.moveDown();
            map.put(reader.getNodeName(), reader.getValue());
            reader.moveUp();
        }
        return map;
    }
}
