package User;

import Product.*;

public class Supplier extends RegularUser {
	private boolean isValid;
	private Shop<Product> shop;
	private ProductInventory<Product> oldProducts;
	// Constructor(s)
	public Supplier() {
		super();
		shop = new Shop<>();
		setIsValid(isValid);
	}

	public Supplier(String username, String password) {
		super(username, password);
		shop = new Shop<>();
	}
	public Supplier(String username, String password,ActiveBalance balance) {
		super(username, password,balance);
		shop = new Shop<>();
		oldProducts = new ProductInventory<>();
	}


	public Supplier(String username, String password, ContactInfo contactInfo) {
		super(username, password, contactInfo);
		shop = new Shop<>();
		oldProducts = new ProductInventory<>();
	}
	
	public Supplier(String username, String password, ContactInfo contactInfo,Shop<Product> shop) {
		super(username, password, contactInfo);
		this.shop = shop;
		oldProducts = new ProductInventory<>();
	}

	// Getters & Setters
	public Shop<Product> getShop() {
		return shop;
	}

	public void setShop(Shop<Product> shop) {
		this.shop = shop;
	}
	
	public ShopCategory getShopCategory() {
		return shop.getCategory();
	}
	
	public void addItemToShop(Product item, int count) {
		shop.AddElement(item, count);
	}
	public String toString() {
		return shop.toString();
	}
	
	public boolean getIsValid() {
		return isValid;
	}
	
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;	
	}
}
