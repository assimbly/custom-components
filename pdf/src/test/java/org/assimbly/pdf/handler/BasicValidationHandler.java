package org.assimbly.pdf.handler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.protocol.HttpContext;

/**
 * BasicValidationHandler updated for HttpClient 5
 */
public class BasicValidationHandler implements HttpRequestHandler {

    protected String expectedMethod;
    protected String expectedQuery;
    protected byte[] responseContent;

    public BasicValidationHandler(String expectedMethod, String expectedQuery, byte[] responseContent) {
        this.expectedMethod = expectedMethod;
        this.expectedQuery = expectedQuery;
        this.responseContent = responseContent;
    }

    @Override
    public void handle(final ClassicHttpRequest request, final ClassicHttpResponse response,
                       final HttpContext context) throws HttpException, IOException {

        // 1. request.getRequestLine().getMethod() -> request.getMethod()
        if (expectedMethod != null && !expectedMethod.equals(request.getMethod())) {
            // 2. setStatusCode(int) -> setCode(int)
            response.setCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
            return;
        }

        if (!validateQuery(request)) {
            response.setCode(HttpStatus.SC_BAD_REQUEST);
            return;
        }

        response.setCode(HttpStatus.SC_OK);
        if (responseContent != null) {
            // 3. ByteArrayEntity now requires a ContentType (usually APPLICATION_OCTET_STREAM for raw bytes)
            response.setEntity(new ByteArrayEntity(responseContent, ContentType.APPLICATION_OCTET_STREAM));
        }
    }

    protected boolean validateQuery(ClassicHttpRequest request) throws IOException {
        try {
            // 4. request.getRequestLine().getUri() -> request.getPath() or request.getRequestUri()
            String query = new URI(request.getPath()).getQuery();
            if (expectedQuery != null && !expectedQuery.equals(query)) {
                return false;
            }
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
        return true;
    }
}