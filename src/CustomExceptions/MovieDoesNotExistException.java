package CustomExceptions;

public class MovieDoesNotExistException extends Exception {

    public MovieDoesNotExistException() { super(); }

    public MovieDoesNotExistException(String message) { super(message); }
}
