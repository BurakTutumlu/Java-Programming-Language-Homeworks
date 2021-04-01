package Product;

import User.ShopCategory;

public class FastConsumptionProduct extends Product {
	private static final double FRAGILE_PRODUCT_CARGO_UNIT = 3.5;
	public FastConsumptionProduct() {
		// TODO Auto-generated constructor stub
	}

	public FastConsumptionProduct(String name) {
		super(name);
	}

	public FastConsumptionProduct(ShopCategory category, String name, double price, double weight) {
		super(category, name, price, weight);
	}
	
	@Override
	public double getCargoPrice() {
		return this.getWeight() * 2.0 * FRAGILE_PRODUCT_CARGO_UNIT;
	}
}
