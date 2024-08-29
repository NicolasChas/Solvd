package Classes.Exceptions;

public class InvalidPassword extends Exception{
    public InvalidPassword(String errorMessage){
        super(errorMessage);
    }
}
