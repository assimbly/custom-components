package org.assimbly.encoder;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.assimbly.util.OSUtil;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EncoderComponentTest extends CamelTestSupport {

    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                from("direct:transform")
                        .to("encoder://CP850?targetCharset=RAW(UTF-8)")
                        .to("mock:out");
            }
        };
    }

    @Test
    public void encoderTransformationTest() throws IOException {

        template.sendBody("direct:transform", new File("src/test/resources/IFTMIN_D96A_CP850.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(this.getClass().getResourceAsStream("/expected/IFTMIN_D96A_UTF_8.edi"),"UTF-8").replace("\n", "\r\n");

        expected = expected.replace("\n", "").replace("\r", "");
        actual = actual.replace("\n", "").replace("\r", "");

        //skip test when on Windows
        if(!OSUtil.getOS().equals(OSUtil.OS.WINDOWS)){
            assertEquals(expected, actual);
        }

    }

}
