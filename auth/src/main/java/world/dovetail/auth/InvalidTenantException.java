package world.dovetail.auth;

public class InvalidTenantException extends Exception {

    public InvalidTenantException() {
        super("Invalid Tenant");
    }
}
