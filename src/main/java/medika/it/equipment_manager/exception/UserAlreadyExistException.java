package medika.it.equipment_manager.exception;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String message)
    {
        super(message);
    }
}
