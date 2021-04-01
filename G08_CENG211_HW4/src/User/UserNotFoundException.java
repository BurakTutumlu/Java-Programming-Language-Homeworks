package User;

public class UserNotFoundException extends Exception {
	
	//If container is not empty, give that operation
	public UserNotFoundException() {
		super();
	}
	
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public UserNotFoundException(String message) {
		super(message);
	}

}
