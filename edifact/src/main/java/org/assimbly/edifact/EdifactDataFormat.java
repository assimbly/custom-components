package org.assimbly.edifact;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.milyn.ReaderConfigurator;
import org.milyn.Smooks;
import org.milyn.payload.JavaResult;
import org.milyn.smooks.edi.unedifact.UNEdifactReaderConfigurator;
import org.milyn.smooks.edi.unedifact.model.UNEdifactInterchangeFactory;
import org.milyn.smooks.edi.unedifact.model.r41.UNEdifactInterchange41;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.EnumMap;
import java.util.Map;

public class EdifactDataFormat implements DataFormat {

    private EdifactType edifactType;
    private static final Map<EdifactType, Smooks> smooksMarshalCache = new EnumMap<>(EdifactType.class);
    private static final Map<EdifactType, Smooks> smooksUnmarshalCache = new EnumMap<>(EdifactType.class);

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        Smooks smooks = getMarshalSmooks(edifactType);

        byte[] bytes = exchange.getContext().getTypeConverter().mandatoryConvertTo(byte[].class, graph);
        ByteArrayInputStream edifact = new ByteArrayInputStream(bytes);

        smooks.filterSource(new StreamSource(edifact), new StreamResult(stream));
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
        Smooks smooks = getUnmarshalSmooks(edifactType);

        JavaResult javaResult = new JavaResult();
        smooks.filterSource(new StreamSource(stream), javaResult);

        UNEdifactInterchange41 interchange = javaResult.getBean(UNEdifactInterchange41.class);
        UNEdifactInterchangeFactory factory = edifactType.interchangeFactory();

        StringWriter ediOutStream = new StringWriter();
        factory.toUNEdifact(interchange, ediOutStream);

        StringBuilder ediOutBuilder = new StringBuilder(ediOutStream.toString());
        AssimblyEdifactEnricher.enrich(ediOutBuilder);

        return ediOutBuilder.toString();
    }

    /**
     * Smooks instances are cached per edifact type. Smooks instances can only be configured once, so we'll need
     * a separate instance per edifactType.
     * <p/>
     * These instances are cached because it's _very_ expensive to create Smooks instances (order of ~5 seconds).
     */
    private Smooks getMarshalSmooks(EdifactType edifactType) {
        return smooksMarshalCache.computeIfAbsent(edifactType, type -> {
            Smooks smooks = new Smooks();
            ReaderConfigurator configurator = new UNEdifactReaderConfigurator(type.urn());
            smooks.setReaderConfig(configurator);
            return smooks;
        });
    }

    private Smooks getUnmarshalSmooks(EdifactType edifactType) throws SAXException {
        if (!smooksUnmarshalCache.containsKey(edifactType)) {
            smooksUnmarshalCache.computeIfAbsent(edifactType, type -> {
                try {
                    Smooks smooks = new Smooks();
                    smooks.addConfigurations(type.bindingConfigUri());
                    return smooks;
                } catch (IOException | SAXException e) {
                    throw new IllegalStateException("Failed to configure Smooks for EdifactType: " + type, e);
                }
            });
        }
        return smooksUnmarshalCache.get(edifactType);
    }

    public void setEdifactType(String edifactType) {
        this.edifactType = EdifactType.byName(edifactType);
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