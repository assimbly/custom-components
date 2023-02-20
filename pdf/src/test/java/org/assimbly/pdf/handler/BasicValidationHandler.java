package org.assimbly.pdf.handler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.util.EntityUtils;

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

    public void handle(final HttpRequest request, final HttpResponse response,
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

    protected boolean validateQuery(HttpRequest request) throws IOException {
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