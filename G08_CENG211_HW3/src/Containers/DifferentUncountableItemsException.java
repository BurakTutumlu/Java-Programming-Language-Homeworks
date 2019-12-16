package Containers;

public class DifferentUncountableItemsException extends Exception{
	
	//we should throw an exception when uncountable items try to gather at the same time.
	public DifferentUncountableItemsException() {
		// TODO Auto-generated constructor stub
		super("Items are uncountable, they can not mix");
	}
	
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public DifferentUncountableItemsException(String message) {
		super(message);
	}
}
