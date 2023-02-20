package world.dovetail.googledrive.exception;

public class GoogleDriveException extends RuntimeException {

    public GoogleDriveException(String action, String fileRef) {
        super("There was an error while performing the " + action + " of file: " + fileRef);
    }
}
