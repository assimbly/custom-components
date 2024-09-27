package org.assimbly.pdf;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.junit.jupiter.api.AfterEach;
import org.assimbly.pdf.handler.BasicValidationHandler;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Objects;

public class PdfComponentTest extends CamelTestSupport {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject("mock:out")
    private MockEndpoint resultEndpoint;

    private HttpServer localServer;

    public void startServer() throws Exception {
        localServer = ServerBootstrap.bootstrap().
                setHttpProcessor(null).
                setConnectionReuseStrategy(null).
                setResponseFactory(null).
                setExpectationVerifier(null).
                setSslContext(null).
                registerHandler("/pdfs/flowid", new BasicValidationHandler("GET", "tenant=tenant&uuid=12345", IOUtils.toByteArray(classLoader.getResourceAsStream("template.pdf"))))
                .create();
        localServer.start();
    }

    @AfterEach
    public void stopServer() throws Exception {

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
    public void loadFile() throws Exception {
        template.sendBody("direct:in", "");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        assertArrayEquals(IOUtils.toByteArray(Objects.requireNonNull(classLoader.getResource("expected/output.pdf"))), result.getIn().getBody(byte[].class));
    }
}
