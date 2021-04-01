package Product;

public class ProductNotFoundException extends Exception {
	
	//If container is not empty, give that operation
	public ProductNotFoundException() {
		super();
	}
	
	//we called exception constructor in both constructors, if you want to overload, you can give a message
	public ProductNotFoundException(String message) {
		super(message);
	}

}
