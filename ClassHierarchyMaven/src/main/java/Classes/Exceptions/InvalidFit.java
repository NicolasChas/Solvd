package Classes.Exceptions;

public class InvalidFit extends Exception{
    public InvalidFit(String errorMessage){
        super(errorMessage);
    }
}