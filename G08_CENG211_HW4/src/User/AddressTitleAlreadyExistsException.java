package User;

public class AddressTitleAlreadyExistsException extends Exception {
	
	//If container is not empty, give that operation
	public AddressTitleAlreadyExistsException() {
		super();
	}
	
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public AddressTitleAlreadyExistsException(String message) {
		super(message);
	}

}

