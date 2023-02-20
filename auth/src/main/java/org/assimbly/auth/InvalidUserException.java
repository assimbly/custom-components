package org.assimbly.auth;

public class InvalidUserException extends Exception {

    public InvalidUserException() {
        super("Invalid User");
    }
}
