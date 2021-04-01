package File;

public class InvalidFileFormatException extends Exception {
	
	//If container is not empty, give that operation
	public InvalidFileFormatException() {
		super();
	}
	
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public InvalidFileFormatException(String message) {
		super(message);
	}

}
