package CustomExceptions;

public class MovieAlreadyExistsException extends Exception {

    public MovieAlreadyExistsException() { super(); }

    public MovieAlreadyExistsException(String message) { super(message); }
}
