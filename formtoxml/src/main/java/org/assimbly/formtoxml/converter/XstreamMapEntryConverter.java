package org.assimbly.formtoxml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XstreamMapEntryConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return AbstractMap.class.isAssignableFrom(clazz);
    }

    @SuppressWarnings({"unchecked"})
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {

        AbstractMap<String, String> map = (AbstractMap<String, String>) value;
        for (Map.Entry<String, String> entry : map.entrySet()) {

            String key = entry.getKey().replaceAll("[^A-Za-z0-9_.\\-]|^(xml|[-0-9.])++" , "");

            if(key.isEmpty()) {
                continue;
            }

            writer.startNode(key);
            writer.setValue(entry.getValue());
            writer.endNode();
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Map<String, String> map = new ConcurrentHashMap<>();

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
