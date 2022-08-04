package Exceptions;

public class TarjetaNotFoundException extends RuntimeException{
    public TarjetaNotFoundException(String message){
        super(message);
    }
}
