package world.dovetail.sql.exception;

public class SQLException extends RuntimeException {

    public SQLException() {
    }

    public SQLException(String s) {
        super(s);
    }

    public SQLException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SQLException(Throwable throwable) {
        super(throwable);
    }

}
