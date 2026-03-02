package org.assimbly.pdf.handler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;

/**
 *
 * @version
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

    public void handle(final ClassicHttpRequest request, final ClassicHttpResponse response,
                       final HttpContext context) throws HttpException, IOException {

        if (expectedMethod != null && !expectedMethod.equals(request.getRequestLine().getMethod())) {
            response.setStatusCode(HttpStatus.SC_METHOD_FAILURE);
            return;
        }

        if (!validateQuery(request)) {
            response.setStatusCode(HttpStatus.SC_BAD_REQUEST);
            return;
        }

        response.setStatusCode(HttpStatus.SC_OK);
        if (responseContent != null) {
            response.setEntity(new ByteArrayEntity(responseContent));
        }
    }

    protected boolean validateQuery(ClassicHttpRequest request) throws IOException {
        try {
            String query = new URI(request.getRequestLine().getUri()).getQuery();
            if (expectedQuery != null && !expectedQuery.equals(query)) {
                return false;
            }
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
        return true;
    }
}