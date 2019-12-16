package Ingredient;

public class ItemNotUncountableException extends Exception{
	//an exception when uncountable items 
	public ItemNotUncountableException() { 
		super("Item is not uncountable");
	}
	
	public ItemNotUncountableException(String message) {
		super(message);
	}
}