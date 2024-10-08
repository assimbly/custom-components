package org.assimbly.soap.util.helpers;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.assimbly.soap.domain.SoapHttpHeader;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class WSDLHelperTest {

    private final ClassLoader classLoader = getClass().getClassLoader();
    private final File output = new File("target/test-classes/response.wsdl");
    private ClientAndServer mockServer;

    @BeforeEach
    public void startServer() {
        mockServer = startClientAndServer(1080);
    }

    @AfterEach
    public void stopServer() {
        mockServer.stop();
    }

    @Test
    public void testTokenAuthHasToken() throws Exception {
        mockResult("dummy", "<wsdl/>", 200);

        List<SoapHttpHeader> httpHeaders = new ArrayList<>();
        httpHeaders.add(new SoapHttpHeader("ApiToken", "dummy"));

        WSDLHelper.fetchWSDL(output, "http://127.0.0.1:1080/example", httpHeaders);

        String actual = IOUtils.toString(classLoader.getResourceAsStream("response.wsdl"), StandardCharsets.UTF_8);

        assertEquals("<wsdl/>", actual);
    }

    @Test
    public void testTokenAuthMissingToken() throws Exception {
        mockResult(null, "Unauthorized", 401);

        List<SoapHttpHeader> httpHeaders = new ArrayList<>();

        WSDLHelper.fetchWSDL(output, "http://127.0.0.1:1080/example", httpHeaders);

        String actual = IOUtils.toString(classLoader.getResourceAsStream("response.wsdl"), StandardCharsets.UTF_8);

        assertEquals("Unauthorized", actual);
    }

    private void mockResult(String token, String body, int status) {
        mockServer
                .when(
                        (token != null)
                                ? request()
                                    .withMethod("GET")
                                    .withPath("/example")
                                    .withHeader("ApiToken", token)
                                : request()
                                    .withMethod("GET")
                                    .withPath("/example"),

                        exactly(1))
                .respond(
                        response()
                                .withStatusCode(status)
                                .withBody(body)
                                .withDelay(TimeUnit.SECONDS,1)
                );
    }
}