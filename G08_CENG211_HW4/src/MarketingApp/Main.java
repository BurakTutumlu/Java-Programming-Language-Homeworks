package MarketingApp;

import Product.ProductNotFoundException;
import Storage.UserContainer;
import User.AddressNotFoundException;
import User.UserNotFoundException;

public class Main {

	
	public static void main(String[] args) throws UserNotFoundException, ProductNotFoundException, AddressNotFoundException {
		MarketingApp app = new MarketingApp();
		app.StartApp();
	}
}
