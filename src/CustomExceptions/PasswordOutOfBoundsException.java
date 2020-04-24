package CustomExceptions;

public class PasswordOutOfBoundsException extends Exception {

    public PasswordOutOfBoundsException() { super(); }

    public PasswordOutOfBoundsException(String message) { super(message); }
}
