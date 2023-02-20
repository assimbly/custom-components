package org.assimbly.edi;

import org.milyn.GenericReaderConfigurator;
import org.milyn.ReaderConfigurator;
import org.milyn.cdr.SmooksResourceConfiguration;

import java.util.List;

/**
 * Simple configurator that delegates to the generic configurator
 * and sets the delimiters required by the EdiReader
 *
 * @see EdiReader , GenericReaderConfigurator
 */
public class EdiReaderConfigurator implements ReaderConfigurator {

    private final String segment;
    private final String field;
    private final String component;
    private final String subComponent;

    public EdiReaderConfigurator(String segment, String field, String component, String subComponent) {
        this.segment = segment;
        this.field = field;
        this.component = component;
        this.subComponent = subComponent;
    }

    @Override
    public List<SmooksResourceConfiguration> toConfig() {
        GenericReaderConfigurator configurator = new GenericReaderConfigurator(EdiReader.class);

        configurator.getParameters().setProperty("segment", segment);
        configurator.getParameters().setProperty("field", field);
        configurator.getParameters().setProperty("component", component);
        configurator.getParameters().setProperty("subComponent", subComponent);

        return configurator.toConfig();
    }
}
