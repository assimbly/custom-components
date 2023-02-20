package world.dovetail.edifactdotweb;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import world.dovetail.edifactcommon.io.Input;
import world.dovetail.edifactcommon.io.Output;
import world.dovetail.edifactcommon.io.StreamInput;
import world.dovetail.edifactcommon.io.StreamOutput;
import world.dovetail.edifactdotweb.transformer.VRZUIM_1941Transformer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;


public class EdifactDotwebProcessor implements Processor {

    private EdifactDotwebEndpoint endpoint;

    public EdifactDotwebProcessor(EdifactDotwebEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        EdifactDotwebConfiguration config = endpoint.getConfiguration();

        InputStream is = exchange.getIn().getBody(InputStream.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Input input = new StreamInput(is);
        Output output = new StreamOutput(out);

        switch(config.getType()){
            case VRZUIM_1941:
                VRZUIM_1941Transformer defaultTransformer = new VRZUIM_1941Transformer();
                defaultTransformer.run(input, output);
                break;
            default:
                throw new RuntimeException("Supplied EDIFACT Type is not supported.");

        }

        exchange.getIn().setBody(out);
    }

}
