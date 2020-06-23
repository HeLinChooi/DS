package chap3;

public class EmptyInputException extends Exception {
    public EmptyInputException() {
        super("Empty Input Exception");
    }

    public EmptyInputException(String s) {
        super(s);
    }
}
