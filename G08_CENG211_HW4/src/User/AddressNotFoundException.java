package User;

public class AddressNotFoundException extends Exception {
	
	//If container is not empty, give that operation
	public AddressNotFoundException() {
		super();
	}
	
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public AddressNotFoundException(String message) {
		super(message);
	}

}
