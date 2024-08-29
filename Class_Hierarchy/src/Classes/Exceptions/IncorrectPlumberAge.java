package Classes.Exceptions;

public class IncorrectPlumberAge extends RuntimeException{
    public IncorrectPlumberAge(String errorMessage){
        super(errorMessage);
    }
}