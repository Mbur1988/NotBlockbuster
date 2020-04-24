package CustomExceptions;

public class MemberDoesNotExistException extends Exception {

    public MemberDoesNotExistException() { super(); }

    public MemberDoesNotExistException(String message) { super(message); }
}
