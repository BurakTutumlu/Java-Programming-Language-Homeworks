package Containers;

public class ContainerIsNotEmptyException extends Exception {
	
	//If container is not empty, give that operation
	public ContainerIsNotEmptyException() {
		super();
	}
	
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public ContainerIsNotEmptyException(String message) {
		super(message);
	}

}
