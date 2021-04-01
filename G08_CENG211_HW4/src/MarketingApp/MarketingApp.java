package MarketingApp;

import Storage.UserContainer;
import User.ActiveBalance;
import User.Address;
import User.AddressNotFoundException;
import User.AdminUser;
import User.Customer;
import User.User;
import User.UserNotFoundException;
import User.ShopCategory;
import User.Supplier;
import java.util.ArrayList;
import Product.Product;
import Product.ProductInventory;
import Product.ProductNotFoundException;
import User.Shop;
import Storage.Inventory;

public class MarketingApp {
	private UserContainer userList;
	private User loggedUser;
	private ArrayList<Supplier> validSupplier;
	private ArrayList<Supplier> invalidSupplier;
	private Supplier supplier;
	private Product product;
	private ProductInventory productInventory;
	private Shop basket;
	private Inventory inventory;
	private ActiveBalance activeBalanceCustomer;
	private ActiveBalance activeBalanceSupplier;
	private ActiveBalance activeBalanceAdmin;
	private double moneyCustomer;
	private double moneySupplier;
	private double moneyAdmin;

	public MarketingApp() {
		userList = new UserContainer();
		loggedUser = null;
		invalidSupplier = new ArrayList<Supplier>();
		validSupplier = new ArrayList<Supplier>();
		supplier = new Supplier();
		product = new Product();
		productInventory = new ProductInventory();
		basket = null;
		inventory = null;
		activeBalanceCustomer = new ActiveBalance();
		activeBalanceSupplier = new ActiveBalance();
		activeBalanceAdmin = new ActiveBalance();
		moneyCustomer = 0.0;
		moneySupplier = 0.0;
		moneyAdmin = 0.0;
	}
	
	public void StartApp() throws UserNotFoundException, ProductNotFoundException, AddressNotFoundException {
		// make initializations
		this.userList = Init.makeInit();
		// Start From Hello Screen
		try {
			StartMenu();
			MainScreen();
		}catch(UserNotFoundException e) {
			System.out.println("User not found");
		}catch(ProductNotFoundException e) {
			System.out.println("Product not found");
		}catch(AddressNotFoundException e) {
			System.out.println("Address not found");
		}
	}
	
