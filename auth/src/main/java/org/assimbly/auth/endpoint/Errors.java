package org.assimbly.auth.endpoint;

final class Errors {

    static final String INCORRECT_AUTH_HEADER = "Authorization header must be provided";
    static final String UNAUTHORIZED = "Unauthorized";
    static final String INVALID_TENANT = "Invalid tenant";
    static final String FORBIDDEN = "Forbidden";
    static final String MAX_REQUESTS = "Max requests reached";

    private Errors() {
    }
}