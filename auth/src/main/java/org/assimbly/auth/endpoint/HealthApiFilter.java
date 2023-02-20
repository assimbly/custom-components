package org.assimbly.auth.endpoint;

import org.assimbly.auth.endpoint.annotation.TokenSecuredApi;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

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
