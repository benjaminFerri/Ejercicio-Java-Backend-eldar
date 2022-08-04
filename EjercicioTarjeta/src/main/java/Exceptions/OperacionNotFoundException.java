package Exceptions;

public class OperacionNotFoundException extends RuntimeException {
    public OperacionNotFoundException(String message){
        super(message);
    }
}
