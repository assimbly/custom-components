package world.dovetail.edifact;

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
import java.util.HashMap;
import java.util.Map;

public class EdifactDataFormat implements DataFormat {

    private EdifactType edifactType;
    private static final Map<EdifactType, Smooks> smooksMarshalCache = new HashMap<>();
    private static final Map<EdifactType, Smooks> smooksUnmarshalCache = new HashMap<>();

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        Smooks smooks = getMarshalSmooks(edifactType);

        byte[] bytes = exchange.getContext().getTypeConverter().mandatoryConvertTo(byte[].class, graph);
        ByteArrayInputStream edifact = new ByteArrayInputStream(bytes);

        // stream source must be backed by a byte stream
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
        DovetailEdifactEnricher.enrich(ediOutBuilder);

        return ediOutBuilder.toString();
    }

    /**
     * Smooks instances are cached per edifact type. Smooks instances can only be configured once, so we'll need
     * a separate instance per edifactType.
     * <p/>
     * These instances are cached because it's _very_ expensive to create Smooks instances (order of ~5 seconds).
     */
    private Smooks getMarshalSmooks(EdifactType edifactType) {
        Smooks smooks = smooksMarshalCache.get(edifactType);
        if (smooks == null) {
            smooks = new Smooks();

            ReaderConfigurator configurator = new UNEdifactReaderConfigurator(edifactType.urn());
            smooks.setReaderConfig(configurator);

            smooksMarshalCache.put(edifactType, smooks);
        }

        return smooks;
    }

    private Smooks getUnmarshalSmooks(EdifactType edifactType) throws IOException, SAXException {
        Smooks smooks = smooksUnmarshalCache.get(edifactType);
        if (smooks == null) {
            smooks = new Smooks();
            smooks.addConfigurations(edifactType.bindingConfigUri());

            smooksUnmarshalCache.put(edifactType, smooks);
        }

        return smooks;
    }

    public void setEdifactType(String edifactType) {
        this.edifactType = EdifactType.byName(edifactType);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
