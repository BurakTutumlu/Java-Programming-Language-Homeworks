package Containers;

public class InvalidItemTypePassedException extends Exception {
	
	//you should add item according to the instance of a class.
	public InvalidItemTypePassedException() {
		super();
	}
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public InvalidItemTypePassedException(String message) {
		super(message);
	}

}
