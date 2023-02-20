package world.dovetail.flv;

import org.milyn.GenericReaderConfigurator;
import org.milyn.ReaderConfigurator;
import org.milyn.cdr.Parameter;
import org.milyn.cdr.SmooksResourceConfiguration;

import java.util.List;
import java.util.Map;

public class FLVConfigurator implements ReaderConfigurator {

    public static final String PARAM_LINE_READERS = "LINE_READERS";

    private final List<LineReader> lineReaders;

    public FLVConfigurator(List<LineReader> lineReaders) {
        this.lineReaders = lineReaders;
    }

    @Override
    public List<SmooksResourceConfiguration> toConfig() {
        List<SmooksResourceConfiguration> configurations = new GenericReaderConfigurator(FLVReader.class).toConfig();

        // using line readers means we have to skip the @ConfigParam annotation
        // as that only supports string parameters
        Parameter lineReadersParam = new Parameter(PARAM_LINE_READERS, lineReaders);

        // re-use smooks default configuration, hence the magic 0
        Map<String, Object> defaultParams = configurations.get(0).getParameters();

        // drop our custom param together with the default params
        defaultParams.put(PARAM_LINE_READERS, lineReadersParam);

        return configurations;
    }
}
