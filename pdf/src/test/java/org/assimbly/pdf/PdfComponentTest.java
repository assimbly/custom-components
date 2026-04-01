package org.assimbly.pdf;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.commons.io.IOUtils;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class PdfComponentTest extends CamelTestSupport {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject("mock:out")
    private MockEndpoint resultEndpoint;

    private HttpServer localServer;

    public void startServer() throws Exception {
        byte[] pdfContent = IOUtils.toByteArray(
                classLoader.getResourceAsStream("template.pdf")
        );

        localServer = HttpServer.create(new InetSocketAddress(0), 0); // port 0 = random free port
        localServer.createContext("/pdfs/flowid", exchange -> {

            exchange.getResponseHeaders().set("Content-Type", "application/pdf");
            exchange.sendResponseHeaders(200, pdfContent.length);
            try (var os = exchange.getResponseBody()) {
                os.write(pdfContent);
            }
        });
        localServer.start();
    }

    @AfterEach
    void stopServer() {
        if (localServer != null) {
            localServer.stop(0);
        }
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        startServer();

        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:in")
                        .setHeader("name",  new ConstantExpression("Joery Vreijen"))
                        .setHeader("address",  new ConstantExpression("Meemortel 16"))
                        .setHeader("zip",  new ConstantExpression("6021AE, Budel"))
                        //.to("headerstopdf://http://localhost:" + localServer.getLocalPort() + "/pdfs/flowid?tenant=tenant&uuid=12345")
                        .to("headerstopdf://http://localhost:" + localServer.getAddress().getPort() + "/pdfs/flowid?tenant=tenant&uuid=12345&connection=close")
                        .setHeader(Exchange.FILE_NAME, new ConstantExpression("output.pdf"))
                        .to("mock:out");
            }
        };
    }

    @Test
    void loadFile() throws Exception {

        byte[] expected = IOUtils.toByteArray(Objects.requireNonNull(classLoader.getResource("expected/output.pdf")));

        template.sendBody("direct:in", "");
        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();
        byte[] actual = result.getIn().getBody(byte[].class);

        assertArrayEquals(expected, actual);

    }

}
