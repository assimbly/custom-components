package org.assimbly.formtoxml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class XstreamMapEntryConverter implements Converter {

    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class clazz) {
        return AbstractMap.class.isAssignableFrom(clazz);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {

        AbstractMap<String, String> map = (AbstractMap<String, String>) value;
        for (Map.Entry<String, String> entry : map.entrySet()) {

            String key = entry.getKey().replaceAll("[^A-z0-9_.\\-]|^(xml|[\\-0-9\\.])+", "");

            if(key.length()==0) {
                continue;
            }

            writer.startNode(key);
            writer.setValue(entry.getValue());
            writer.endNode();
        }
    }

    @SuppressWarnings("unchecked")
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Map<String, String> map = new HashMap<>();

        while(reader.hasMoreChildren()) {
            reader.moveDown();

            String key = reader.getNodeName();
            String value = reader.getValue();
            map.put(key, value);

            reader.moveUp();
        }

        return map;
    }
}
