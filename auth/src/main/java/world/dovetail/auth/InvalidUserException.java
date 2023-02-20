package world.dovetail.auth;

public class InvalidUserException extends Exception {

    public InvalidUserException() {
        super("Invalid User");
    }
}
