package User;

import Product.*;
public class Shop<T extends Product> {
	private ProductInventory<T> inventory;
	private ShopCategory category;
	private String name;
	private String taxNumber;
	
	// Constructor(s)
	public Shop() {
		inventory = new ProductInventory<T>();
	}
	public Shop(ProductInventory<T> inventory) {
		this.inventory = inventory;
	}
	// Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	
	public void AddElement(T item, int count) {
		inventory.addElementToInventory(item, count);
	}
	
	public boolean RemoveElement(T item, int count) {
		return inventory.removeElementFromInventory(item, count);
	}
	
	public ShopCategory getCategory() {
		return category;
	}

	public void setCategory(ShopCategory category) {
		this.category = category;
	}
	
	public String toString() {
		return inventory.toString();
	}

}
