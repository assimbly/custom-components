package org.assimbly.auth.endpoint;

import org.assimbly.auth.endpoint.annotation.TokenSecuredApi;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@TokenSecuredApi
@Provider
public class HealthApiFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        String token = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (token != null && token.equals(System.getenv("HEALTH_API_TOKEN")))
            return;

        containerRequestContext.abortWith(
                Response.status(Response.Status.FORBIDDEN)
                        .entity(Errors.FORBIDDEN)
                        .build());
    }
}