	public void StartMenu() throws UserNotFoundException, ProductNotFoundException, AddressNotFoundException {
		// print hello screen
		Menu.helloScreen();
		mainLoop: while (true) {
			if(SignIn()) {
				break mainLoop;
			}
			if(MainScreen()) {
				break mainLoop;
			}
			if(invalidSupplierMenu()) {
				break mainLoop;
			}
			if(validSupplierMenu()) {
				break mainLoop;
			}
			if(changeValidation()) {
				break mainLoop;
			}
		}
	}
	// Return true to exit program
	public boolean SignIn() throws UserNotFoundException {
		System.out.println("Type \"q\" for quit.");
		while(true) {
			String username = Menu.enterOption("username");
			// exit
			if (username.equals("q")) {
				System.out.println("you are logged out");
				return true;
			}
			if(!userList.checkUserExists(username)) {
				System.out.println("User "+username+" not found.");
				continue;
			}
			String password = Menu.enterOption("password");
			if(password.equals("")) {
				System.out.println("Password can not be empty");
				continue;
			}
			if(!userList.checkUserExists(username, password)) {
				System.out.println("password is wrong");
				continue;
			}
			else {
				try {
				loggedUser = userList.getUser(username);
				return true;
				}catch(UserNotFoundException e) {
					System.out.println("user not found");
			}
		}
	}
}
	public boolean MainScreen() throws UserNotFoundException, ProductNotFoundException, AddressNotFoundException {
		activeBalanceCustomer = loggedUser.getBalance();
		activeBalanceSupplier = supplier.getBalance();
		moneyCustomer = activeBalanceCustomer.getMoney();
		//moneySupplier = activeBalanceSupplier.getMoney();
		moneyAdmin = activeBalanceAdmin.getMoney();
		if(loggedUser instanceof Customer) {
			System.out.println("Enter a product name\n" + 
		"for quit press 'q'");
			String find;
			System.out.println("how many these products do you want?");
			while(true) {
				try {
					find = Menu.enterOption("product name");
					product = productInventory.findProduct(find);
					String productCount = Menu.enterOption("how many");
					int count = Integer.parseInt(productCount);
					if(find.equals("q") || productCount.equals("q")) {
						System.out.println("You logged out");
						return true;
					}
					if(!(product.equals(null)) && (supplier.getIsValid() == true)) {
						System.out.println("Choose address from your address list");
						int iter = 1;
						for(Address i: (( Customer) loggedUser).getAddressList()) {
							System.out.println(iter + "---" + i);
							iter += 1;
						}
						String whichAddress = Menu.enterOption("press number of address");
						int number = Integer.parseInt(whichAddress);
						for(Address i: ((Customer) loggedUser).getAddressList()) {
							System.out.println(iter + "---" + i);
							iter += 1;
							if(number == iter) {
								i = ((Customer) loggedUser).getAddressList().get(iter);
								System.out.println("your address is " + i);
								break;
							}
						}
						moneyCustomer = moneyCustomer - ((product.getPrice()*count) + (product.getCargoPrice()*count));
						moneySupplier = moneySupplier + ((product.getPrice()*count) + (product.getCargoPrice()*count));
						moneyAdmin = moneyAdmin + (((product.getPrice()*count) + (product.getCargoPrice()*count))/50);
						//basket.addElementToInventory(product, count);
						inventory.addElementToInventory(product, count);
						productInventory.removeElementFromInventory(product, count);
						System.out.println(basket);
						return true;
					}
				}catch(ProductNotFoundException e) {
						System.out.println("Product not found.");
				 }
			return true;}
		}

		
		if(loggedUser instanceof Supplier) {
			if(((Supplier) loggedUser).getIsValid() == false) {
				System.out.println("You can not purchase");
				return true;
			}
			else {
				System.out.println("For purchase press title of your address for delivery location");
				String address = Menu.enterOption("address");
				while(true) {
						if(address.equals("q")) {
							break;
						}
						if(((Supplier) loggedUser).getAddress(address).equals(address)) {
							System.out.println("purchase is successfull");
							break;
					}
				}
			}
		}
		
		
		if(loggedUser instanceof AdminUser) {
			System.out.println("If you want to see Houseware Supplier press 1\n" + "If you want to see Accessories Supplier press 2\n" +
					"If you want to see Electronic Supplier press 3\n" + "If you want to see Cosmetic Supplier press 4\n" + " for quit press 'q'\n");
			String sup;
			while(true) {
				try {
					sup = Menu.enterOption("Supplier");
					if(sup.equals("q")) {
						System.out.println("you are logged out");
						break;
					}
					if(sup.equals("1")) {
						System.out.println(userList.getSupplierByCategory(ShopCategory.HOUSEWARE).getShop());
						break;
					}
					if(sup.equals("2")) {
						System.out.println(userList.getSupplierByCategory(ShopCategory.ACCESSORIES).getShop());
						break;
					}
					if(sup.equals("3")) {
						System.out.println(userList.getSupplierByCategory(ShopCategory.ELECTRONIC).getShop());
						break;
					}
					if(sup.contentEquals("4")){
						System.out.println(userList.getSupplierByCategory(ShopCategory.COSMETIC).getShop());
						break;
					}
					else {
						System.out.println("Enter a valid option");
					}
					}catch(UserNotFoundException e) {
				System.out.println("User not found");
				}		
		}
			seeMenu();
			changeValidation();
			}
		return true;
		}

	public boolean invalidSupplierMenu() {
		for(Supplier supplier: userList.getSupplierList()) {
			if(supplier.getIsValid() == false) {
				System.out.println(supplier);
				invalidSupplier.add(supplier);
			}
			if(supplier.getIsValid() == true) {
				invalidSupplier.remove(supplier);
			}	
		}
		if(userList.getSupplierList().size() == 0) {
			System.out.println("This menu is empty");
		}
		return true;
	}
	
	public boolean validSupplierMenu() {
		for(Supplier supplier: userList.getSupplierList()) {
			if(supplier.getIsValid() == true) {
				System.out.println(supplier);
				validSupplier.add(supplier);
			}
			if(supplier.getIsValid() == false) {
				validSupplier.remove(supplier);
			}
			if(userList.getSupplierList().size() == 0) {
				System.out.println("This menu is empty");
		}
		}
		return true;
	}
	
