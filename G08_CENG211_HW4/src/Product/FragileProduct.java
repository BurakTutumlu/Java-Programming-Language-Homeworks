package Product;

import User.ShopCategory;

public class FragileProduct extends Product {
	private static final double FRAGILE_PRODUCT_CARGO_UNIT = 4.5;
	public FragileProduct() {
		// TODO Auto-generated constructor stub
	}

	public FragileProduct(String name) {
		super(name);
	}

	public FragileProduct(ShopCategory category, String name, double price, double weight) {
		super(category, name, price, weight);
	}
	
	@Override
	public double getCargoPrice() {
		return this.getWeight() * 2.0 * FRAGILE_PRODUCT_CARGO_UNIT;
	}
}
