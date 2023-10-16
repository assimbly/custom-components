package org.assimbly.oriflame;

import org.assimbly.oriflame.details.EdiDetails;
import org.milyn.GenericReaderConfigurator;
import org.milyn.ReaderConfigurator;
import org.milyn.cdr.Parameter;
import org.milyn.cdr.SmooksResourceConfiguration;

import java.util.List;
import java.util.Map;

public class OriflameConfigurator implements ReaderConfigurator {

    public static final String PARAM_LINE_READERS = "LINE_READERS";
    public static final String PARAM_EDI_TYPE = "EDI_TYPE";

    private final List<OriflameLineReader> lineReaders;
    private final EdiDetails type;

    public OriflameConfigurator(List<OriflameLineReader> lineReaders, EdiDetails type) {
        this.lineReaders = lineReaders;
        this.type = type;
    }

    @Override
    public List<SmooksResourceConfiguration> toConfig() {
        List<SmooksResourceConfiguration> configurations = new GenericReaderConfigurator(OriflameReader.class).toConfig();

        // using line readers means we have to skip the @ConfigParam annotation
        // as that only supports string parameters
        Parameter lineReadersParam = new Parameter(PARAM_LINE_READERS, lineReaders);
        Parameter ediTypeParam = new Parameter(PARAM_EDI_TYPE, type);

        // re-use smooks default configuration, hence the magic 0
        Map<String, Object> defaultParams = configurations.get(0).getParameters();

        // drop our custom param together with the default params
        defaultParams.put(PARAM_LINE_READERS, lineReadersParam);
        defaultParams.put(PARAM_EDI_TYPE, ediTypeParam);

        return configurations;
    }
}
