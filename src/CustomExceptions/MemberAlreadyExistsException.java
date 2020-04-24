package CustomExceptions;

public class MemberAlreadyExistsException extends Exception {

    public MemberAlreadyExistsException() { super(); }

    public MemberAlreadyExistsException(String message) { super(message); }
}