	public void seeMenu() {
		System.out.println("For quit press 0, for Invalid Supplier Menu prees 1, for Valid Supplier Menu press 2");
		String supplierMenu;
		while(true) {
			supplierMenu = Menu.enterOption("Supplier Menu");
			if(supplierMenu.equals("0")) {
				break;
			}
			if(supplierMenu.equals("1")){
				invalidSupplierMenu();
				continue;
			}
			if(supplierMenu.equals("2")) {
				validSupplierMenu();
				continue;
			}
			else {
				System.out.println("Please, enter a valid option");
		}
	}
}
	public boolean changeValidation() throws UserNotFoundException{
		System.out.println("If you want to change the validation write Shop Category for example; 'electronic', for quit press 'q'");
		String category;
		String validation;
		while(true) {
			try {
				category = Menu.enterOption("category");
				if(category.equals("q")) {
					break;
				}
				if(category.equals("electronic")) {
					System.out.println("Electronic supplier validation is now " + userList.getSupplierByCategory(ShopCategory.ELECTRONIC).getIsValid() + "");
					command();
					validation = Menu.enterOption("validation");
					if(validation.equals("q")) {
						break;
					}
					if(validation.equals("valid")){
						userList.getSupplierByCategory(ShopCategory.ELECTRONIC).setIsValid(true);
						continue;
					}
					if(validation.equals("invalid")) {
						userList.getSupplierByCategory(ShopCategory.ELECTRONIC).setIsValid(false);
						continue;
					}
					else {
						System.out.println("Please, enter a valid option");
					}}
				if(category.equals("houseware")) {
					System.out.println("Electronic supplier validation is now " + userList.getSupplierByCategory(ShopCategory.HOUSEWARE).getIsValid() + "");
					command();
					validation = Menu.enterOption("validation");
					if(validation.equals("q")){
							break;
					}
					if(validation.equals("valid")){
						userList.getSupplierByCategory(ShopCategory.HOUSEWARE).setIsValid(true);
						continue;
					}
					if(validation.equals("invalid")) {
						userList.getSupplierByCategory(ShopCategory.HOUSEWARE).setIsValid(false);
						continue;
					}
					else {
						System.out.println("Please, enter a valid option");
					}
				}
				if(category.equals("accessories")) {
					System.out.println("Electronic supplier validation is now " + userList.getSupplierByCategory(ShopCategory.ACCESSORIES).getIsValid() + "");
					command();
					validation = Menu.enterOption("validation");
					if(validation.equals("q")) {
						break;
					}
					if(validation.equals("valid")){
						userList.getSupplierByCategory(ShopCategory.ACCESSORIES).setIsValid(true);
						continue;
					}
					if(validation.equals("invalid")) {
						userList.getSupplierByCategory(ShopCategory.ACCESSORIES).setIsValid(false);
						continue;
					}
					else {
						System.out.println("Please, enter a valid option");
					}}
				if(category.equals("cosmetic")) {
					System.out.println("Electronic supplier validation is now " + userList.getSupplierByCategory(ShopCategory.COSMETIC).getIsValid() + "");
					command();
					validation = Menu.enterOption("validation");
					if(validation.equals("q")) {
						break;
					}
					if(validation.equals("valid")){
						userList.getSupplierByCategory(ShopCategory.COSMETIC).setIsValid(true);
						continue;
					}
					if(validation.equals("invalid")) {
						userList.getSupplierByCategory(ShopCategory.COSMETIC).setIsValid(false);
						continue;
					}
					else {
						System.out.println("Please, enter a valid option");
					}}
				else {
					System.out.println("Please, enter a valid option");
				}
			}catch(UserNotFoundException e) {
				System.out.println("User not found ");
			}}
		return true;}

	public void command() {
		System.out.println("If you want to validation true enter 'valid', to validation false enter 'invalid'");
	}
	/*public void deneme() throws ProductNotFoundException {
		for(Supplier s: userList.getSupplierList()){
			if(s.getIsValid() == false) {
				System.out.println(s);
			}
		}
		System.out.println(userList.getSupplierList());
		product = product.findProduct("mascara");
		product.addElementToInventory(product, 1);	

	}*/
}

