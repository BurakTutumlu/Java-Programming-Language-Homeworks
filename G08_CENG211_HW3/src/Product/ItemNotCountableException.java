package Product;

public class ItemNotCountableException extends Exception{
	
	public ItemNotCountableException() { 
		super("Item is not uncountable");
	}
	
	public ItemNotCountableException(String message) {
		super(message);
	}
}
