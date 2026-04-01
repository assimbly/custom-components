package org.assimbly.edi;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.milyn.Smooks;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class EdiDataFormat implements DataFormat {

    private String segment;
    private String field;
    private String component;
    private String subComponent;

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        Smooks smooks = new Smooks();

        EdiReaderConfigurator config = new EdiReaderConfigurator(segment, field, component, subComponent);
        smooks.setReaderConfig(config);

        byte[] bytes = exchange.getContext().getTypeConverter().mandatoryConvertTo(byte[].class, graph);
        ByteArrayInputStream edi = new ByteArrayInputStream(bytes);

        smooks.filterSource(new StreamSource(edi), new StreamResult(stream));
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) {
        return new XmlToEdiConverter().convert(stream);
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void setSubComponent(String subComponent) {
        this.subComponent = subComponent;
    }

    @Override
    public void start() {
        // No startup logic required for this data format
    }

    @Override
    public void stop() {
        // No shutdown logic required for this data format
    }
}
