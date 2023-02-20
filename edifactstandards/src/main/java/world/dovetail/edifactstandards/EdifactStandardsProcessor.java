package world.dovetail.edifactstandards;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import world.dovetail.edifactcommon.io.Input;
import world.dovetail.edifactcommon.io.Output;
import world.dovetail.edifactcommon.io.StreamInput;
import world.dovetail.edifactcommon.io.StreamOutput;
import world.dovetail.edifactstandards.transformer.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;


public class EdifactStandardsProcessor implements Processor {

    private EdifactStandardsEndpoint endpoint;

    public EdifactStandardsProcessor(EdifactStandardsEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        EdifactStandardsConfiguration config = endpoint.getConfiguration();

        InputStream is = exchange.getIn().getBody(InputStream.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Input input = new StreamInput(is);
        Output output = new StreamOutput(out);

        switch(config.getType()){
            case IFCSUM_D08A:
                IFCSUMD08ATransformer ifcsumd08ATransformer = new IFCSUMD08ATransformer();
                ifcsumd08ATransformer.run(input, output);
                break;
            case IFTFCC_D00B:
                IFTFCCD00BTransformer iftfccd00BTransformer  = new IFTFCCD00BTransformer();
                iftfccd00BTransformer.run(input, output);
                break;
            case IFTMBF_D95B:
                IFTMBFD95BTransformer iftmbfd95BTransformer  = new IFTMBFD95BTransformer();
                iftmbfd95BTransformer.run(input, output);
                break;
            case IFTMBC_D96B:
                IFTMBCD96BTransformer iftmbcd96BTransformer = new IFTMBCD96BTransformer();
                iftmbcd96BTransformer.run(input, output);
                break;
            case IFTMBC_D98A:
                IFTMBCD98ATransformer iftmbcd98ATransformer = new IFTMBCD98ATransformer();
                iftmbcd98ATransformer.run(input, output);
                break;
            case IFTMIN_D96A:
                IFTMIND96ATransformer iftminD96ATransformer = new IFTMIND96ATransformer();
                iftminD96ATransformer.run(input, output);
                break;
            case IFTMIN_D96A_UTF_8:
                IFTMIND96AUTF8Transformer iftmind96AUTF8Transformer = new IFTMIND96AUTF8Transformer();
                iftmind96AUTF8Transformer.run(input, output);
                break;
            case APERAC_D96B:
                APERACD96BTransformer aperacD96BTransformer = new APERACD96BTransformer();
                aperacD96BTransformer.run(input, output);
                break;
            case IFTMBF_D08A:
                IFTMBFD08ATransformer iftmbfd08ATransformer = new IFTMBFD08ATransformer();
                iftmbfd08ATransformer.run(input, output);
                break;
            case IFTMIN_D98A:
                IFTMIND98ATransformer iftminD98ATransformer = new IFTMIND98ATransformer();
                iftminD98ATransformer.run(input, output);
                break;
            case IFTMIN_D99A:
                IFTMIND99ATransformer iftmind99ATransformer = new IFTMIND99ATransformer();
                iftmind99ATransformer.run(input, output);
                break;
            case IFTMIN_D99B:
                IFTMIND99BTransformer iftmind99BTransformer = new IFTMIND99BTransformer();
                iftmind99BTransformer.run(input, output);
                break;
            case DESADV_D93A:
                DESADVD93ATransformer desadvd93ATransformer = new DESADVD93ATransformer();
                desadvd93ATransformer.run(input, output);
                break;
            case DESADV_D96A:
                DESADVD96ATransformer desadvd96ATransformer = new DESADVD96ATransformer();
                desadvd96ATransformer.run(input, output);
                break;
            case ORDERS_D93A:
                ORDERSD93ATransformer ordersd93ATransformer = new ORDERSD93ATransformer();
                ordersd93ATransformer.run(input, output);
                break;
            case XML_TO_IFTFCC_D00B:
                world.dovetail.edifactstandards.xml.transformer.IFTFCCD00BTransformer iftfccd00BTransformerToXml = new world.dovetail.edifactstandards.xml.transformer.IFTFCCD00BTransformer();
                iftfccd00BTransformerToXml.run(input, output);
                break;
            case XML_TO_IFTMBF_D95B:
                world.dovetail.edifactstandards.xml.transformer.IFTMBFD95BTransformer iftmbfd95BTransformerToXml = new world.dovetail.edifactstandards.xml.transformer.IFTMBFD95BTransformer();
                iftmbfd95BTransformerToXml.run(input, output);
                break;
            case XML_TO_IFTMIN_D99B:
                world.dovetail.edifactstandards.xml.transformer.IFTMIND99BTransformer iftmind99BTransformerToXml = new world.dovetail.edifactstandards.xml.transformer.IFTMIND99BTransformer();
                iftmind99BTransformerToXml.run(input, output);
                break;
            case XML_TO_INVOIC_D96A:
                world.dovetail.edifactstandards.xml.transformer.INVOICD96ATransformer invoicd96ATransformer = new world.dovetail.edifactstandards.xml.transformer.INVOICD96ATransformer();
                invoicd96ATransformer.run(input, output);
                break;
            default:
                throw new RuntimeException("Supplied EDIFACT Type is not supported.");

        }

        exchange.getIn().setBody(out);
    }

}
