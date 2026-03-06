package org.assimbly.pdf;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.commons.io.IOUtils;
import org.apache.hc.core5.http.impl.bootstrap.HttpServer;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.util.Timeout;
import org.junit.jupiter.api.AfterEach;
import org.assimbly.pdf.handler.BasicValidationHandler;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

class PdfComponentTest extends CamelTestSupport {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject("mock:out")
    private MockEndpoint resultEndpoint;

    private HttpServer localServer;

    public void startServer() throws Exception {
        byte[] pdfContent = IOUtils.toByteArray(classLoader.getResourceAsStream("template.pdf"));
        BasicValidationHandler handler = new BasicValidationHandler("GET", "tenant=tenant&uuid=12345", pdfContent);

        localServer = ServerBootstrap.bootstrap()
                .setListenerPort(8080)
                .setSocketConfig(SocketConfig.custom()
                        .setSoTimeout(Timeout.ofSeconds(5))
                        .build())
                .register("/pdfs/flowid", handler)
                .create();

        localServer.start();
    }

    @AfterEach
    void stopServer() {

        if (localServer != null) {
            localServer.stop();
        }
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        startServer();
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:in")
                        .setHeader("name",  new ConstantExpression("Joery Vreijen"))
                        .setHeader("address",  new ConstantExpression("Meemortel 16"))
                        .setHeader("zip",  new ConstantExpression("6021AE, Budel"))
                        .to("pdf-transform://http://localhost:" + localServer.getLocalPort() + "/pdfs/flowid?tenant=tenant&uuid=12345")
                        .setHeader(Exchange.FILE_NAME, new ConstantExpression("output.pdf"))
                        .to("mock:out");
            }
        };
    }

    @Test
    void loadFile() throws Exception {
        template.sendBody("direct:in", "");

        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        assertArrayEquals(IOUtils.toByteArray(Objects.requireNonNull(classLoader.getResource("expected/output.pdf"))), result.getIn().getBody(byte[].class));
    }
}
