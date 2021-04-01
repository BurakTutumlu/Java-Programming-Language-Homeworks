package Product;

import User.ShopCategory;

public class Product extends ProductInventory {
	private ShopCategory category;
	private String name;
	private double price;
	private double weight;
	private static final double PRODUCT_CARGO_UNIT = 1.0;
	// Constructor(s)
	public Product() {
		category=null;
		name="";
		price=0.0;
		weight=0.0;
	}
	
	public Product(String name) {
		category=null;
		this.name=name;
		price=0.0;
		weight=0.0;
	}
	public Product(ShopCategory category,String name,double price,double weight) {
		this.category=category;
		this.name=name;
		this.price=price;
		this.weight=weight;
	}
	// Getters & Setters
	public ShopCategory getCategory() {
		return category;
	}

	public void setCategory(ShopCategory category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getCargoPrice() {
		return weight * 2.0 * PRODUCT_CARGO_UNIT;
	}
	
	public boolean equals(Product other) {
		return category.equals(other.getCategory()) && name.equals(other.getName()) 
				&& price == other.getPrice() && weight == other.getWeight();
	}
	
	public String toString() {
		return "Category: "+getCategory()+"\n\tName: "+getName()+
				"\n\tPrice: "+getPrice()+"\n\tWeight: "+getWeight()+"\n\tCargo Price: "+getCargoPrice();
	}

}
