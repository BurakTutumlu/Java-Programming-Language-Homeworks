package User;

public class UserAlreadyExistsException extends Exception {
	
	//If container is not empty, give that operation
	public UserAlreadyExistsException() {
		super();
	}
	
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
