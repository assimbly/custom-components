package org.assimbly.auth;

public class InvalidTenantException extends Exception {

    public InvalidTenantException() {
        super("Invalid Tenant");
    }
}
