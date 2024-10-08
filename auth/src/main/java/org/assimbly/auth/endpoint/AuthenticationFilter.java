package org.assimbly.auth.endpoint;

import org.assimbly.auth.endpoint.annotation.Secured;
import org.assimbly.auth.jwt.JwtValidator;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Class acting as a filter for authentication.
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    /**
     * Check if the user who made the request is who he is
     * by validating the given authorization token.
     * Return a 400: Bad Request response when the token is not found.
     * Return a 401: Unauthorized response when the token is not valid.
     *
     * @param requestContext to get all the request data from.
     * @throws IOException when something goes wrong while reading the request.
     */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (token == null || token.isEmpty()) {
            requestContext.abortWith(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity(Errors.INCORRECT_AUTH_HEADER)
                            .build());
        } else if (!JwtValidator.validSession(token)) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity(Errors.UNAUTHORIZED)
                            .build());
        }
    }
}